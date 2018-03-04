package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.fluids.FluidMaterial;
import net.minecraftforge.fluids.Fluid;
import minecraftschurli.mfm.util.misc.List;


public class FluidInit
{

    public static final List<Fluid> FLUIDS = new List<>();


    public static final Fluid FLUID_VULCANIUM = new FluidMaterial("fluid_vulcanium",255,110,0);
    public static final Fluid FLUID_KANDIUM = new FluidMaterial("fluid_kandium",0,228,199);
    public static final Fluid FLUID_KANADIUM = new FluidMaterial("fluid_kanadium",0,119,255).setTemperature(100000);
    public static final Fluid FLUID_STANIUM = new FluidMaterial("fluid_stanium",255,40,0).setTemperature(1000000);

}
