package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.armor.godium.BootsGodium;
import minecraftschurli.mfm.objects.armor.godium.ChestplateGodium;
import minecraftschurli.mfm.objects.armor.godium.HelmetGodium;
import minecraftschurli.mfm.objects.armor.godium.LeggingsGodium;
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
import minecraftschurli.mfm.objects.food.AppleGodium;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.objects.items.ItemStanium;
import minecraftschurli.mfm.objects.items.ItemWhirlwind;
import minecraftschurli.mfm.objects.tools.axe.AxeBase;
import minecraftschurli.mfm.objects.tools.sword.SwordVulcanium;
import minecraftschurli.mfm.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<>();
	
	//Material
		//Armor
	public static final ArmorMaterial ARMOR_OP = EnumHelper.addArmorMaterial("armor_op", Reference.MODID + ":op", 66, new int[]{6, 12, 16, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.0F);
	public static final ArmorMaterial ARMOR_VULCANIUM = EnumHelper.addArmorMaterial("armor_vulcanium", Reference.MODID + ":vulcanium", 40, new int[]{3,6,8,3}, 40, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	public static final ArmorMaterial ARMOR_KANDIUM = EnumHelper.addArmorMaterial("armor_kandium", Reference.MODID + ":kandium", 20, new int[]{2,4,5,2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOR_KANADIUM = EnumHelper.addArmorMaterial("armor_kanadium", Reference.MODID + ":kanadium", 40, new int[]{3,6,8,3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	public static final ArmorMaterial ARMOR_GODIUM = EnumHelper.addArmorMaterial("armor_godium", Reference.MODID + ":godium", 100, new int[]{12, 24, 32, 12}, 80, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 8.0F);

		//Tool
	public static final ToolMaterial TOOL_VULCANIUM = EnumHelper.addToolMaterial("tool_vulcanium", 5,1561,8.0F,3.0F,40);
	public static final ToolMaterial TOOL_KANDIUM = EnumHelper.addToolMaterial("tool_kandium", 4,1561,8.0F,3.0F,25);
	public static final ToolMaterial TOOL_KANADIUM = EnumHelper.addToolMaterial("tool_kanadium", 4,1561,8.0F,3.0F,30);
	public static final ToolMaterial TOOL_GODIUM = EnumHelper.addToolMaterial("tool_godium", 4,1561,8.0F,3.0F,80);
	
	//Items
	public static final Item ITEM_WHIRLEWIND = new ItemWhirlwind();
	public static final Item ITEM_CORE = new ItemBase("item_core");

	//Food
    public static final Item FOOD_APPLE_GODIUM = new AppleGodium();
	
	//Ingots
	public static final Item INGOT_OP_BASE = new ItemBase("ingot_op_base","ingotOpBase");
	public static final Item INGOT_OP = new ItemBase("ingot_op","ingotOp");
	public static final Item INGOT_VULCANIUM = new ItemBase("ingot_vulcanium","ingotVulcanium");
	public static final Item INGOT_KANDIUM = new ItemBase("ingot_kandium","ingotKandium");
	public static final Item INGOT_KANADIUM = new ItemBase("ingot_kanadium","ingotKanadium");
	
	//Nuggets
	public static final Item NUGGET_OP = new ItemBase("nugget_op","nuggetOp");
	public static final Item NUGGET_VULCANIUM = new ItemBase("nugget_vulcanium","nuggetVulcanium");
	public static final Item NUGGET_KANDIUM = new ItemBase("nugget_kandium","nuggetKandium");
	public static final Item NUGGET_KANADIUM = new ItemBase("nugget_kanadium","nuggetKanadium");
	
	//Gems
	public static final Item GEM_SEADIAMOND = new ItemBase("gem_seadiamond","gemSeadiamond");
	public static final Item GEM_STANIUM = new ItemStanium("item_stanium");
	public static final Item GEM_CRYSTAL = new ItemBase("gem_crystal","gemCrystal");

    //Tools
		//Vulcanium
	public static final Item AXE_VULCANIUM = new AxeBase("axe_vulcanium", TOOL_VULCANIUM, 10F,0F);
    public static final Item SWORD_VULCANIUM = new SwordVulcanium();
	/*public static final Item SHOVEL_VULCANIUM =
    public static final Item PICKAXE_VULCANIUM =

        //Kandium
    public static final Item AXE_KANDIUM =
    public static final Item SWORD_KANDIUM =
    public static final Item SHOVEL_KANDIUM =
    public static final Item PICKAXE_KANDIUM =

            //Kanadium
        public static final Item AXE_KANADIUM =
        public static final Item SWORD_KANADIUM =
        public static final Item SHOVEL_KANADIUM =
        public static final Item PICKAXE_KANADIUM =

            //Godium
        public static final Item AXE_GODIUM =
        public static final Item SWORD_GODIUM =
        public static final Item SHOVEL_GODIUM =
        public static final Item PICKAXE_GODIUM =
    */
    //Armor
		//Armor Op
	public static final Item HELMET_OP = new HelmetOp(ARMOR_OP, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_OP = new ChestplateOp(ARMOR_OP, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_OP = new LeggingsOp(ARMOR_OP, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_OP = new BootsOp(ARMOR_OP, 1, EntityEquipmentSlot.FEET);
	
		//Armor Vulcanium
	public static final Item HELMET_VULCANIUM = new HelmetVulcanium("helmet_vulcanium", ARMOR_VULCANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_VULCANIUM = new ChestplateVulcanium("chestplate_vulcanium", ARMOR_VULCANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_VULCANIUM = new LeggingsVulcanium("leggings_vulcanium",ARMOR_VULCANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_VULCANIUM = new BootsVulcanium("boots_vulcanium",ARMOR_VULCANIUM, 1, EntityEquipmentSlot.FEET);
	
		//Armor Kandium
	public static final Item HELMET_KANDIUM = new HelmetKandium("helmet_kandium", ARMOR_KANDIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_KANDIUM = new ChestplateKandium("chestplate_kandium", ARMOR_KANDIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_KANDIUM = new LeggingsKandium("leggings_kandium",ARMOR_KANDIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_KANDIUM = new BootsKandium("boots_kandium",ARMOR_KANDIUM, 1, EntityEquipmentSlot.FEET);
	
		//Armor Kanadium
	public static final Item HELMET_KANADIUM = new HelmetKanadium("helmet_kanadium", ARMOR_KANADIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_KANADIUM = new ChestplateKanadium("chestplate_kanadium", ARMOR_KANADIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_KANADIUM = new LeggingsKanadium("leggings_kanadium",ARMOR_KANADIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_KANADIUM = new BootsKanadium("boots_kanadium",ARMOR_KANADIUM, 1, EntityEquipmentSlot.FEET);
	
		//Armor God
	public static final Item HELMET_GODIUM = new HelmetGodium("helmet_godium", ARMOR_GODIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_GODIUM = new ChestplateGodium("chestplate_godium", ARMOR_GODIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_GODIUM = new LeggingsGodium("leggings_godium",ARMOR_GODIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_GODIUM = new BootsGodium("boots_godium",ARMOR_GODIUM, 1, EntityEquipmentSlot.FEET);

}
