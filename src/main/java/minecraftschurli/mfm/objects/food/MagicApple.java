package minecraftschurli.mfm.objects.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicApple extends FoodBase
{

    public MagicApple(String name, int amount, float saturation)
    {
        super(name, amount, saturation, false);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {

        if (!worldIn.isRemote)
        {
            if(this instanceof IHasEffect)
            {
                ((IHasEffect) this).applyEffects(player);
            }
        }

    }

}
