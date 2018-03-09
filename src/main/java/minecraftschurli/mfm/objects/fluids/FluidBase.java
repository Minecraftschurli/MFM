package minecraftschurli.mfm.objects.fluids;

import minecraftschurli.mfm.init.FluidInit;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.awt.*;


public class FluidBase extends Fluid
{
    FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing, Color color)
    {
        super(fluidName,still,flowing,color);

        setUnlocalizedName(fluidName);

        FluidInit.FLUIDS.addE(this);
    }

    FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing, int color)
    {
        super(fluidName,still,flowing,color);

        setUnlocalizedName(fluidName);

        FluidInit.FLUIDS.addE(this);
    }

    FluidBase(String fluidName, ResourceLocation still, ResourceLocation flowing)
    {
        super(fluidName,still,flowing);

        setUnlocalizedName(fluidName);

        FluidInit.FLUIDS.addE(this);
    }


}
