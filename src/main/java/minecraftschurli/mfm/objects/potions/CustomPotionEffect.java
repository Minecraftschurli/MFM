package minecraftschurli.mfm.objects.potions;

import minecraftschurli.mfm.init.PotionInit;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomPotionEffect extends Potion {

    private final IEffectProvider effectProvider;
    private final List<ItemStack> curativeItems;
    private final ResourceLocation iconTexture;

    public CustomPotionEffect(String name, boolean isBadEffectIn, int liquidColorIn, IEffectProvider provider, ItemStack... curativeItems) {
        super(isBadEffectIn, liquidColorIn);
        setPotionName(this, name);
        this.iconTexture = new ResourceLocation(Reference.MOD_ID, "textures/gui/" + name + ".png");
        this.curativeItems = new ArrayList<>();
        this.curativeItems.addAll(Arrays.asList(curativeItems));
        this.effectProvider = provider;
        this.setPotionName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));

        PotionInit.POTIONS.add(this);
    }

    public static void setPotionName(Potion potion, String potionName) {
        potion.setPotionName("effect." + Reference.MOD_ID + ":" + potionName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        if (mc.currentScreen != null) {
            mc.getTextureManager().bindTexture(iconTexture);
            Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        mc.getTextureManager().bindTexture(iconTexture);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        effectProvider.performEffect(entityLivingBaseIn, amplifier);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return curativeItems;
    }


}
