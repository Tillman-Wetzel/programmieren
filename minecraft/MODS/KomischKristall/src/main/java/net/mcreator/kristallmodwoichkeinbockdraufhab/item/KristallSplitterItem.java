package net.mcreator.kristallmodwoichkeinbockdraufhab.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class KristallSplitterItem extends Item {
	public KristallSplitterItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}
}