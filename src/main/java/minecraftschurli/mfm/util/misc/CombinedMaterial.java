package minecraftschurli.mfm.util.misc;

import minecraftschurli.mfm.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class CombinedMaterial {
    public final ArmorMaterial ARMOR_MATERIAL;
    public final ToolMaterial TOOL_MATERIAL;
    public final CombinedMaterial.ShieldMaterial SHIELD_MATERIAL;

    public CombinedMaterial(String name, Item repairItem, int armorDurability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness, int harvestLevel, int toolDurability, float efficiency, float damage) {
        this.ARMOR_MATERIAL = EnumHelper.addArmorMaterial("armor_" + name, Reference.MODID + ":" + name, armorDurability, reductionAmounts, enchantability, soundOnEquip, toughness).setRepairItem(new ItemStack(repairItem));
        this.TOOL_MATERIAL = EnumHelper.addToolMaterial("tool_" + name, harvestLevel, toolDurability, efficiency, damage, enchantability).setRepairItem(new ItemStack(repairItem));
        this.SHIELD_MATERIAL = new ShieldMaterial(enchantability, toolDurability, 0).setRepairItem(new ItemStack(repairItem));
    }

    public CombinedMaterial(String name, Item repairItem, int armorDurability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness, int harvestLevel, int toolDurability, float efficiency, float damage, int shieldBlockTime) {
        this.ARMOR_MATERIAL = EnumHelper.addArmorMaterial("armor_" + name, Reference.MODID + ":" + name, armorDurability, reductionAmounts, enchantability, soundOnEquip, toughness).setRepairItem(new ItemStack(repairItem));
        this.TOOL_MATERIAL = EnumHelper.addToolMaterial("tool_" + name, harvestLevel, toolDurability, efficiency, damage, enchantability).setRepairItem(new ItemStack(repairItem));
        this.SHIELD_MATERIAL = new ShieldMaterial(enchantability, toolDurability, shieldBlockTime).setRepairItem(new ItemStack(repairItem));
    }

    public CombinedMaterial(ArmorMaterial armorMaterial, ToolMaterial toolMaterial, ShieldMaterial shieldMaterial) {
        this.ARMOR_MATERIAL = armorMaterial;
        this.TOOL_MATERIAL = toolMaterial;
        this.SHIELD_MATERIAL = shieldMaterial;
    }

    public class ShieldMaterial {
        private final int enchantability;
        private final int durability;
        private final int blockTime;
        private ItemStack repairItem;

        ShieldMaterial(int enchantability, int durability, int blockTime) {
            this.durability = durability;
            this.enchantability = enchantability;
            this.blockTime = blockTime;
        }

        ShieldMaterial setRepairItem(ItemStack item) {
            this.repairItem = item;
            return this;
        }

        public ItemStack getRepairItemStack() {
            return repairItem;
        }

        public int getDurability() {
            return durability;
        }

        public int getEnchantability() {
            return enchantability;
        }

        public int getBlockTime() {
            return blockTime;
        }
    }
}
