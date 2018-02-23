package minecraftschurli.mfm.objects.armor.vulcanium;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ChestplateVulcanium extends ArmorBase implements SetVulcanium
{

	public ChestplateVulcanium(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		super.onArmorTick(world, player, itemStack);
		short check = 0;
		for(ItemStack armor : player.getArmorInventoryList())
		{
			if(armor.getItem() instanceof SetVulcanium)
			{
				check++;
			}
			else
			{
				check = 0;
				break;
			}
		}
		if(check==4)player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 5, 0, false, false));
	}
	
	

}
