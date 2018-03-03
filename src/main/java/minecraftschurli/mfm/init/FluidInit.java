package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.fluids.FluidMaterial;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;

public class FluidInit
{

    public static final List<Fluid> FLUIDS = new ArrayList<>();


    public static final Fluid FLUID_VULCANIUM = new FluidMaterial("fluid_vulcanium",255,110,0);
    public static final Fluid FLUID_KANDIUM = new FluidMaterial("fluid_kandium",0,228,199);
    public static final Fluid FLUID_KANADIUM = new FluidMaterial("fluid_kanadium",0,119,255);

}
