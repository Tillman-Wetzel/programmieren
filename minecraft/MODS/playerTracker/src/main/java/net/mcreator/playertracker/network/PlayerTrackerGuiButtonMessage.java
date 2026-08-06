package net.mcreator.playertracker.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.playertracker.procedures.ToggleModeProcedure;
import net.mcreator.playertracker.procedures.RemoveYourselfButtonPressedProcedure;
import net.mcreator.playertracker.procedures.AddYourselfButtonPressedProcedure;
import net.mcreator.playertracker.PlayertrackerMod;

@EventBusSubscriber
public record PlayerTrackerGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PlayerTrackerGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PlayertrackerMod.MODID, "player_tracker_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PlayerTrackerGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerTrackerGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PlayerTrackerGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PlayerTrackerGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PlayerTrackerGuiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			AddYourselfButtonPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			RemoveYourselfButtonPressedProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			ToggleModeProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PlayertrackerMod.addNetworkMessage(PlayerTrackerGuiButtonMessage.TYPE, PlayerTrackerGuiButtonMessage.STREAM_CODEC, PlayerTrackerGuiButtonMessage::handleData);
	}
}