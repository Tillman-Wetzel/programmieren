/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmodvontillman.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.testmodvontillman.fluid.types.HotWaterFluidType;
import net.mcreator.testmodvontillman.TestmodVonTillmanMod;

public class TestmodVonTillmanModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, TestmodVonTillmanMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> HOT_WATER_TYPE = REGISTRY.register("hot_water", HotWaterFluidType::new);
}