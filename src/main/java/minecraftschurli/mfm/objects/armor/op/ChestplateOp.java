package minecraftschurli.mfm.objects.armor.op;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChestplateOp extends ItemElytra implements SetOp, IHasModel  {
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};
    public static final IBehaviorDispenseItem DISPENSER_BEHAVIOR = new BehaviorDefaultDispenseItem()
    {
        /**
         * Dispense the specified stack, play the dispense sound and spawn particles.
         */
        protected ItemStack dispenseStack(IBlockSource source, ItemStack stack)
        {
            ItemStack itemstack = ItemArmor.dispenseArmor(source, stack);
            return itemstack.isEmpty() ? super.dispenseStack(source, stack) : itemstack;
        }
    };

	private ArmorMaterial material;
	private EntityEquipmentSlot armorType;
	private int renderIndex;
	private int damageReduceAmount;
	private float toughness;

	public ChestplateOp(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		this.material = materialIn;
        this.armorType = equipmentSlotIn;
        this.renderIndex = renderIndexIn;
        this.damageReduceAmount = this.material.getDamageReductionAmount(equipmentSlotIn);
        this.setMaxDamage(this.material.getDurability(equipmentSlotIn));
        this.toughness = this.material.getToughness();
        this.maxStackSize = 1;
        String name = "chestplate_op";
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
		this.addPropertyOverride(new ResourceLocation("broken"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return ChestplateOp.isUsable(stack) ? 0.0F : 1.0F;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ChestplateOp.DISPENSER_BEHAVIOR);

		ItemInit.ITEMS.add(this);
	}
	
	public static boolean isUsable(ItemStack stack)
    {
        return stack.getItemDamage() < stack.getMaxDamage() - 1;
    }

    /**
     * Return whether this item is repairable in an anvil.
     *  
     * @param toRepair the {@code ItemStack} being repaired
     * @param repair the {@code ItemStack} being used to perform the repair
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == ItemInit.INGOT_OP;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemstack);
        ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);

        if (itemstack1.isEmpty())
        {
            playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
            itemstack.setCount(0);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }
    
    /**
     * Gets the equipment slot of this armor piece (formerly known as armor type)
     */
    @SideOnly(Side.CLIENT)
    public EntityEquipmentSlot getEquipmentSlot()
    {
        return this.armorType;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public ArmorMaterial getArmorMaterial()
    {
        return this.material;
    }


    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == this.armorType)
        {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", (double)this.damageReduceAmount, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", (double)this.toughness, 0));
        }

        return multimap;
    }

    /**
     * Determines if this armor will be rendered with the secondary 'overlay' texture.
     * If this is true, the first texture will be rendered using a tint of the color
     * specified by getColor(ItemStack)
     *
     * @param stack The stack
     * @return true/false
     */
    public boolean hasOverlay(ItemStack stack)
    {
        return false;
    }
    
    @Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
    
		
}
