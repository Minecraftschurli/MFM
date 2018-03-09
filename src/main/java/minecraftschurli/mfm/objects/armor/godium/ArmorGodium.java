package minecraftschurli.mfm.objects.armor.godium;

import com.brandon3055.draconicevolution.integration.ModHelper;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

import static minecraftschurli.mfm.init.ItemInit.ARMOR_GODIUM;

public class ArmorGodium extends ArmorBase {

    public final EntityEquipmentSlot slot;

    public ArmorGodium(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, ARMOR_GODIUM, renderIndexIn, equipmentSlotIn);
        this.slot = equipmentSlotIn;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (armorType == EntityEquipmentSlot.HEAD) {
            player.setAir(300);
            player.getFoodStats().addStats(20, 20F);
        } else if (armorType == EntityEquipmentSlot.CHEST) {
            player.capabilities.allowFlying = true;
            ArrayList<PotionEffect> effects = Lists.newArrayList(player.getActivePotionEffects());
            for (PotionEffect potion : Collections2.filter(effects, potion -> potion.getPotion().isBadEffect())) {
                if (ModHelper.isHoldingCleaver(player) && potion.getPotion().equals(MobEffects.MINING_FATIGUE)) {
                    continue;
                }
                player.removePotionEffect(potion.getPotion());
            }
        } else if (armorType == EntityEquipmentSlot.LEGS) {
            if (player.isBurning()) {
                player.extinguish();
            }
        }
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
}
