package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.potions.CustomPotionEffect;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.DamageSource;

import java.awt.*;
import java.util.ArrayList;

public class PotionInit {

    public static final java.util.List<Potion> POTIONS = new ArrayList<>();
    public static final java.util.List<PotionType> POTION_ITEMS = new ArrayList<>();

    public static final Potion BLEEDING = new CustomPotionEffect("bleeding", true, new Color(105, 5, 0).getRGB(),
            new IEffectProvider() {
                int i = 0;
                boolean firstTime = true;

                @Override
                public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
                    amplifier++;
                    if (!entityLivingBaseIn.isEntityUndead() && ((entityLivingBaseIn.world.rand.nextBoolean() && i > 80 / (amplifier)) || firstTime)) {
                        entityLivingBaseIn.attackEntityFrom(new DamageSource("bleeding").setDamageBypassesArmor(), amplifier);
                        this.i = 0;
                        this.firstTime = false;
                    } else i++;
                }
            }, new ItemStack(ItemInit.BANDAGES, 1), new ItemStack(ItemInit.MEDKIT)
    );

    @SuppressWarnings("Convert2Lambda")
    public static final Potion SLOWFALL = new CustomPotionEffect("slowfall", false, new Color(215, 215, 215).getRGB(),
            new IEffectProvider() {
                @Override
                public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
                    if (!entityLivingBaseIn.onGround) {
                        if (entityLivingBaseIn.motionY < 0) entityLivingBaseIn.addVelocity(0, 1, 0);
                        else
                            entityLivingBaseIn.setVelocity(entityLivingBaseIn.motionX, -0.001, entityLivingBaseIn.motionZ);
                        entityLivingBaseIn.fallDistance -= entityLivingBaseIn.fallDistance - 0.2F > 0 ? 0.2F : 0;
                    } else entityLivingBaseIn.setVelocity(entityLivingBaseIn.motionX, 0, entityLivingBaseIn.motionZ);

                }
            }, new ItemStack(Items.MILK_BUCKET)
    );

    @SuppressWarnings("Convert2Lambda")
    public static final Potion HIGH = new CustomPotionEffect("high", true, new Color(118, 167, 2).getRGB(),
            new IEffectProvider() {
                @Override
                public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
                    entityLivingBaseIn.removePotionEffect(MobEffects.BLINDNESS);
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 1800 * (amplifier + 1), amplifier));
                    entityLivingBaseIn.removePotionEffect(MobEffects.NAUSEA);
                    entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1800 * (amplifier + 1), amplifier));
                }
            }, ItemStack.EMPTY
    );
}
