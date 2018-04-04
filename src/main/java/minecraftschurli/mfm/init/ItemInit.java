package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.armor.godium.ArmorGodium;
import minecraftschurli.mfm.objects.armor.horsearmor.HorseArmorGodium;
import minecraftschurli.mfm.objects.armor.kanadium.BootsKanadium;
import minecraftschurli.mfm.objects.armor.kanadium.ChestplateKanadium;
import minecraftschurli.mfm.objects.armor.kanadium.HelmetKanadium;
import minecraftschurli.mfm.objects.armor.kanadium.LeggingsKanadium;
import minecraftschurli.mfm.objects.armor.kandium.BootsKandium;
import minecraftschurli.mfm.objects.armor.kandium.ChestplateKandium;
import minecraftschurli.mfm.objects.armor.kandium.HelmetKandium;
import minecraftschurli.mfm.objects.armor.kandium.LeggingsKandium;
import minecraftschurli.mfm.objects.armor.op.BootsOp;
import minecraftschurli.mfm.objects.armor.op.ChestplateOp;
import minecraftschurli.mfm.objects.armor.op.HelmetOp;
import minecraftschurli.mfm.objects.armor.op.LeggingsOp;
import minecraftschurli.mfm.objects.armor.vulcanium.BootsVulcanium;
import minecraftschurli.mfm.objects.armor.vulcanium.ChestplateVulcanium;
import minecraftschurli.mfm.objects.armor.vulcanium.HelmetVulcanium;
import minecraftschurli.mfm.objects.armor.vulcanium.LeggingsVulcanium;
import minecraftschurli.mfm.objects.items.*;
import minecraftschurli.mfm.objects.items.food.AppleGodium;
import minecraftschurli.mfm.objects.items.food.FoodBase;
import minecraftschurli.mfm.objects.items.food.Test;
import minecraftschurli.mfm.objects.tools.axe.AxeBase;
import minecraftschurli.mfm.objects.tools.pickaxe.PickaxeBase;
import minecraftschurli.mfm.objects.tools.shield.ShieldGodium;
import minecraftschurli.mfm.objects.tools.shovel.ShovelBase;
import minecraftschurli.mfm.objects.tools.sword.SwordGodium;
import minecraftschurli.mfm.objects.tools.sword.SwordVulcanium;
import minecraftschurli.mfm.util.misc.CombinedMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;


public class ItemInit {

    public static final java.util.List<Item> ITEMS = new ArrayList<>();

    public static EnumRarity CRAP_RARITY = EnumHelper.addRarity("CRAP", TextFormatting.ITALIC, "CRAP");
    public static EnumRarity LEGENDARY_RARITY = EnumHelper.addRarity("LEGENDARY", TextFormatting.GOLD, "LEGENDARY");

    /*TODO Tools: Kandium, Kanadium


        Kandium
    public static final Item AXE_KANDIUM;
    public static final Item SWORD_KANDIUM;
    public static final Item SHOVEL_KANDIUM;
    public static final Item PICKAXE_KANDIUM;

        Kanadium
    public static final Item AXE_KANADIUM;
    public static final Item SWORD_KANADIUM;
    public static final Item SHOVEL_KANADIUM;
    public static final Item PICKAXE_KANADIUM;

    */


    //Nuggets
    public static final Item NUGGET_KANADIUM = new ItemBase("nugget_kanadium", "nuggetKanadium");
    public static final Item NUGGET_KANDIUM = new ItemBase("nugget_kandium", "nuggetKandium");
    public static final Item NUGGET_VULCANIUM = new ItemBase("nugget_vulcanium", "nuggetVulcanium");
    public static final Item NUGGET_OP = new ItemBase("nugget_op", "nuggetOp");
    public static final Item NUGGET_GODIUM = new ItemBase("nugget_godium", "nuggetGodium");

