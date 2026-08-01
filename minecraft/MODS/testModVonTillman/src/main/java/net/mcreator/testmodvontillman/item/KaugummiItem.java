package net.mcreator.testmodvontillman.item;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.core.component.DataComponents;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModItems;

@EventBusSubscriber
public class KaugummiItem extends Item {
	public KaugummiItem(Item.Properties properties) {
		super(properties.stacksTo(96).food((new FoodProperties.Builder()).nutrition(8).saturationModifier(4f).alwaysEdible().build(), Consumables.defaultFood().consumeSeconds(3F).build()));
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		event.modify(TestmodVonTillmanModItems.KAUGUMMI.get(), (builder, _, _) -> builder.set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(TestmodVonTillmanModItems.BENUTZTES_KAUGUMMI.get()))));
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}
}