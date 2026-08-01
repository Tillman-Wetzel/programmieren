package net.mcreator.testmodvontillman.command;

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

import net.mcreator.testmodvontillman.procedures.GiveOrbitalsProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@EventBusSubscriber
public class GiveOrbitalStrikeCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("giveOrbitalStrike").requires(Commands.hasPermission(Commands.LEVEL_ADMINS))
				.then(Commands.literal("Nukeshot").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("quantity", DoubleArgumentType.doubleArg(1, 100)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					double quantity = 1;
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					GiveOrbitalsProcedure.execute(arguments, entity, quantity, true, "arrowshot");
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					double quantity = 1;
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					GiveOrbitalsProcedure.execute(arguments, entity, quantity, false, "arrowshot");
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					double quantity = 1;
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					GiveOrbitalsProcedure.execute(arguments, entity, quantity, true, "arrowshot");
					return 0;
				})).then(Commands.literal("Stabshot").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("quantity", DoubleArgumentType.doubleArg(1, 100)))))
				.then(Commands.literal("Dogshot").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("quantity", DoubleArgumentType.doubleArg(1, 100)))))
				.then(Commands.literal("Arrowshot").then(Commands.argument("players", EntityArgument.players()).then(Commands.argument("quantity", DoubleArgumentType.doubleArg(1, 100))))));
	}

}