package minecraftschurli.mfm.objects.armor.godium;

import com.brandon3055.draconicevolution.integration.ModHelper;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.objects.armor.ArmorBase;
import minecraftschurli.mfm.util.interfaces.IArmorSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class ArmorGodium extends ArmorBase implements IArmorSet {

    public final EntityEquipmentSlot slot;

    public ArmorGodium(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, ItemInit.GODIUM.getARMOR_MATERIAL(), renderIndexIn, equipmentSlotIn);
        this.slot = equipmentSlotIn;
        setMaxDamage(-1);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

        if (isCompleteSetEquipped(player.getArmorInventoryList())) {
            player.setAir(300);
            player.getFoodStats().addStats(20, 20F);
            if (player.isBurning()) {
                player.extinguish();
            }
            player.capabilities.allowFlying = true;
            ArrayList<PotionEffect> effects = Lists.newArrayList(player.getActivePotionEffects());
            for (PotionEffect potion : Collections2.filter(effects, potion -> potion.getPotion().isBadEffect())) {
                if (ModHelper.isHoldingCleaver(player) && potion.getPotion().equals(MobEffects.MINING_FATIGUE)) {
                    continue;
                }
                player.removePotionEffect(potion.getPotion());
            }
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return ItemInit.LEGENDARY_RARITY;
    }

    @Override
    public boolean isCompleteSetEquipped(Iterable<ItemStack> armor) {
        for (ItemStack armorPiece : armor) {
            if (!(armorPiece.getItem() instanceof ArmorGodium)) {
                return false;
            }
        }
        return true;
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

    public static boolean isInfinite(EntityPlayer player) {
        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            if (slot.getSlotType() != EntityEquipmentSlot.Type.ARMOR) {
                continue;
            }
            ItemStack stack = player.getItemStackFromSlot(slot);
            if (stack.isEmpty() || !(stack.getItem() instanceof ArmorGodium)) {
                return false;
            }
        }
        return true;
    }

    @SubscribeEvent
    public void onGetHurt(LivingHurtEvent event) {
        if (!(event.getEntityLiving() instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
        if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().getItem() == ItemInit.SWORD_GODIUM && player.isHandActive()) {
            event.setCanceled(true);
        }
        if (isInfinite(player) && !event.getSource().damageType.equals("godlike")) {
            event.setCanceled(true);
        }
    }
}
