package net.mcreator.testmodvontillman.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.util.Optional;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GiveOrbitalsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity, double quantity, boolean targetsAreGiven, String shotType) {
		if (entity == null)
			return;
		if (targetsAreGiven) {
			try {
				for (Entity entityiterator : EntityArgument.getEntities(arguments, "players")) {
					for (int index76 = 0; index76 < (int) quantity; index76++) {
						{
							Entity _ent = entityiterator;
							if (_ent.level() instanceof ServerLevel _serverLevel && _serverLevel.getServer() != null) {
								Optional<CommandFunction<CommandSourceStack>> _fopt = _serverLevel.getServer().getFunctions().get(Identifier.parse((("nuke:give/" + shotType)).toLowerCase(java.util.Locale.ENGLISH)));
								if (_fopt.isPresent())
									_serverLevel.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStackForNameResolution(_serverLevel));
							}
						}
					}
				}
			} catch (CommandSyntaxException e) {
				e.printStackTrace();
			}
		} else {
			for (int index77 = 0; index77 < (int) quantity; index77++) {
				{
					Entity _ent = entity;
					if (_ent.level() instanceof ServerLevel _serverLevel && _serverLevel.getServer() != null) {
						Optional<CommandFunction<CommandSourceStack>> _fopt = _serverLevel.getServer().getFunctions().get(Identifier.parse((("nuke:give/" + shotType)).toLowerCase(java.util.Locale.ENGLISH)));
						if (_fopt.isPresent())
							_serverLevel.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStackForNameResolution(_serverLevel));
					}
				}
			}
		}
	}
}