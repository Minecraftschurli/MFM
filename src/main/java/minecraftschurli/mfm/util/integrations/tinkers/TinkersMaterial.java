package minecraftschurli.mfm.util.integrations.tinkers;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.List;

import static slimeknights.tconstruct.library.materials.Material.VALUE_Gem;

public class TinkersMaterial
{

    public Material material;
    public MaterialStats matStat;
    private String oreDictSuffix;

    TinkersMaterial(String name, int color, String suffix, boolean part,boolean cast, Fluid fluid, MaterialStats matStat, List<ITrait> traits, List<String> deps)
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

        for (int i = 0; i < traits.size(); i++)
        {
            trait = traits.get(i);
            dep = deps.get(i);
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
