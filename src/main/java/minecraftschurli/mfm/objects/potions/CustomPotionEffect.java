package minecraftschurli.mfm.objects.potions;

import minecraftschurli.mfm.init.PotionInit;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IEffectProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CustomPotionEffect extends Potion {

    private final IEffectProvider effectProvider;

    public CustomPotionEffect(String name, boolean isBadEffectIn, int liquidColorIn, IEffectProvider provider) {
        super(isBadEffectIn, liquidColorIn);
        this.effectProvider = provider;
        this.setPotionName(name);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name));

        PotionInit.POTIONS.add(this);
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        effectProvider.performEffect(entityLivingBaseIn, amplifier);
    }
}
