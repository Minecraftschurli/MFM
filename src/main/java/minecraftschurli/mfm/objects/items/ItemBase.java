package minecraftschurli.mfm.objects.items;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.proxy.ClientProxy;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemBase extends Item implements IHasModel {
    public final String oreDictName;

    public ItemBase (String name, String oreDict){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = oreDict;

		ItemInit.ITEMS.add(this);
	}

    public ItemBase (String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = null;

        ItemInit.ITEMS.add(this);
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
