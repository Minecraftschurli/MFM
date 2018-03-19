package minecraftschurli.mfm.objects.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWrench extends ItemBase {

    public ItemWrench() {
        super("wrench");
    }

    @Override
    public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return false;
    }

    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        return false;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        System.out.println(player.getEntityWorld().getBlockState(pos));
        return super.onBlockStartBreak(itemstack, pos, player);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        System.out.println(entity);
        return true;
    }
}
