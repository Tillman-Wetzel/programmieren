/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.playertracker.block.PlayerTrackerBlockBlock;
import net.mcreator.playertracker.PlayertrackerMod;

public class PlayertrackerModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PlayertrackerMod.MODID);
	public static final DeferredBlock<Block> PLAYER_TRACKER_BLOCK;
	static {
		PLAYER_TRACKER_BLOCK = REGISTRY.register("player_tracker_block", PlayerTrackerBlockBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}