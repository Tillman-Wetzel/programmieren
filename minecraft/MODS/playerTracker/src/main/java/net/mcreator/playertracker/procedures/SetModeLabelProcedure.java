package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SetModeLabelProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String returnText = "";
		if (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "is_distance_mode") instanceof BooleanProperty _getbp1 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp1)) {
			returnText = "Distance-mode enabled";
		} else {
			returnText = "Tracking-mode enabled";
		}
		return returnText;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}