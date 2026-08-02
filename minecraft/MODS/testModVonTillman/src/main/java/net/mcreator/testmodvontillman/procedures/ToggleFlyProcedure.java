package net.mcreator.testmodvontillman.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModGameRules;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModAttributes;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ToggleFlyProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(TestmodVonTillmanModGameRules.LET_EVERYONE_FLY.get())) {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = true;
				_player.onUpdateAbilities();
			}
		} else {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = ((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(TestmodVonTillmanModAttributes.CAN_FLY)
						? _livingEntity2.getAttribute(TestmodVonTillmanModAttributes.CAN_FLY).getValue()
						: 0) == 1);
				_player.onUpdateAbilities();
			}
		}
		if (entity instanceof Player _plr4 && _plr4.gameMode() == GameType.CREATIVE) {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = true;
				_player.onUpdateAbilities();
			}
		}
	}
}