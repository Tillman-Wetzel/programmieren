package net.mcreator.testmodvontillman.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.testmodvontillman.procedures.TeapotOnBlockRightclickedProcedure;
import net.mcreator.testmodvontillman.block.entity.TeapotBlockEntity;

import java.util.function.Function;

public class TeapotBlock extends Block implements EntityBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private final Function<BlockState, VoxelShape> shapes = this.makeShapes();

	public TeapotBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.COPPER).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private Function<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 4, 3, 10, 6, 11), box(5, 0, 3, 11, 4, 13), box(3, 0, 5, 13, 4, 11), box(4, 0, 4, 12, 4, 12), box(6, 7, 6, 10, 8, 10), box(5, 6, 5, 11, 7, 11), box(5, 4, 4, 11, 6, 12), box(7, 7, 5, 9, 10, 6),
						box(7, 6, 11, 9, 10, 12), box(7, 10, 6, 9, 11, 11));
				case EAST -> Shapes.or(box(5, 4, 4, 13, 6, 10), box(3, 0, 5, 13, 4, 11), box(5, 0, 3, 11, 4, 13), box(4, 0, 4, 12, 4, 12), box(6, 7, 6, 10, 8, 10), box(5, 6, 5, 11, 7, 11), box(4, 4, 5, 12, 6, 11), box(10, 7, 7, 11, 10, 9),
						box(4, 6, 7, 5, 10, 9), box(5, 10, 7, 10, 11, 9));
				case WEST -> Shapes.or(box(3, 4, 6, 11, 6, 12), box(3, 0, 5, 13, 4, 11), box(5, 0, 3, 11, 4, 13), box(4, 0, 4, 12, 4, 12), box(6, 7, 6, 10, 8, 10), box(5, 6, 5, 11, 7, 11), box(4, 4, 5, 12, 6, 11), box(5, 7, 7, 6, 10, 9),
						box(11, 6, 7, 12, 10, 9), box(6, 10, 7, 11, 11, 9));
				default -> Shapes.or(box(6, 4, 5, 12, 6, 13), box(5, 0, 3, 11, 4, 13), box(3, 0, 5, 13, 4, 11), box(4, 0, 4, 12, 4, 12), box(6, 7, 6, 10, 8, 10), box(5, 6, 5, 11, 7, 11), box(5, 4, 4, 11, 6, 12), box(7, 7, 10, 9, 10, 11),
						box(7, 6, 4, 9, 10, 5), box(7, 10, 5, 9, 11, 10));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.apply(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightDampening(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		InteractionResult result = TeapotOnBlockRightclickedProcedure.execute(world, x, y, z, entity);
		return result;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new TeapotBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
		Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos, Direction direction) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof TeapotBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}