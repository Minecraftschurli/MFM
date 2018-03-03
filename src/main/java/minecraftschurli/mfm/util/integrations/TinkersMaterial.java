package minecraftschurli.mfm.util.integrations;

import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.List;

public class TinkersMaterial
{

    public final Material material;
    public final MaterialStats matStat;

    public TinkersMaterial(String name, int color, String suffix, boolean part, Fluid fluid, MaterialStats matStat, List<ITrait> traits, List<String> deps)
    {

        this.material = new Material(name, color, false);
        this.matStat = matStat;
        if(fluid!=null)this.material.setFluid(fluid);
        this.material.addCommonItems(suffix);
        ITrait trait;
        String dep;
        for (int i = 0; i < traits.size(); i++) {
            trait = traits.get(i);
            dep = deps.get(i);
            if (dep != null)
                this.material.addTrait(trait, dep);
            else
                this.material.addTrait(trait);

        }
        this.material.setCastable(!part);
        this.material.setCraftable(part);
        this.material.setVisible();

        TinkersInit.MATERIALS.add(this);
    }
}
