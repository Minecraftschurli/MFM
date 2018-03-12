package minecraftschurli.mfm.objects.items;

import minecraftschurli.mfm.objects.armor.op.SetOp;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class ItemWhirlwind extends ItemBase
{

	public ItemWhirlwind() 
	{
		super("item_whirlwind");
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        Iterable<ItemStack> armor = player.getArmorInventoryList();
        short check = 0;
        short checkMin = 4;
        for(ItemStack is : armor)
        {
			if(is.getItem() instanceof SetOp)
			{
				check++;
			}
			else
			{
				check = 0;
				break;
			}
		}
//        if(check>=checkMin)System.out.println("Tier 2");
//        else System.out.println("Tier 1");
        BlockPos playerPos = player.getPosition();
        int coordX = playerPos.getX();
        int coordY = playerPos.getY();
        int coordZ = playerPos.getZ();
        int radius = check >= checkMin ? 16 : 8;
        double fling = check >= checkMin ? 2F : 1F;
        AxisAlignedBB aabb = new AxisAlignedBB(coordX + radius, coordY + 3, coordZ + radius, coordX - radius, coordY - 3, coordZ - radius);
        List<Entity> eList = world.getEntitiesWithinAABBExcludingEntity(player,aabb);
		EntityLiving el;
        for (Entity e : eList) 
        {
        	if (e instanceof EntityLiving)
        	{
        		el = (EntityLiving) e;
				if (el.onGround && !el.isDead)
        			el.addVelocity(0, fling, 0);
        	}
        }

		return new ActionResult<>(EnumActionResult.PASS, itemstack);
    }
	
}
