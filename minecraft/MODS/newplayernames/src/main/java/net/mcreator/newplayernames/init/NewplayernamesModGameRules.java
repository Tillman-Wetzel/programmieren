/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.newplayernames.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NewplayernamesModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> PLAYERS_USE_ORIGINAL_NAME = GameRules.register("playersUseOriginalName", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.BooleanValue> OPS_USE_OWN_NAME = GameRules.register("opsUseOwnName", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}