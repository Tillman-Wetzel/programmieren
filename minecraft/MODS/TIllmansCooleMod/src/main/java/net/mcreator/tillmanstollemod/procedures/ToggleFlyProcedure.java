package net.mcreator.tillmanstollemod.procedures;

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

import net.mcreator.tillmanstollemod.init.TillmanstollemodModGameRules;
import net.mcreator.tillmanstollemod.init.TillmanstollemodModAttributes;

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
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(TillmanstollemodModGameRules.LET_EVERYONE_FLY.get())) {
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = true;
				_player.onUpdateAbilities();
			}
		} else {
			if (!(entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE)) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(TillmanstollemodModAttributes.CAN_FLY)
							? _livingEntity3.getAttribute(TillmanstollemodModAttributes.CAN_FLY).getValue()
							: 0) > 0);
					_player.onUpdateAbilities();
				}
			} else {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = true;
					_player.onUpdateAbilities();
				}
			}
		}
	}
}