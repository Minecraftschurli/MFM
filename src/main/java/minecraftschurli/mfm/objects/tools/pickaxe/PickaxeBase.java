package minecraftschurli.mfm.objects.tools.pickaxe;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

import static minecraftschurli.mfm.util.handlers.RecipeHandler.RecipeHelper.addPickaxeRecipe;
import static minecraftschurli.mfm.util.handlers.RecipeHandler.cloneStack;

public class PickaxeBase extends ItemPickaxe implements IHasModel
{
    public PickaxeBase(String name, ToolMaterial material, Item handleMat) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        addPickaxeRecipe(cloneStack(this, 1), cloneStack(material.getRepairItemStack(), 1), cloneStack(handleMat, 1));

        ItemInit.ITEMS.add(this);
    }

    public PickaxeBase(String name, ToolMaterial material)
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
