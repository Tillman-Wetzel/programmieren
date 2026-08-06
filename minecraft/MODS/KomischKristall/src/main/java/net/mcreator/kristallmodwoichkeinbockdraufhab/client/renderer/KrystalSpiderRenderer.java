package net.mcreator.kristallmodwoichkeinbockdraufhab.client.renderer;

import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.monster.spider.SpiderModel;
import net.minecraft.client.model.geom.ModelLayers;

import net.mcreator.kristallmodwoichkeinbockdraufhab.entity.KrystalSpiderEntity;

public class KrystalSpiderRenderer extends MobRenderer<KrystalSpiderEntity, LivingEntityRenderState, SpiderModel> {
	private final Identifier entityTexture = Identifier.parse("kristallmodwoichkeinbockdraufhab:textures/entities/spider-planetminecraft-com-14392700.png");

	public KrystalSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(KrystalSpiderEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(LivingEntityRenderState state) {
		return entityTexture;
	}
}