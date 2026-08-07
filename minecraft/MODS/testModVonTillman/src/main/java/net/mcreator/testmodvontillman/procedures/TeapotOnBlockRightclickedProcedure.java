package net.mcreator.testmodvontillman.procedures;

import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.fluid.FluidResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluids;

public class TeapotOnBlockRightclickedProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		InteractionResult actionResult = InteractionResult.PASS;
		if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 0, null) == 0) {
			if ((executeCommandGetResult(entity, "execute if items entity @s weapon.mainhand testmod_von_tillman:hot_water_bucket run item replace entity @s weapon.mainhand with minecraft:bucket 1")).startsWith("Replaced")) {
				if (world instanceof ILevelExtension _ext) {
					if (_ext.getCapability(Capabilities.Fluid.BLOCK, BlockPos.containing(x, y, z), null) instanceof ResourceHandler<FluidResource> _fluidHandler) {
						int _fillAmount = 1000;
						if (_fillAmount > 0) {
							try (var _tx = Transaction.openRoot()) {
								_fluidHandler.insert(FluidResource.of(TestmodVonTillmanModFluids.HOT_WATER.get()), _fillAmount, _tx);
								_tx.commit();
							}
						}
					}
				}
				actionResult = InteractionResult.SUCCESS;
			} else if ((executeCommandGetResult(entity, "execute if items entity @s weapon.mainhand minecraft:bucket run item replace entity @s weapon.mainhand with minecraft:bucket 1")).startsWith("Replaced")) {
				if (world instanceof ILevelExtension _ext) {
					if (_ext.getCapability(Capabilities.Fluid.BLOCK, BlockPos.containing(x, y, z), null) instanceof ResourceHandler<FluidResource> _fluidHandler) {
						int _fillAmount = 1000;
						if (_fillAmount > 0) {
							try (var _tx = Transaction.openRoot()) {
								_fluidHandler.insert(FluidResource.of(Fluids.WATER), _fillAmount, _tx);
								_tx.commit();
							}
						}
					}
				}
				actionResult = InteractionResult.SUCCESS;
			} else {
				actionResult = InteractionResult.CONSUME;
			}
		} else {
			actionResult = InteractionResult.CONSUME;
		}
		return actionResult;
	}

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			if (levelExtension.getCapability(Capabilities.Fluid.BLOCK, pos, direction) instanceof ResourceHandler<FluidResource> fluidHandler)
				return net.neoforged.neoforge.transfer.fluid.FluidUtil.getStack(fluidHandler, tank).amount();
		}
		return 0;
	}

	private static String executeCommandGetResult(Entity entity, String command) {
		StringBuilder result = new StringBuilder();
		if (!entity.level().isClientSide() && entity.level().getServer() != null) {
			CommandSource dataConsumer = new CommandSource() {
				@Override
				public void sendSystemMessage(Component message) {
					result.append(message.getString());
				}

				@Override
				public boolean acceptsSuccess() {
					return true;
				}

				@Override
				public boolean acceptsFailure() {
					return true;
				}

				@Override
				public boolean shouldInformAdmins() {
					return false;
				}
			};
			entity.level().getServer().getCommands().performPrefixedCommand(new CommandSourceStack(dataConsumer, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null,
					LevelBasedPermissionSet.OWNER, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), command);
		}
		return result.toString();
	}
}