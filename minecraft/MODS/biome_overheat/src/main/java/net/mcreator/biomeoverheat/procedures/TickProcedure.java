package net.mcreator.biomeoverheat.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.biomeoverheat.network.BiomeOverheatModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double biomeTemperaturEdited = 0;
		biomeTemperaturEdited = (world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f) / 100d - 0.75;
		if (Math.abs(entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur) <= 1 && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			{
				var _playerVars = entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.Temperatur = 0;
					_playerVars.markSyncDirty();
				}
			}
		} else if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			{
				var _playerVars = entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.Temperatur = entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur
							+ (entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur
									/ Math.abs(entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur) == 1 ? 1 : -1);
					_playerVars.markSyncDirty();
				}
			}
		} else {
			{
				var _playerVars = entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.Temperatur = entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur + biomeTemperaturEdited;
					_playerVars.markSyncDirty();
				}
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + entity.getCapability(BiomeOverheatModVariables.PLAYER_VARIABLES).orElseGet(BiomeOverheatModVariables.PlayerVariables::new).Temperatur)), true);
	}
}