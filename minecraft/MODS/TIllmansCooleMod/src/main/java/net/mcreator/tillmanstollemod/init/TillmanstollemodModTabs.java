/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tillmanstollemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.tillmanstollemod.TillmanstollemodMod;

@EventBusSubscriber
public class TillmanstollemodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TillmanstollemodMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TILLMANS_COOLE_ITEMS = REGISTRY.register("tillmans_coole_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tillmanstollemod.tillmans_coole_items")).icon(() -> new ItemStack(Blocks.LIGHT)).displayItems((parameters, tabData) -> {
				tabData.accept(TillmanstollemodModItems.LIGHTNING_SWORD.get());
				tabData.accept(TillmanstollemodModItems.TILLMANS_ARMOR_BOOTS.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(TillmanstollemodModItems.TILLMANS_ARMOR_BOOTS.get());
		}
	}
}