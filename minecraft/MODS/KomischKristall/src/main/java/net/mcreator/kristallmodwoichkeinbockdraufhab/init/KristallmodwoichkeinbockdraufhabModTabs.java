/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kristallmodwoichkeinbockdraufhab.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.kristallmodwoichkeinbockdraufhab.KristallmodwoichkeinbockdraufhabMod;

@EventBusSubscriber
public class KristallmodwoichkeinbockdraufhabModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KristallmodwoichkeinbockdraufhabMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> KRISTALLE = REGISTRY.register("kristalle", () -> CreativeModeTab.builder().title(Component.translatable("item_group.kristallmodwoichkeinbockdraufhab.kristalle"))
			.icon(() -> new ItemStack(KristallmodwoichkeinbockdraufhabModItems.KRISTALL_SPLITTER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(KristallmodwoichkeinbockdraufhabModItems.KRISTALL_SPLITTER.get());
				tabData.accept(KristallmodwoichkeinbockdraufhabModItems.KRISTAL_DIMENSION.get());
				tabData.accept(KristallmodwoichkeinbockdraufhabModItems.SKULK_DIMENSION.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(KristallmodwoichkeinbockdraufhabModItems.SKULK_DIMENSION.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(KristallmodwoichkeinbockdraufhabModItems.KRYSTAL_SPIDER_SPAWN_EGG.get());
		}
	}
}