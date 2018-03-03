package minecraftschurli.mfm.objects.fluids;

import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class FluidMaterial extends FluidBase
{
    public FluidMaterial(String name,int r,int g,int b)
    {
        super(name, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"),new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"),new Color(r,g,b));
        setGaseous(false);
    }
}
