package net.mcreator.testmodvontillman.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class HotWaterSpawnParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.BUBBLE_POP, (x + Math.random()), (y + Math.random()), (z + Math.random()), 0, 1, 0);
	}
}