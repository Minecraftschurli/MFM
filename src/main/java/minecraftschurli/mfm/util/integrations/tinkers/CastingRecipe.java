package minecraftschurli.mfm.util.integrations.tinkers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.util.RecipeMatch;

public class CastingRecipe extends slimeknights.tconstruct.library.smeltery.CastingRecipe
{

    public CastingRecipe(ItemStack output, Fluid fluid, int amount)
    {
        super(output, fluid, amount, calcCooldownTime(fluid, amount));

        TinkersInit.RECIPES.add(this);
    }

    public CastingRecipe(ItemStack output, RecipeMatch cast, Fluid fluid, int amount, int time)
    {
        super(output, cast, new FluidStack(fluid, amount), time, false, false);
    }
}
