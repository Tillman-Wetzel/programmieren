package net.mcreator.testmodvontillman.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class GiveGumProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity, double quantity, boolean targetsAreGiven) {
		if (entity == null)
			return;

		if (targetsAreGiven) {
			try {
				for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
					if (DoubleArgumentType.getDouble(arguments, "timesEaten") == 0) {
						if (entityiterator instanceof Player _player) {
							ItemStack _setstack = new ItemStack(TestmodVonTillmanModItems.KAUGUMMI.get()).copy();
							_setstack.setCount((int) quantity);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
					} else if (DoubleArgumentType.getDouble(arguments, "timesEaten") > 0) {
						if (entityiterator instanceof Player _player) {
							ItemStack _setstack = new ItemStack(TestmodVonTillmanModItems.BENUTZTES_KAUGUMMI.get()).copy();
							_setstack.setCount((int) quantity);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
					}
				}
			} catch (CommandSyntaxException e) {

			} 
		} else {
			if (DoubleArgumentType.getDouble(arguments, "timesEaten") == 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(TestmodVonTillmanModItems.KAUGUMMI.get()).copy();
					_setstack.setCount((int) quantity);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
			} else if (DoubleArgumentType.getDouble(arguments, "timesEaten") > 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(TestmodVonTillmanModItems.BENUTZTES_KAUGUMMI.get()).copy();
					_setstack.setCount((int) quantity);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
			}
		}
	}
}