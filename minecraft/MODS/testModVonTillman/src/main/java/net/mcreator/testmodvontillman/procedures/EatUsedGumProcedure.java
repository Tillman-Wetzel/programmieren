package net.mcreator.testmodvontillman.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModItems;

public class EatUsedGumProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double nextFoodValue = 0;
		double nextSaturationValue = 0;
		nextFoodValue = (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0) - 2;
		nextSaturationValue = (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0) - 1;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(TestmodVonTillmanModItems.BENUTZTES_KAUGUMMI.get()).copy();
			_setstack.setCount(1);
			_player.getInventory().placeItemBackInInventory(_setstack);
		}
	}
}