package minecraftschurli.mfm.objects.armor.horsearmor;

import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HorseArmorGodium extends HorseArmorBase {

    public HorseArmorGodium() {
        super("horsearmor_godium", ItemInit.GODIUM.getHORSE_ARMOR_TYPE());
    }

    @Override
    public void onHorseArmorTick(World world, EntityLiving horse, ItemStack armor) {
        horse.setEntityInvulnerable(true);
    }

    @SubscribeEvent
    public void onGetHurt(LivingHurtEvent event) {
        if (!event.getSource().damageType.equals("godlike")) {
            event.setCanceled(true);
        }
    }
}
