package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.potions.CustomPotionEffect;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

import java.awt.*;
import java.util.ArrayList;

public class PotionInit {
    public static final java.util.List<Potion> POTIONS = new ArrayList<>();

    public static final Potion BLEEDING = new CustomPotionEffect("bleeding", true, new Color(105, 5, 0).getRGB(), new IEffectProvider() {
        int i = 0;
        boolean firstTime = true;

        @Override
        public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
            if (!entityLivingBaseIn.isEntityUndead() && ((entityLivingBaseIn.world.rand.nextBoolean() && i > 5) || firstTime)) {
                entityLivingBaseIn.attackEntityFrom(new DamageSource("bleeding").setDamageBypassesArmor(), 0.2F * amplifier);
                i = 0;
                firstTime = false;
            } else i++;
        }
    }
    );

    public static final Potion SLOWFALL = new CustomPotionEffect("slowfall", false, new Color(215, 215, 215).getRGB(),
            (entityLivingBaseIn, amplifier) ->
            {
                if (!entityLivingBaseIn.onGround) {
                    entityLivingBaseIn.addVelocity(0, 1, 0);
                    entityLivingBaseIn.fallDistance -= entityLivingBaseIn.fallDistance - 0.2F > 0 ? 0.2F : 0;
                }
            }
    );
}
