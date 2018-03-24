package minecraftschurli.mfm.util.integrations.tinkers;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.Pair;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.ITrait;

import static slimeknights.tconstruct.library.materials.Material.VALUE_Gem;

public class TinkersMaterial
{

    public Material material;
    public MaterialStats matStat;
    private String oreDictSuffix;

    @SafeVarargs
    TinkersMaterial(String name, int color, String suffix, boolean part, boolean cast, Fluid fluid, MaterialStats matStat, Pair<ITrait, String>... traits)
    {

        this.material = new Material(name, color);
        this.matStat = matStat;
        this.oreDictSuffix = suffix;

        if(fluid!=null)
        {
            this.material.setFluid(fluid);
        }

        this.material.addCommonItems(suffix);
        if(OreDictionary.doesOreNameExist("gem"+suffix))this.material.addItem("gem"+suffix,1,VALUE_Gem);
        ITrait trait;
        String dep;

        for (Pair<ITrait, String> t : traits)
        {
            trait = t.getLeft();
            dep = t.getRight();
            if (dep != null)
            {
                this.material.addTrait(trait, dep);
            }
            else
            {
                this.material.addTrait(trait);
            }
        }

        this.material.setCastable(cast);
        this.material.setCraftable(part);
        this.material.setVisible();

        this.material.setRenderInfo(new slimeknights.tconstruct.library.client.MaterialRenderInfo.Default(color));

        TinkersInit.MATERIALS.addE(this);
    }

    public String getOreDictSuffix() {
        return oreDictSuffix;
    }
}
