/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testmodvontillman.init;

import net.neoforged.neoforge.transfer.fluid.BucketResourceHandler;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.testmodvontillman.item.SweetBerryTeaBagItemItem;
import net.mcreator.testmodvontillman.item.KaugummiItem;
import net.mcreator.testmodvontillman.item.HotWaterItem;
import net.mcreator.testmodvontillman.item.GlowBerryTeaBagItemItem;
import net.mcreator.testmodvontillman.item.BenutztesKaugummiItem;
import net.mcreator.testmodvontillman.TestmodVonTillmanMod;

import java.util.function.Function;

@EventBusSubscriber
public class TestmodVonTillmanModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TestmodVonTillmanMod.MODID);
	public static final DeferredItem<Item> KAUGUMMI;
	public static final DeferredItem<Item> BENUTZTES_KAUGUMMI;
	public static final DeferredItem<Item> SWEET_BERRY_TEA_BAG_ITEM;
	public static final DeferredItem<Item> GLOW_BERRY_TEA_BAG_ITEM;
	public static final DeferredItem<Item> HOT_WATER_BUCKET;
	public static final DeferredItem<Item> TEAPOT;
	static {
		KAUGUMMI = register("kaugummi", KaugummiItem::new);
		BENUTZTES_KAUGUMMI = register("benutztes_kaugummi", BenutztesKaugummiItem::new);
		SWEET_BERRY_TEA_BAG_ITEM = register("sweet_berry_tea_bag_item", SweetBerryTeaBagItemItem::new);
		GLOW_BERRY_TEA_BAG_ITEM = register("glow_berry_tea_bag_item", GlowBerryTeaBagItemItem::new);
		HOT_WATER_BUCKET = register("hot_water_bucket", HotWaterItem::new);
		TEAPOT = block(TestmodVonTillmanModBlocks.TEAPOT, new Item.Properties().stacksTo(4));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, Item.Properties::new);
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), () -> properties);
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.Fluid.ITEM, (stack, access) -> new BucketResourceHandler(access), HOT_WATER_BUCKET.get());
	}
}