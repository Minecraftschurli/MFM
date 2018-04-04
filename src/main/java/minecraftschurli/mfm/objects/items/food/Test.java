package minecraftschurli.mfm.objects.items.food;

import minecraftschurli.mfm.init.PotionInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Test extends MagicApple implements IHasEffect {

    public Test() {
        super("test", 100, 100);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void applyEffects(EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(PotionInit.BLEEDING, 2000, 1, true, true));
        player.addPotionEffect(new PotionEffect(PotionInit.SLOWFALL, 2000, 1, true, true));
    }
}