    //Ingots
    public static final Item INGOT_KANADIUM = new ItemBase("ingot_kanadium", "ingotKanadium");
    public static final Item INGOT_KANDIUM = new ItemBase("ingot_kandium", "ingotKandium");
    public static final Item INGOT_VULCANIUM = new ItemBase("ingot_vulcanium", "ingotVulcanium");
    public static final Item INGOT_OP = new ItemBase("ingot_op", "ingotOp");
    public static final Item INGOT_OP_BASE = new ItemBase("ingot_op_base", "ingotOpBase");
    public static final Item INGOT_GODIUM = new ItemBase("ingot_godium", "ingotGodium");
    public static final Item INGOT_GODIUM_RAW = new ItemBase("ingot_godium_raw", "ingotGodiumRaw");

    //Gems
    public static final Item GEM_CRYSTAL = new ItemBase("gem_crystal", "gemCrystal");
    public static final Item GEM_STANIUM = new ItemStanium();
    public static final Item GEM_SEADIAMOND = new ItemBase("gem_seadiamond", "gemSeadiamond");
    public static final Item GEM_FIRE = new ItemBase("gem_fire", "gemFire");

    //Dusts
    public static final Item DUST_MYSTIC = new ItemBase("dust_mystic", "dustMystic");

    //Food
    public static final Item FOOD_APPLE_GODIUM = new AppleGodium();
    public static final Item TEST = new Test();

    //Crafting Items
    public static final Item ITEM_CORE = new ItemBase("item_core");
    public static final Item ENDCANE = new ItemEndCane();
    public static final Item HANDLE = new ItemBase("item_handle");

    //Misc
    public static final Item WRENCH = Loader.isModLoaded("thermalfoundation") ? cofh.thermalfoundation.init.TFItems.itemWrench.addItem(10, "wrench10").getItem() : new ItemWrench();
    public static final Item DEBUG_ITEM = new ItemDebug();
    public static final Item ITEM_WHIRLEWIND = new ItemWhirlwind();

    public static final Item BANDAGES = new FoodBase("bandages", 0, 0, false).setMaxStackSize(5).setCreativeTab(CreativeTabs.COMBAT);
    public static final Item MEDKIT = new FoodBase("medkit", 0, 0, false).setMaxStackSize(3).setCreativeTab(CreativeTabs.COMBAT);

    //Potions


