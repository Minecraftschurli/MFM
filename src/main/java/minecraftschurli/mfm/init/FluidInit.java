package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.fluids.FluidMaterial;
import net.minecraftforge.fluids.Fluid;
import minecraftschurli.mfm.util.misc.List;

import java.awt.*;


public class FluidInit
{

    public static final List<Fluid> FLUIDS = new List<>();


    public static final Fluid FLUID_VULCANIUM = new FluidMaterial("fluid_vulcanium", new Color(255,110,0,255));
    public static final Fluid FLUID_KANDIUM = new FluidMaterial("fluid_kandium",new Color(0,228,199,255));
    public static final Fluid FLUID_KANADIUM = new FluidMaterial("fluid_kanadium",new Color(0,119,255,255)).setTemperature(100000);
    public static final Fluid FLUID_STANIUM = new FluidMaterial("fluid_stanium",new Color(255,40,0,255)).setTemperature(1000000);

}
