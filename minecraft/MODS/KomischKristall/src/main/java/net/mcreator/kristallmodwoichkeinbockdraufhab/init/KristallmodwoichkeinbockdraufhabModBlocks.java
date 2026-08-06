/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kristallmodwoichkeinbockdraufhab.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.kristallmodwoichkeinbockdraufhab.block.SkulkDimensionPortalBlock;
import net.mcreator.kristallmodwoichkeinbockdraufhab.block.KristalDimensionPortalBlock;
import net.mcreator.kristallmodwoichkeinbockdraufhab.KristallmodwoichkeinbockdraufhabMod;

import java.util.function.Function;

public class KristallmodwoichkeinbockdraufhabModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(KristallmodwoichkeinbockdraufhabMod.MODID);
	public static final DeferredBlock<Block> KRISTAL_DIMENSION_PORTAL;
	public static final DeferredBlock<Block> SKULK_DIMENSION_PORTAL;
	static {
		KRISTAL_DIMENSION_PORTAL = register("kristal_dimension_portal", KristalDimensionPortalBlock::new);
		SKULK_DIMENSION_PORTAL = register("skulk_dimension_portal", SkulkDimensionPortalBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}