package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetIsDistanceModeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return (world.getBlockState(BlockPos.containing(x, y, z))) == ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("is_distance_mode") instanceof BooleanProperty _withbp2
				? (world.getBlockState(BlockPos.containing(x, y, z))).setValue(_withbp2, true)
				: (world.getBlockState(BlockPos.containing(x, y, z))));
	}
}