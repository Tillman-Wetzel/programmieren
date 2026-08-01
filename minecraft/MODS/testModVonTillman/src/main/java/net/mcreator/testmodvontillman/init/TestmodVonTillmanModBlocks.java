/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmodvontillman.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.testmodvontillman.block.TeapotBlock;
import net.mcreator.testmodvontillman.block.HotWaterBlock;
import net.mcreator.testmodvontillman.TestmodVonTillmanMod;

import java.util.function.Function;

public class TestmodVonTillmanModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TestmodVonTillmanMod.MODID);
	public static final DeferredBlock<Block> HOT_WATER;
	public static final DeferredBlock<Block> TEAPOT;
	static {
		HOT_WATER = register("hot_water", HotWaterBlock::new);
		TEAPOT = register("teapot", TeapotBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}