package minecraftschurli.mfm.objects.tools.sword;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import static minecraftschurli.mfm.util.handlers.RecipeHandler.RecipeHelper.addSwordRecipe;
import static minecraftschurli.mfm.util.handlers.RecipeHandler.cloneStack;

public class SwordBase extends ItemSword implements IHasModel
{
    public SwordBase(String name, ToolMaterial material, Item handleMat) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        addSwordRecipe(cloneStack(this, 1), cloneStack(material.getRepairItemStack(), 1), cloneStack(handleMat, 1));

        ItemInit.ITEMS.add(this);
    }

    public SwordBase(String name, ToolMaterial material) {
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
