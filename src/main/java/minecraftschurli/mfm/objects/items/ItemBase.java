package minecraftschurli.mfm.objects.items;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.Init;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.util.interfaces.IOredict;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel,IOredict {
    private final String oreDictName;

    public ItemBase (String name, String oreDict){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = oreDict;

        Init.OREDICTS.add(this);
		Init.ITEMS.add(this);
	}

    public ItemBase (String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = null;

        Init.ITEMS.add(this);
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

    @Override
    public String getOreDictName() {
        return this.oreDictName;
    }
}
