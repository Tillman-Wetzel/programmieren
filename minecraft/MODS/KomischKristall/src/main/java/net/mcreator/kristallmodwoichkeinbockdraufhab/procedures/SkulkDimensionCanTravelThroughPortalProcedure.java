package net.mcreator.kristallmodwoichkeinbockdraufhab.procedures;

import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.Entity;

public class SkulkDimensionCanTravelThroughPortalProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof Warden);
	}
}