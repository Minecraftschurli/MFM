package minecraftschurli.mfm.objects.fluids;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class FluidBase extends Fluid
{
    public FluidBase(String name,int color)
    {
        super(name, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"),new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"),color);
        setGaseous(false);

        if(this!=null)
        {
            FluidInit.FLUIDS.add(this);
        }

    }

}
