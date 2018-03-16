package minecraftschurli.mfm.util.misc;

import minecraftschurli.mfm.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class CombinedMaterial {
    private ArmorMaterial ARMOR_MATERIAL;
    private ToolMaterial TOOL_MATERIAL;
    private CombinedMaterial.ShieldMaterial SHIELD_MATERIAL;

    public CombinedMaterial(String name, Item repairItem, int armorDurability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness, int harvestLevel, int toolDurability, float efficiency, float damage) {
        this.addARMOR_MATERIAL(EnumHelper.addArmorMaterial("armor_" + name, Reference.MOD_ID + ":" + name, armorDurability, reductionAmounts, enchantability, soundOnEquip, toughness).setRepairItem(new ItemStack(repairItem)));
        this.addTOOL_MATERIAL(EnumHelper.addToolMaterial("tool_" + name, harvestLevel, toolDurability, efficiency, damage, enchantability).setRepairItem(new ItemStack(repairItem)));
    }

    public CombinedMaterial(String name, Item repairItem, int armorDurability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness, int harvestLevel, int toolDurability, float efficiency, float damage, int shieldBlockTime) {
        this.addARMOR_MATERIAL(EnumHelper.addArmorMaterial("armor_" + name, Reference.MOD_ID + ":" + name, armorDurability, reductionAmounts, enchantability, soundOnEquip, toughness).setRepairItem(new ItemStack(repairItem)));
        this.addTOOL_MATERIAL(EnumHelper.addToolMaterial("tool_" + name, harvestLevel, toolDurability, efficiency, damage, enchantability).setRepairItem(new ItemStack(repairItem)));
        this.addSHIELD_MATERIAL(new ShieldMaterial(enchantability, toolDurability, shieldBlockTime).setRepairItem(new ItemStack(repairItem)));
    }

    public CombinedMaterial(ArmorMaterial armorMaterial, ToolMaterial toolMaterial, ShieldMaterial shieldMaterial) {
        this.ARMOR_MATERIAL = armorMaterial;
        this.TOOL_MATERIAL = toolMaterial;
        this.SHIELD_MATERIAL = shieldMaterial;
    }

    public ArmorMaterial getARMOR_MATERIAL() {
        return ARMOR_MATERIAL;
    }

    public void addARMOR_MATERIAL(ArmorMaterial ARMOR_MATERIAL) {
        this.ARMOR_MATERIAL = ARMOR_MATERIAL;
    }

    public ToolMaterial getTOOL_MATERIAL() {
        return TOOL_MATERIAL;
    }

    public void addTOOL_MATERIAL(ToolMaterial TOOL_MATERIAL) {
        this.TOOL_MATERIAL = TOOL_MATERIAL;
    }

    public ShieldMaterial getSHIELD_MATERIAL() {
        return SHIELD_MATERIAL;
    }

    public void addSHIELD_MATERIAL(ShieldMaterial SHIELD_MATERIAL) {
        this.SHIELD_MATERIAL = SHIELD_MATERIAL;
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
