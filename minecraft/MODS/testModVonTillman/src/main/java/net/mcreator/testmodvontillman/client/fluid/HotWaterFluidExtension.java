package net.mcreator.testmodvontillman.client.fluid;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.Camera;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluids;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluidTypes;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class HotWaterFluidExtension {
	@SubscribeEvent
	public static void registerRegisterFluidModels(RegisterFluidModelsEvent event) {
		event.register(new FluidModel.Unbaked(new Material(Identifier.parse("minecraft:block/water_still")), new Material(Identifier.parse("minecraft:block/water_flow")), null, null), TestmodVonTillmanModFluids.HOT_WATER,
				TestmodVonTillmanModFluids.FLOWING_HOT_WATER);
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			@Override
			public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {
				float nearDistance = fogData.environmentalStart;
				float farDistance = fogData.environmentalEnd;
				Entity entity = camera.entity();
				Level world = entity.level();
				fogData.environmentalStart = 0f;
				fogData.environmentalEnd = Math.min(48f, renderDistance);
			}
		}, TestmodVonTillmanModFluidTypes.HOT_WATER_TYPE);
	}
}