package minecraftschurli.mfm.objects.potions;

import minecraftschurli.mfm.init.PotionInit;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomPotionEffect extends Potion {

    private final IEffectProvider effectProvider;
    private final List<ItemStack> curativeItems;

    public CustomPotionEffect(String name, boolean isBadEffectIn, int liquidColorIn, IEffectProvider provider, ItemStack... curativeItems) {
        super(isBadEffectIn, liquidColorIn);
        this.curativeItems = new ArrayList<>();
        this.curativeItems.addAll(Arrays.asList(curativeItems));
        this.effectProvider = provider;
        this.setPotionName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name));

        PotionInit.POTIONS.add(this);
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
