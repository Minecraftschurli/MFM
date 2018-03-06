package minecraftschurli.mfm.objects.items;

import net.minecraft.item.ItemStack;

public class ItemStanium extends ItemBase 
{

	public ItemStanium(String name) 
	{
		super(name);
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 1600*4;
	}

}
