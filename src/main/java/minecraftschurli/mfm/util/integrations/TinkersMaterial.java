package minecraftschurli.mfm.util.integrations;

import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.List;

public class TinkersMaterial
{
    public TinkersMaterial(String name, int color, String suffix, boolean part, Fluid fluid, MaterialStats matStat, List<ITrait> traits, List<String> deps)
    {
        TinkersIntegration.addToolMaterial(name, color, suffix, part, fluid, matStat, traits, deps);

        TinkersInit.MATERIALS.add(this);
    }
}
