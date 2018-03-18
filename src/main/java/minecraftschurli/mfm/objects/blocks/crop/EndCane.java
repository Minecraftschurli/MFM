package minecraftschurli.mfm.objects.blocks.crop;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class EndCane extends CropCaneBase {
    public EndCane() {
        super("endcane");
    }

    @SuppressWarnings({"NullableProblems", "StatementWithEmptyBody"})
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.getBlockState(pos.down()).getBlock() == BlockInit.CROP_ENDCANE || this.checkForDrop(worldIn, pos, state)) {
            if (worldIn.isAirBlock(pos.up())) {
                int i;

                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
                }

                if (i < 3) {
                    int j = state.getValue(AGE);

                    if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                        if (j == 15) {
                            worldIn.setBlockState(pos.up(), this.getDefaultState());
                            worldIn.setBlockState(pos, state.withProperty(AGE, 0), 4);
                        } else {
                            worldIn.setBlockState(pos, state.withProperty(AGE, j + 1), 4);
                        }
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
        }
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        return block.canSustainPlant(state, worldIn, pos.down(), EnumFacing.UP, this) || block == this || block == Blocks.END_STONE;

    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        this.checkForDrop(worldIn, pos, state);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos) {
        return this.canPlaceBlockAt(worldIn, pos);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemInit.ENDCANE;
    }

    @Nonnull
    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ItemInit.ENDCANE);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(AGE);
    }

}
