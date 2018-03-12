package minecraftschurli.mfm.objects.tools.pickaxe;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.util.misc.CombinedMaterial;
import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe implements IHasModel
{
    public PickaxeBase(String name, CombinedMaterial material)
    {
        super(material.TOOL_MATERIAL);
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
