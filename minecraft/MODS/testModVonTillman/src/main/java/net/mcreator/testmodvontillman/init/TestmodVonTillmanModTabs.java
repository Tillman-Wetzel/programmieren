/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmodvontillman.init;

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

import net.mcreator.testmodvontillman.TestmodVonTillmanMod;

@EventBusSubscriber
public class TestmodVonTillmanModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestmodVonTillmanMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TILLMANS_CREATIVE_TAB = REGISTRY.register("tillmans_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.testmod_von_tillman.tillmans_creative_tab")).icon(() -> new ItemStack(TestmodVonTillmanModItems.KAUGUMMI.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TestmodVonTillmanModItems.KAUGUMMI.get());
				tabData.accept(TestmodVonTillmanModItems.BENUTZTES_KAUGUMMI.get());
				tabData.accept(TestmodVonTillmanModItems.SWEET_BERRY_TEA_BAG_ITEM.get());
				tabData.accept(TestmodVonTillmanModItems.GLOW_BERRY_TEA_BAG_ITEM.get());
				tabData.accept(TestmodVonTillmanModItems.HOT_WATER_BUCKET.get());
				tabData.accept(TestmodVonTillmanModBlocks.TEAPOT.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(TestmodVonTillmanModItems.KAUGUMMI.get());
		}
	}
}