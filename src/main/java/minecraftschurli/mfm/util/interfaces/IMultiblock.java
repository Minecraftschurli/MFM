package minecraftschurli.mfm.util.interfaces;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IMultiblock {
    boolean checkMultiblock(World world, BlockPos controllerPos, EnumFacing facing, EntityPlayer player, IBlockState controller);
}
