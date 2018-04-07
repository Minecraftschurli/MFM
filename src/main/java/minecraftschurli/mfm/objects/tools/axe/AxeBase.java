package minecraftschurli.mfm.objects.tools.axe;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.Init;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

import static minecraftschurli.mfm.util.handlers.RecipeHandler.RecipeHelper.addAxeRecipe;
import static minecraftschurli.mfm.util.handlers.RecipeHandler.cloneStack;

public class AxeBase extends ItemAxe implements IHasModel
{
    public AxeBase(String name, ToolMaterial material, float damage, float speed, Object handleMat) {
        super(material, damage, speed);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        if (material.getRepairItemStack().getItem() instanceof ItemBase && ((ItemBase) material.getRepairItemStack().getItem()).oreDictName != null && handleMat instanceof String) {
            addAxeRecipe(cloneStack(this, 1), ((ItemBase) material.getRepairItemStack().getItem()).oreDictName, (String) handleMat);
        } else if (handleMat instanceof Item) {
            addAxeRecipe(cloneStack(this, 1), cloneStack(material.getRepairItemStack(), 1), cloneStack((Item) handleMat, 1));
        }

        Init.ITEMS.add(this);
    }

    public AxeBase(String name, ToolMaterial material, float damage, float speed)
    {
        super(material,damage,speed);
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
