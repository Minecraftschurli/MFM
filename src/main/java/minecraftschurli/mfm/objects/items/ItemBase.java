package minecraftschurli.mfm.objects.items;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.proxy.ClientProxy;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	public ItemBase (String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