    //Op
    //Material
    public static final CombinedMaterial OP = new CombinedMaterial("op", INGOT_OP, 66, new int[]{6, 12, 16, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.0F, 0, 0, 0, 0);
    //Armor
    public static final Item BOOTS_OP = new BootsOp(OP.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.FEET);
    public static final Item LEGGINGS_OP = new LeggingsOp(OP.getARMOR_MATERIAL(), 2, EntityEquipmentSlot.LEGS);
    public static final Item CHESTPLATE_OP = new ChestplateOp(OP.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.CHEST);
    public static final Item HELMET_OP = new HelmetOp(OP.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.HEAD);

    //Kanadium
    //Material
    public static final CombinedMaterial KANADIUM = new CombinedMaterial("kanadium", INGOT_KANADIUM, 40, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 4, 1561, 8.0F, 3.0F);
    //Tools

    //Armor
    public static final Item BOOTS_KANADIUM = new BootsKanadium("boots_kanadium", KANADIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.FEET);
    public static final Item LEGGINGS_KANADIUM = new LeggingsKanadium("leggings_kanadium", KANADIUM.getARMOR_MATERIAL(), 2, EntityEquipmentSlot.LEGS);
    public static final Item CHESTPLATE_KANADIUM = new ChestplateKanadium("chestplate_kanadium", KANADIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.CHEST);
    public static final Item HELMET_KANADIUM = new HelmetKanadium("helmet_kanadium", KANADIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.HEAD);

    //Kandium
    //Material
    public static final CombinedMaterial KANDIUM = new CombinedMaterial("kandium", INGOT_KANDIUM, 20, new int[]{2, 4, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 4, 1561, 8.0F, 3.0F);
    //Tools

    //Armor
    public static final Item BOOTS_KANDIUM = new BootsKandium("boots_kandium", KANDIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.FEET);
    public static final Item LEGGINGS_KANDIUM = new LeggingsKandium("leggings_kandium", KANDIUM.getARMOR_MATERIAL(), 2, EntityEquipmentSlot.LEGS);
    public static final Item CHESTPLATE_KANDIUM = new ChestplateKandium("chestplate_kandium", KANDIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.CHEST);
    public static final Item HELMET_KANDIUM = new HelmetKandium("helmet_kandium", KANDIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.HEAD);

    //Vulcanium
    //Material
    public static final CombinedMaterial VULCANIUM = new CombinedMaterial("vulcanium", INGOT_VULCANIUM, 40, new int[]{3, 6, 8, 3}, 40, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F, 5, 1561, 8.0F, 3.0F);
    //Tools
    public static final Item SWORD_VULCANIUM = new SwordVulcanium();
    public static final Item AXE_VULCANIUM = new AxeBase("axe_vulcanium", VULCANIUM.getTOOL_MATERIAL(), 10F, 0F, "stickWood");
    public static final Item SHOVEL_VULCANIUM = new ShovelBase("shovel_vulcanium", VULCANIUM.getTOOL_MATERIAL(), "stickWood");
    public static final Item PICKAXE_VULCANIUM = new PickaxeBase("pickaxe_vulcanium", VULCANIUM.getTOOL_MATERIAL(), "stickWood");
    //Armor
    public static final Item BOOTS_VULCANIUM = new BootsVulcanium("boots_vulcanium", VULCANIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.FEET);
    public static final Item LEGGINGS_VULCANIUM = new LeggingsVulcanium("leggings_vulcanium", VULCANIUM.getARMOR_MATERIAL(), 2, EntityEquipmentSlot.LEGS);
    public static final Item CHESTPLATE_VULCANIUM = new ChestplateVulcanium("chestplate_vulcanium", VULCANIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.CHEST);
    public static final Item HELMET_VULCANIUM = new HelmetVulcanium("helmet_vulcanium", VULCANIUM.getARMOR_MATERIAL(), 1, EntityEquipmentSlot.HEAD);


    //Godium
    //Material
    public static final CombinedMaterial GODIUM = new CombinedMaterial("godium", INGOT_GODIUM, 100, new int[]{12, 24, 32, 12}, 80, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 8.0F, 32, 9999, 9999F, -3.0F, 100, 64);
    //Tools
    public static final Item SWORD_GODIUM = new SwordGodium();
    public static final Item AXE_GODIUM = new AxeBase("axe_godium", GODIUM.getTOOL_MATERIAL(), 30F, 100F, "stickIron");//OreDictionary.getOres("rodIron").get(0).getItem()
    public static final Item SHOVEL_GODIUM = new ShovelBase("shovel_godium", GODIUM.getTOOL_MATERIAL(), "stickIron");
    public static final Item PICKAXE_GODIUM = new PickaxeBase("pickaxe_godium", GODIUM.getTOOL_MATERIAL(), "stickIron");
    //    public static final List<ImmutablePair<String,Item>> TOOLS_GODIUM = createToolList(SWORD_GODIUM,SHOVEL_GODIUM,AXE_GODIUM,PICKAXE_GODIUM);
    public static final Item HORSE_ARMOR_GODIUM = new HorseArmorGodium();
    public static final Item SHIELD_GODIUM = new ShieldGodium();
    //Armor
    public static final Item BOOTS_GODIUM = new ArmorGodium("boots_godium", 1, EntityEquipmentSlot.FEET);
    public static final Item LEGGINGS_GODIUM = new ArmorGodium("leggings_godium", 2, EntityEquipmentSlot.LEGS);
    public static final Item CHESTPLATE_GODIUM = new ArmorGodium("chestplate_godium", 1, EntityEquipmentSlot.CHEST);
    public static final Item HELMET_GODIUM = new ArmorGodium("helmet_godium", 1, EntityEquipmentSlot.HEAD);

    /*@SuppressWarnings("unchecked")
    private static List<ImmutablePair<String,Item>> createToolList(Item sword,Item shovel,Item axe,Item pickaxe){
        return new List<ImmutablePair<String,Item>>().addE(new ImmutablePair<>("sword",sword)).addE(new ImmutablePair<>("shovel",shovel)).addE(new ImmutablePair<>("axe",axe)).addE(new ImmutablePair<>("pickaxe",pickaxe));
    }*/
}
