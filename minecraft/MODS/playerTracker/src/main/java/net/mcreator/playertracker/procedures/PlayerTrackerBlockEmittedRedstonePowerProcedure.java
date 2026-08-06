package net.mcreator.playertracker.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class PlayerTrackerBlockEmittedRedstonePowerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double returnedRedstoneOutput = 0;
		double distance = 0;
		Entity targetetPlayer = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			targetetPlayer = entityiterator;
		}
		if (!(targetetPlayer == null)) {
			if (IsPlayerChosenProcedure.execute(world, x, y, z)) {
				if (getPropertyByName((world.getBlockState(BlockPos.containing(x, y, z))), "is_distance_mode") instanceof BooleanProperty _getbp3 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp3)) {
					distance = (new Vec3(x, (GetUseYProcedure.execute(world, x, y, z) ? y : targetetPlayer.getY()), z)).distanceTo((targetetPlayer.position()));
					if (8 >= distance) {
						returnedRedstoneOutput = 15;
					} else if (12 >= distance) {
						returnedRedstoneOutput = 14;
					} else if (16 >= distance) {
						returnedRedstoneOutput = 13;
					} else if (24 >= distance) {
						returnedRedstoneOutput = 12;
					} else if (32 >= distance) {
						returnedRedstoneOutput = 11;
					} else if (40 >= distance) {
						returnedRedstoneOutput = 10;
					} else if (48 >= distance) {
						returnedRedstoneOutput = 9;
					} else if (56 >= distance) {
						returnedRedstoneOutput = 8;
					} else if (64 >= distance) {
						returnedRedstoneOutput = 7;
					} else if (80 >= distance) {
						returnedRedstoneOutput = 6;
					} else if (96 >= distance) {
						returnedRedstoneOutput = 5;
					} else if (128 >= distance) {
						returnedRedstoneOutput = 4;
					} else if (160 >= distance) {
						returnedRedstoneOutput = 3;
					} else if (192 >= distance) {
						returnedRedstoneOutput = 2;
					} else if (256 >= distance) {
						returnedRedstoneOutput = 1;
					} else {
						returnedRedstoneOutput = 0;
					}
				} else {
					returnedRedstoneOutput = 0;
				}
			} else {
				returnedRedstoneOutput = 0;
			}
		} else {
			returnedRedstoneOutput = 0;
		}
		return returnedRedstoneOutput;
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