package minecraftschurli.mfm.util.integrations.tinkers;

import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.util.RecipeMatch;

public class MeltingRecipe extends slimeknights.tconstruct.library.smeltery.MeltingRecipe
{

    public MeltingRecipe(RecipeMatch input, FluidStack output, int temperature)
    {
        super(input, output, temperature);

        TinkersInit.MELTING_RECIPES.add(this);
    }

    public MeltingRecipe(RecipeMatch input, FluidStack output)
    {
        super(input, output);

        TinkersInit.MELTING_RECIPES.add(this);
    }
}
