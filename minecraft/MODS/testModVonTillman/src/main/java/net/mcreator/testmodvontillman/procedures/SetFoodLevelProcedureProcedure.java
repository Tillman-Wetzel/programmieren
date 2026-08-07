
package net.mcreator.testmodvontillman.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class SetFoodLevelProcedureProcedure {

	public static void execute(CommandContext arguments, Entity entity, double nextFoodLevel, double nextSaturationLevel, boolean targetsAreGiven) {
		if (entity == null)
			return;

		if (targetsAreGiven) {
			try {
				for (Object object : EntityArgument.getEntities(arguments, "players")) {

					if (object instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) nextFoodLevel);

					if (object instanceof Player _player)
						_player.getFoodData().setSaturation((float) nextSaturationLevel);
				}
			} catch (CommandSyntaxException e) {
				System.out.println(e);
			}
		} else {

			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) nextFoodLevel);

			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) nextSaturationLevel);
		}
	}
}