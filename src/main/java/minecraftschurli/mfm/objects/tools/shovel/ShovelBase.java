package minecraftschurli.mfm.objects.tools.shovel;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.ItemSpade;

public class ShovelBase extends ItemSpade implements IHasModel
{
    public ShovelBase(String name, ToolMaterial material)
    {
        super(material);
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
