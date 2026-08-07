package net.mcreator.testmodvontillman.command;

import net.minecraft.commands.CommandSourceStack; 
import net.minecraft.commands.arguments.EntityArgument;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.testmodvontillman.procedures.SetFoodLevelProcedureProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@EventBusSubscriber
public class SetFoodLevelCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("setfoodlevel").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.argument("foodValue", DoubleArgumentType.doubleArg(0, 20)).then(Commands.argument("saturation", DoubleArgumentType.doubleArg(0, 20)).then(Commands.argument("players", EntityArgument.players()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetFoodLevelProcedureProcedure.execute(arguments, entity, DoubleArgumentType.getDouble(arguments, "foodValue"), DoubleArgumentType.getDouble(arguments, "saturation"), true);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetFoodLevelProcedureProcedure.execute(arguments, entity, DoubleArgumentType.getDouble(arguments, "foodValue"), DoubleArgumentType.getDouble(arguments, "saturation"), false);
					return 0;
				}))));
	}

}