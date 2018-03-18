package minecraftschurli.mfm.objects.blocks.machines.multiblocks.godiumrefiner;

import mcp.MethodsReturnNonnullByDefault;
import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.objects.blocks.BlockBase;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.Random;


@SuppressWarnings("SpellCheckingInspection")
public class BlockGodiumRefinerController extends BlockBase implements IMultiblock, ITileEntityProvider {
    @SuppressWarnings("WeakerAccess")
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    @SuppressWarnings("WeakerAccess")
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    @SuppressWarnings("WeakerAccess")
    public static final PropertyBool MULTIBLOCK_FORMED = PropertyBool.create("multiblock_formed");

    public BlockGodiumRefinerController() {
        super("godium_refiner_controller", Material.ROCK);
        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false).withProperty(MULTIBLOCK_FORMED, false));
    }

    @MethodsReturnNonnullByDefault
    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(BlockInit.GODIUM_REFINER_CONTROLLER);
    }

    @ParametersAreNonnullByDefault
    @Nonnull
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(BlockInit.GODIUM_REFINER_CONTROLLER);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItemMainhand().getItem() == ItemInit.WRENCH) {
            if (!state.getValue(MULTIBLOCK_FORMED)) {
                if (checkMultiblock(worldIn, pos, facing, playerIn, state)) {
                    this.formMultiblock(worldIn, pos);
                    this.createTileEntity(worldIn, state);
                    playerIn.sendMessage(new TextComponentString("Success"));
                    System.out.println("Success");
                }
            } else {
                destroyMultiblock(worldIn, pos);
            }
        } else if (!worldIn.isRemote && state.getValue(MULTIBLOCK_FORMED)) {
            playerIn.openGui(Main.instance, Reference.GUI_GODIUM_REFINER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    private void formMultiblock(World world, BlockPos pos) {
        BlockPos multiblockMiddlePos = pos.offset(world.getBlockState(pos).getValue(FACING).getOpposite());
        BlockPos cornerPos = new BlockPos(multiblockMiddlePos.getX() - 1, multiblockMiddlePos.getY() - 1, multiblockMiddlePos.getZ() - 1);
        Block block;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    block = world.getBlockState(new BlockPos(cornerPos.getX() + x, cornerPos.getY() + y, cornerPos.getZ() + z)).getBlock();
                    block.setBlockUnbreakable();
                }
            }
        }
        setState(world.getBlockState(pos).getValue(ACTIVE), true, world, pos);
    }

    @SuppressWarnings("deprecation")
    private void destroyMultiblock(World world, BlockPos pos) {
        BlockPos multiblockMiddlePos = pos.offset(world.getBlockState(pos).getValue(FACING).getOpposite());
        InventoryHelper.dropInventoryItems(world, pos, (TileEntityFurnace) Objects.requireNonNull(world.getTileEntity(pos)));
        world.setTileEntity(pos, null);
        BlockPos cornerPos = new BlockPos(multiblockMiddlePos.getX() - 1, multiblockMiddlePos.getY() - 1, multiblockMiddlePos.getZ() - 1);
        Block block;
        BlockPos blockPos;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    blockPos = new BlockPos(cornerPos.getX() + x, cornerPos.getY() + y, cornerPos.getZ() + z);
                    block = world.getBlockState(blockPos).getBlock();
                    block.setHardness(block.getDefaultState().getBlock().getBlockHardness(world.getBlockState(blockPos), world, blockPos));
                }
            }
        }
        setState(world.getBlockState(pos).getValue(ACTIVE), false, world, pos);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.getBlockState(pos).getValue(MULTIBLOCK_FORMED)) {
            if (!checkMultiblock(worldIn, pos, worldIn.getBlockState(pos).getValue(FACING), worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false), state)) {
                destroyMultiblock(worldIn, pos);
            }
        }
    }

    @Override
    public void onNeighborChange(IBlockAccess worldIn, BlockPos pos, BlockPos neighbor) {
        if (worldIn.getBlockState(pos).getValue(MULTIBLOCK_FORMED)) {
            if (!checkMultiblock((World) worldIn, pos, worldIn.getBlockState(pos).getValue(FACING), ((World) worldIn).getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false), worldIn.getBlockState(pos))) {
                destroyMultiblock((World) worldIn, pos);
            }
        }
    }

    @SuppressWarnings("StringConcatenationInLoop")
    @Override
    public boolean checkMultiblock(World world, BlockPos controllerPos, EnumFacing facing, EntityPlayer player, IBlockState controller) {
        boolean debug = player.isCreative();
        world.getBlockState(controllerPos).withProperty(FACING, facing);
        BlockPos multiblockMiddlePos = controllerPos.offset(facing.getOpposite());
        BlockPos cornerPos = new BlockPos(multiblockMiddlePos.getX() - 1, multiblockMiddlePos.getY() - 1, multiblockMiddlePos.getZ() - 1);
        EnumFacing.Axis axis = facing.getAxis();
        EnumFacing stairFacing = axis == EnumFacing.Axis.X ? (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.WEST ? facing.rotateY() : facing.rotateY().getOpposite()) : (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.SOUTH ? facing.rotateY() : facing.rotateY().getOpposite());

        IBlockState stairBottom1 = Blocks.BRICK_STAIRS.getDefaultState()
                .withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP)
                .withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT)
                .withProperty(BlockStairs.FACING, stairFacing.getOpposite());

        IBlockState stairBottom2 = Blocks.BRICK_STAIRS.getDefaultState()
                .withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP)
                .withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT)
                .withProperty(BlockStairs.FACING, stairFacing);

        IBlockState stairTop1 = Blocks.BRICK_STAIRS.getDefaultState()
                .withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM)
                .withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT)
                .withProperty(BlockStairs.FACING, stairFacing.getOpposite());

        IBlockState stairTop2 = Blocks.BRICK_STAIRS.getDefaultState()
                .withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.BOTTOM)
                .withProperty(BlockStairs.SHAPE, BlockStairs.EnumShape.STRAIGHT)
                .withProperty(BlockStairs.FACING, stairFacing);

        IBlockState brick = Blocks.BRICK_BLOCK.getDefaultState();

        IBlockState air = Blocks.AIR.getDefaultState();

        IBlockState middle1 = axis == EnumFacing.Axis.X ? (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.WEST ? controller : brick) : (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.NORTH ? controller : brick);

        IBlockState middle2 = axis == EnumFacing.Axis.X ? (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.EAST ? controller : brick) : (world.getBlockState(controllerPos).getValue(FACING) == EnumFacing.SOUTH ? controller : brick);

        IBlockState[][][] MB =
                {
                        {
                                {stairBottom1, brick, stairBottom2},
                                {stairBottom1, brick, stairBottom2},
                                {stairBottom1, brick, stairBottom2}
                        },
                        {
                                {brick, middle1, brick},
                                {brick, air, brick},
                                {brick, middle2, brick}
                        },
                        {
                                {stairTop1, brick, stairTop2},
                                {stairTop1, brick, stairTop2},
                                {stairTop1, brick, stairTop2}
                        }
                };

        IBlockState checkBlock;

        IBlockState block;

        String newLine = "\n";

        String errorText = "";
        errorText += (facing.getAxis().toString()) + newLine;
        for (int y = 0; y < 3; y++) {
            errorText += "Y=" + y + newLine;
            for (int x = 0; x < 3; x++) {
                errorText += "X=" + x + newLine;
                for (int z = 0; z < 3; z++) {
                    checkBlock = world.getBlockState(new BlockPos(cornerPos.getX() + x, cornerPos.getY() + y, cornerPos.getZ() + z));
                    block = MB[y][axis == EnumFacing.Axis.Z ? z : x][axis == EnumFacing.Axis.Z ? x : z];
                    if (debug) {
                        errorText += "Z=" + z + newLine;
                        errorText += (y + " " + (axis == EnumFacing.Axis.Z ? z : x) + " " + (axis == EnumFacing.Axis.Z ? x : z)) + newLine;
                        errorText += ("X: " + (cornerPos.getX() + x) + " Y: " + (cornerPos.getY() + y) + " Z: " + (cornerPos.getZ() + z)) + newLine;
                        errorText += (checkBlock) + newLine;
                        errorText += ("X: " + x + " Y: " + y + " Z: " + z) + newLine;
                        errorText += (block) + newLine;
                    }
                    if (!(checkBlock == block)) {
                        System.out.println(errorText + "Fail");
                        player.sendMessage(new TextComponentString("Fail"));
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState west = worldIn.getBlockState(pos.west());
            IBlockState east = worldIn.getBlockState(pos.east());
            EnumFacing face = state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH;
            else if (face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH;
            else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.EAST;
            else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.WEST;
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static void setState(boolean active, boolean formed, World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (active)
            worldIn.setBlockState(pos, BlockInit.GODIUM_REFINER_CONTROLLER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, true).withProperty(MULTIBLOCK_FORMED, state.getValue(MULTIBLOCK_FORMED)), 3);
        else
            worldIn.setBlockState(pos, BlockInit.GODIUM_REFINER_CONTROLLER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, false).withProperty(MULTIBLOCK_FORMED, state.getValue(MULTIBLOCK_FORMED)), 3);

        if (formed) {
            worldIn.setBlockState(pos, BlockInit.GODIUM_REFINER_CONTROLLER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, state.getValue(ACTIVE)).withProperty(MULTIBLOCK_FORMED, true), 3);
        } else {
            worldIn.setBlockState(pos, BlockInit.GODIUM_REFINER_CONTROLLER.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, state.getValue(ACTIVE)).withProperty(MULTIBLOCK_FORMED, false), 3);
        }
        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    @ParametersAreNonnullByDefault
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        TileEntityFurnace tileEntity = new TileEntityFurnace();/*TODO own TileEntity & Gui*/
        tileEntity.setCustomInventoryName("Godium Refiner");
        return tileEntity;
    }

    @ParametersAreNonnullByDefault
    @Nonnull
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityFurnace tileentity = (TileEntityFurnace) worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, Objects.requireNonNull(tileentity));
        super.breakBlock(worldIn, pos, state);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ACTIVE, FACING, MULTIBLOCK_FORMED);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }


}
