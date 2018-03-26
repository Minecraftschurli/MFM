package minecraftschurli.mfm.objects.tools.shovel;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

import static minecraftschurli.mfm.util.handlers.RecipeHandler.RecipeHelper.addShovelRecipe;
import static minecraftschurli.mfm.util.handlers.RecipeHandler.cloneStack;

public class ShovelBase extends ItemSpade implements IHasModel
{
    public ShovelBase(String name, ToolMaterial material, Item handleMat) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        addShovelRecipe(cloneStack(this, 1), cloneStack(material.getRepairItemStack(), 1), cloneStack(handleMat, 1));

        ItemInit.ITEMS.add(this);
    }

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
