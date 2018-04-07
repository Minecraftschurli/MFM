package minecraftschurli.mfm.init;

import javafx.util.Pair;
import minecraftschurli.mfm.objects.potions.CustomPotionEffect;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.DamageSource;

import java.awt.*;
import java.util.ArrayList;

public class PotionInit {

    public static final Potion BLEEDING = new CustomPotionEffect("Bleeding", true,
            new Color(105, 5, 0).getRGB(), new PotionEffectBleeding(),
            new ItemStack(ItemInit.BANDAGES), new ItemStack(ItemInit.MEDKIT)
    );

    @SuppressWarnings("Convert2Lambda")
    public static final Potion SLOWFALL = new CustomPotionEffect("Slowfall", false,
            new Color(215, 215, 215).getRGB(), new PotionEffectSlowFall(),
            new ItemStack(Items.MILK_BUCKET)
    );

    @SuppressWarnings("Convert2Lambda")
    public static final Potion HIGH = new CustomPotionEffect("High", true, new Color(118, 167, 2).getRGB(),
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

    private static class PotionEffectBleeding implements IEffectProvider {
        int i = 0;
        boolean firstTime = true;

        @Override
        public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
            if (!entityLivingBaseIn.isEntityUndead() && ((i > 100 - (amplifier * 5)) || firstTime)) {
                entityLivingBaseIn.attackEntityFrom(new DamageSource("bleeding").setDamageBypassesArmor().setDamageIsAbsolute(), 1);
                this.i = 0;
                this.firstTime = false;
            } else i++;
        }
    }

    private static class PotionEffectSlowFall implements IEffectProvider {
        @Override
        public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
            //int fallingSpeed = 2;
            float fallingSpeed = 10 - (((amplifier > 19 ? 19 : amplifier) / 2) - 1);
            if (!entityLivingBaseIn.onGround && !entityLivingBaseIn.isSneaking()) {
                double newMotionY = entityLivingBaseIn.motionY - entityLivingBaseIn.motionY / fallingSpeed;
                if (newMotionY < 0 && !entityLivingBaseIn.isElytraFlying()) {
                    entityLivingBaseIn.motionY = newMotionY;
                }
                entityLivingBaseIn.fallDistance = 0;
            }
        }

        /*@SubscribeEvent
        public void onRenderGameOverlayBar(RenderGameOverlayEvent.Text event) {
            if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                Minecraft mc = Minecraft.getMinecraft();

                ResourceLocation BAR = new ResourceLocation(Reference.MOD_ID + ":textures/gui/bar.png");
                int tex_width = 102;
                int tex_height = 11;

                //To set the Position of the Bar and Number
                int posX = event.getResolution().getScaledWidth() / 2 + 92;
                int posY = event.getResolution().getScaledHeight() - 12;


                //How Much of the Bar Should be Rendered
                float points = 100;
                int texture_width = (int) (points);

                mc.renderEngine.bindTexture(BAR);

                if (mc.player != null) {
                    if (!mc.player.isCreative()) {
                        drawTexturedModalRect(posX, posY, 0, 0, tex_width, tex_height);                //The Bar
                        drawTexturedModalRect(posX + 1, posY + 1, 0, 11, texture_width, tex_height);
                    }
                }
            }
        }

        @Override
        public void renderCustomHUD(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        }


        @Override
        public boolean hasCustomHUD() {
            return false;
        }*/
    }
}
