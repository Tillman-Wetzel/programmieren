/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tillmanstollemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.tillmanstollemod.item.TillmansArmorItem;
import net.mcreator.tillmanstollemod.item.LightningSwordItem;
import net.mcreator.tillmanstollemod.TillmanstollemodMod;

import java.util.function.Function;

public class TillmanstollemodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TillmanstollemodMod.MODID);
	public static final DeferredItem<Item> LIGHTNING_SWORD;
	public static final DeferredItem<Item> TILLMANS_ARMOR_BOOTS;
	static {
		LIGHTNING_SWORD = register("lightning_sword", LightningSwordItem::new);
		TILLMANS_ARMOR_BOOTS = register("tillmans_armor_boots", TillmansArmorItem.Boots::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}
}