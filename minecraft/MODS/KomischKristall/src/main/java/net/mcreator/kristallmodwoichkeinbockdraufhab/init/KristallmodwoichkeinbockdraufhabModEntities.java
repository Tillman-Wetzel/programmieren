/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kristallmodwoichkeinbockdraufhab.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.kristallmodwoichkeinbockdraufhab.entity.KrystalSpiderEntity;
import net.mcreator.kristallmodwoichkeinbockdraufhab.entity.FlyingAmethystSharfEntity;
import net.mcreator.kristallmodwoichkeinbockdraufhab.KristallmodwoichkeinbockdraufhabMod;

@EventBusSubscriber
public class KristallmodwoichkeinbockdraufhabModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, KristallmodwoichkeinbockdraufhabMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<KrystalSpiderEntity>> KRYSTAL_SPIDER = register("krystal_spider",
			EntityType.Builder.<KrystalSpiderEntity>of(KrystalSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.notInPeaceful().sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlyingAmethystSharfEntity>> FLYING_AMETHYST_SHARF = register("flying_amethyst_sharf",
			EntityType.Builder.<FlyingAmethystSharfEntity>of(FlyingAmethystSharfEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(KristallmodwoichkeinbockdraufhabMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		KrystalSpiderEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(KRYSTAL_SPIDER.get(), KrystalSpiderEntity.createAttributes().build());
	}
}