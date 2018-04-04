package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.potions.CustomPotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

import java.awt.*;
import java.util.ArrayList;

public class PotionInit {
    public static final java.util.List<Potion> POTIONS = new ArrayList<>();

    public static final Potion BLEEDING = new CustomPotionEffect("bleeding", true, new Color(105, 5, 0).getRGB(),
            (entityLivingBaseIn, amplifier) ->
            {
                if (!entityLivingBaseIn.isEntityUndead()) {
                    entityLivingBaseIn.attackEntityFrom(new DamageSource("bleeding").setDamageBypassesArmor(), 0.2F * amplifier);
                }
            }
    );

    public static final Potion SLOWFALL = new CustomPotionEffect("slowfall", false, new Color(215, 215, 215).getRGB(),
            (entityLivingBaseIn, amplifier) ->
            {
                if (!entityLivingBaseIn.onGround) {
                    entityLivingBaseIn.addVelocity(0, -1, 0);
                    entityLivingBaseIn.fallDistance -= 0.2F;
                }
            }
    );
}
