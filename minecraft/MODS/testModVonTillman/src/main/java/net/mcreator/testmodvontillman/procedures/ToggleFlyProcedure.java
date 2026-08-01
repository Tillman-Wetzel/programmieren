package net.mcreator.testmodvontillman.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModGameRules;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class ToggleFlyProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof Player _player) {
				_player.getAbilities().mayfly = (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(TestmodVonTillmanModGameRules.LET_EVERYONE_FLY.get()));
				_player.onUpdateAbilities();
			}
			if (entityiterator instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) {
				if (entityiterator instanceof Player _player) {
					_player.getAbilities().mayfly = true;
					_player.onUpdateAbilities();
				}
			}
		}
	}
}