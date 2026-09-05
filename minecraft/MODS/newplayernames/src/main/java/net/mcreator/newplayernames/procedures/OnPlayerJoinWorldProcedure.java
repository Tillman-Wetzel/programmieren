package net.mcreator.newplayernames.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.newplayernames.init.NewplayernamesModGameRules;
import net.mcreator.newplayernames.init.NewplayernamesModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerJoinWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean useOwnName = false;
		if (world.getLevelData().getGameRules().getBoolean(NewplayernamesModGameRules.OPS_USE_OWN_NAME) && entity.hasPermissions(1)) {
			useOwnName = true;
		} else if ((world.getLevelData().getGameRules().getInt(NewplayernamesModGameRules.PLAYERS_USE_ORIGINAL_NAME)) == 0) {
			useOwnName = false;
		} else if ((world.getLevelData().getGameRules().getInt(NewplayernamesModGameRules.PLAYERS_USE_ORIGINAL_NAME)) == 1) {
			if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(NewplayernamesModAttributes.ORIGINAL_DIED.get())
					? _livingEntity4.getAttribute(NewplayernamesModAttributes.ORIGINAL_DIED.get()).getValue()
					: 0) == 0) {
				useOwnName = true;
			} else {
				useOwnName = false;
			}
		} else if ((world.getLevelData().getGameRules().getInt(NewplayernamesModGameRules.PLAYERS_USE_ORIGINAL_NAME)) == 2) {
			useOwnName = true;
		} else {
			useOwnName = false;
		}
		SetNewNameProcedure.execute(entity, useOwnName);
	}
}