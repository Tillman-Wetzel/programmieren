/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kristallmodwoichkeinbockdraufhab.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.kristallmodwoichkeinbockdraufhab.client.renderer.KrystalSpiderRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class KristallmodwoichkeinbockdraufhabModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(KristallmodwoichkeinbockdraufhabModEntities.KRYSTAL_SPIDER.get(), KrystalSpiderRenderer::new);
		event.registerEntityRenderer(KristallmodwoichkeinbockdraufhabModEntities.FLYING_AMETHYST_SHARF.get(), ThrownItemRenderer::new);
	}
}