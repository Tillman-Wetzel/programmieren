package net.mcreator.testmodvontillman.fluid;

import org.apache.logging.log4j.core.util.Source;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.testmodvontillman.init.TestmodVonTillmanModItems;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluids;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluidTypes;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModBlocks;

public abstract class HotWaterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> TestmodVonTillmanModFluidTypes.HOT_WATER_TYPE.get(), () -> TestmodVonTillmanModFluids.HOT_WATER.get(),
			() -> TestmodVonTillmanModFluids.FLOWING_HOT_WATER.get()).explosionResistance(100f).bucket(() -> TestmodVonTillmanModItems.HOT_WATER_BUCKET.get()).block(() -> (LiquidBlock) TestmodVonTillmanModBlocks.HOT_WATER.get());

	private HotWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.FALLING_DRIPSTONE_WATER;
	}

	public static class Source extends HotWaterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends HotWaterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}