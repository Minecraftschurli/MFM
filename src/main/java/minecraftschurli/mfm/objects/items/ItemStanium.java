package minecraftschurli.mfm.objects.items;

import net.minecraft.item.ItemStack;

public class ItemStanium extends ItemBase 
{

	public ItemStanium() {
		super("gem_stanium", "gemStanium");
	}
	
	@Override
	public int getItemBurnTime(ItemStack itemStack) 
	{
		return 1600*4;
	}

}
