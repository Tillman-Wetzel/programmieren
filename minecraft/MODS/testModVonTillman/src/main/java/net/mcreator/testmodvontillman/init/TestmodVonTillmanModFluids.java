/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmodvontillman.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.testmodvontillman.fluid.HotWaterFluid;
import net.mcreator.testmodvontillman.TestmodVonTillmanMod;

public class TestmodVonTillmanModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, TestmodVonTillmanMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> HOT_WATER = REGISTRY.register("hot_water", HotWaterFluid.Source::new);
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_HOT_WATER = REGISTRY.register("flowing_hot_water", HotWaterFluid.Flowing::new);
}