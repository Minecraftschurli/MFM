package minecraftschurli.mfm.util.integrations;


import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.ITrait;

import java.util.List;

public class TinkersIntegration
{
    public static void addToolMaterial(String name, int color, String suffix, boolean part, Fluid fluid, MaterialStats matStat, List<ITrait> traits, List<String> deps) {
        Material material = new Material(name, color, false);
        material.setFluid(fluid);
        material.addCommonItems(suffix);
        ITrait trait;
        String dep;
        for (int i = 0; i < traits.size(); i++) {
            trait = traits.get(i);
            dep = deps.get(i);
            if (dep != null)
                material.addTrait(trait, dep);
            else
                material.addTrait(trait);

        }
        material.setCastable(!part);
        material.setCraftable(part);
        material.setVisible();
        TinkerRegistry.addMaterialStats(material,
                new HeadMaterialStats(matStat.getHeadDurability(), matStat.getMiningSpeed(), matStat.getAttackDamage(), matStat.getMiningLevel()),
                new HandleMaterialStats(matStat.getHandleModifier(), matStat.getHandleDurability()),
                new ExtraMaterialStats(matStat.getExtraDurability()),
                new BowMaterialStats(matStat.getDrawspeed(), matStat.getRange(), matStat.getBonusDamage()));
        TinkerRegistry.addMaterial(material);
    }

}
