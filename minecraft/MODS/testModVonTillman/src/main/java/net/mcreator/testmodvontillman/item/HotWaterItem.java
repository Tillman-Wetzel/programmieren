package net.mcreator.testmodvontillman.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluids;

public class HotWaterItem extends BucketItem {
	public HotWaterItem(Item.Properties properties) {
		super(TestmodVonTillmanModFluids.HOT_WATER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}