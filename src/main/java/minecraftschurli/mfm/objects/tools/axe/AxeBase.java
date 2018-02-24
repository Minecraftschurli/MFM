package minecraftschurli.mfm.objects.tools.axe;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.ItemAxe;

public class AxeBase extends ItemAxe implements IHasModel
{
    public AxeBase(String name, ToolMaterial material, float damage, float speed)
    {
        super(material,damage,speed);
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
