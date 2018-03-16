package minecraftschurli.mfm.objects.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AppleGodium extends MagicApple implements IHasEffect
{

    public AppleGodium()
    {
        super("apple_godium",100, 100);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    public void applyEffects(EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 400, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 3));
    }
}
