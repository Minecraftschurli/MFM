package minecraftschurli.mfm.objects.tools.sword;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.Init;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import static minecraftschurli.mfm.util.handlers.RecipeHandler.RecipeHelper.addSwordRecipe;
import static minecraftschurli.mfm.util.handlers.RecipeHandler.cloneStack;

public class SwordBase extends ItemSword implements IHasModel
{
    public SwordBase(String name, ToolMaterial material, Object handleMat) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        if (material.getRepairItemStack().getItem() instanceof ItemBase && ((ItemBase) material.getRepairItemStack().getItem()).oreDictName != null && handleMat instanceof String) {
            addSwordRecipe(cloneStack(this, 1), ((ItemBase) material.getRepairItemStack().getItem()).oreDictName, (String) handleMat);
        } else if (handleMat instanceof Item) {
            addSwordRecipe(cloneStack(this, 1), cloneStack(material.getRepairItemStack(), 1), cloneStack((Item) handleMat, 1));
        }

        Init.ITEMS.add(this);
    }

    public SwordBase(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);

        Init.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
