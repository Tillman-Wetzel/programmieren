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
public class OnPlayerDeathProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity(), event.isEndConquered());
	}

	public static void execute(LevelAccessor world, Entity entity, boolean endconquered) {
		execute(null, world, entity, endconquered);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, boolean endconquered) {
		if (entity == null)
			return;
		boolean useOwnName = false;
		if (!endconquered) {
			if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(NewplayernamesModAttributes.ORIGINAL_DIED.get()))
				_livingEntity0.getAttribute(NewplayernamesModAttributes.ORIGINAL_DIED.get()).setBaseValue(1);
			if (world.getLevelData().getGameRules().getBoolean(NewplayernamesModGameRules.OPS_USE_OWN_NAME) && entity.hasPermissions(1) || (world.getLevelData().getGameRules().getInt(NewplayernamesModGameRules.PLAYERS_USE_ORIGINAL_NAME)) == 2) {
				useOwnName = true;
			} else {
				useOwnName = false;
			}
		}
		SetNewNameProcedure.execute(entity, useOwnName);
	}
}