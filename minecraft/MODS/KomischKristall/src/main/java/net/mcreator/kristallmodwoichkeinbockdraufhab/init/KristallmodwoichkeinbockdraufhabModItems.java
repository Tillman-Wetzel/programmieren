/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kristallmodwoichkeinbockdraufhab.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;

import net.mcreator.kristallmodwoichkeinbockdraufhab.item.SkulkDimensionItem;
import net.mcreator.kristallmodwoichkeinbockdraufhab.item.KristallSplitterItem;
import net.mcreator.kristallmodwoichkeinbockdraufhab.item.KristalDimensionItem;
import net.mcreator.kristallmodwoichkeinbockdraufhab.KristallmodwoichkeinbockdraufhabMod;

import java.util.function.Function;

public class KristallmodwoichkeinbockdraufhabModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KristallmodwoichkeinbockdraufhabMod.MODID);
	public static final DeferredItem<Item> KRISTALL_SPLITTER;
	public static final DeferredItem<Item> KRISTAL_DIMENSION;
	public static final DeferredItem<Item> SKULK_DIMENSION;
	public static final DeferredItem<Item> KRYSTAL_SPIDER_SPAWN_EGG;
	static {
		KRISTALL_SPLITTER = register("kristall_splitter", KristallSplitterItem::new);
		KRISTAL_DIMENSION = register("kristal_dimension", KristalDimensionItem::new);
		SKULK_DIMENSION = register("skulk_dimension", SkulkDimensionItem::new);
		KRYSTAL_SPIDER_SPAWN_EGG = register("krystal_spider_spawn_egg", properties -> new SpawnEggItem(properties.spawnEgg(KristallmodwoichkeinbockdraufhabModEntities.KRYSTAL_SPIDER.get())));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}
}