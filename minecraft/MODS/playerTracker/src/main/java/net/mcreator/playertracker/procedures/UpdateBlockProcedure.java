package net.mcreator.playertracker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class UpdateBlockProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		if (world instanceof Level _level)
			_level.updateNeighborsAt(new BlockPos(commandParameterBlockPos(arguments, "Block").getX(), commandParameterBlockPos(arguments, "Block").getY(), commandParameterBlockPos(arguments, "Block").getZ()),
					_level.getBlockState(new BlockPos(commandParameterBlockPos(arguments, "Block").getX(), commandParameterBlockPos(arguments, "Block").getY(), commandParameterBlockPos(arguments, "Block").getZ())).getBlock());
		if (world instanceof ServerLevel _level) {
			_level.getServer().getPlayerList().broadcastSystemMessage(
					Component.literal(("Updatet Block at" + commandParameterBlockPos(arguments, "Block").getX() + commandParameterBlockPos(arguments, "Block").getY() + commandParameterBlockPos(arguments, "Block").getZ())).withColor(0x66ff00), false);
		}
	}

	private static BlockPos commandParameterBlockPos(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return BlockPosArgument.getLoadedBlockPos(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return new BlockPos(0, 0, 0);
		}
	}
}