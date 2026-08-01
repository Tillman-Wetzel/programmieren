package net.mcreator.testmodvontillman.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.testmodvontillman.procedures.EatUsedGumProcedure;

public class BenutztesKaugummiItem extends Item {
	public BenutztesKaugummiItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(6).saturationModifier(3f).alwaysEdible().build(), Consumables.defaultFood().consumeSeconds(3F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		EatUsedGumProcedure.execute(entity, itemstack);
		return retval;
	}
}