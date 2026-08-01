package net.mcreator.testmodvontillman.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.testmodvontillman.procedures.HotWaterSpawnParticleProcedure;
import net.mcreator.testmodvontillman.procedures.HotWaterDamageEntitysProcedure;
import net.mcreator.testmodvontillman.init.TestmodVonTillmanModFluids;

public class HotWaterBlock extends LiquidBlock {
	public HotWaterBlock(BlockBehaviour.Properties properties) {
		super(TestmodVonTillmanModFluids.HOT_WATER.get(), properties.mapColor(MapColor.WATER).strength(100f).lightLevel(state -> 1).noCollision().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		HotWaterSpawnParticleProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier insideBlockEffectApplier, boolean isPrecise) {
		super.entityInside(blockstate, world, pos, entity, insideBlockEffectApplier, isPrecise);
		HotWaterDamageEntitysProcedure.execute(world, entity);
	}
}