package net.mcreator.playertracker.procedures;

import net.minecraft.world.entity.Entity;

public class SetGuiTextPlayernameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getDisplayName().getString();
	}
}