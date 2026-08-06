package net.mcreator.testmodvontillman.procedures;

import net.minecraft.commands.CommandSourceStack; 
import net.minecraft.commands.arguments.EntityArgument;
import 

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class SetFoodLevelProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity, int nextFoodLevel, int nextSaturationLevel, boolean targetsAreGiven) {
		if (entity == null)
			return;

		if (targetsAreGiven) {
			try {
				for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
					if (entityiterator instanceof Player _player)
						_player.getFoodData().setFoodLevel(nextFoodLevel);
			
					if (entityiterator instanceof Player _player)
						_player.getFoodData().setSaturation(nextSaturationLevel);
				}
			} catch (CommandSyntaxException e) {
				System.out.println(e);
			} 
		} else {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(nextFoodLevel);
			
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation(nextSaturationLevel);
		}
	}
}