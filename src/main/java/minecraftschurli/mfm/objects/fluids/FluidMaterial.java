package minecraftschurli.mfm.objects.fluids;

import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class FluidMaterial extends FluidBase
{
    public FluidMaterial(String name,Color color)
    {
        super(name, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"),new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"),color);
        setGaseous(false);
    }
}
