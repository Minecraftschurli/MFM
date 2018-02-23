package minecraftschurli.mfm.objects.armor.godium;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import minecraftschurli.mfm.objects.armor.vulcanium.SetVulcanium;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ChestplateGodium extends ArmorBase implements SetGodium 
{

	public ChestplateGodium(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		super.onArmorTick(world, player, itemStack);
		short check = 0;
		for(ItemStack armor : player.getArmorInventoryList())
		{
			if(armor.getItem() instanceof SetGodium)
			{
				check++;
			}
			else
			{
				check = 0;
				break;
			}
		}
		if(check==4)
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 5, 4, false, false));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(23), 5, 0, false, false));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 5, 4, false, false));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 5, 0, false, false));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 5, 4, false, false));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 5, 0, false, false));
		}
	}

}
