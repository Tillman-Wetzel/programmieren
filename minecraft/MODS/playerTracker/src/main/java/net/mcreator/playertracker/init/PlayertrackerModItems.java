/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playertracker.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.playertracker.PlayertrackerMod;

public class PlayertrackerModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PlayertrackerMod.MODID);
	public static final DeferredItem<Item> PLAYER_TRACKER_BLOCK;
	static {
		PLAYER_TRACKER_BLOCK = block(PlayertrackerModBlocks.PLAYER_TRACKER_BLOCK, new Item.Properties().stacksTo(4));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}