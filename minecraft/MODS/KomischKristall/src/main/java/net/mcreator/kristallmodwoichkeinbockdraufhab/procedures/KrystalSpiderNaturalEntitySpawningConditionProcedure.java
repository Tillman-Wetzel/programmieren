package net.mcreator.kristallmodwoichkeinbockdraufhab.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class KrystalSpiderNaturalEntitySpawningConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, Identifier.parse("kristallmodwoichkeinbockdraufhab:kristal_dimension"));
	}
}