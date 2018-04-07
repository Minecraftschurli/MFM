package minecraftschurli.mfm.objects.items.food;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.Init;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.util.interfaces.IOredict;
import net.minecraft.creativetab.CreativeTabs;

public class FoodBase extends net.minecraft.item.ItemFood implements IHasModel,IOredict
{
    private final String oreDictName;

    public FoodBase(String name, int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);
        setCreativeTab(CreativeTabs.FOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.oreDictName = null;

        Init.ITEMS.add(this);
    }

    public FoodBase(String name, int amount, float saturation, boolean isWolfFood, String oreDictName)
    {
        super(amount, saturation, isWolfFood);
        setCreativeTab(CreativeTabs.FOOD);
        setUnlocalizedName(name);
        setRegistryName(name);
        this.oreDictName = oreDictName;

        Init.OREDICTS.add(this);
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
