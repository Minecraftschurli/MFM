package minecraftschurli.mfm.util.integrations;

import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.misc.List;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.tools.TinkerTraits;


public class TinkersInit
{
    public static final List<TinkersMaterial> MATERIALS = new List<>();

    public static final TinkersMaterial MATERIAL_VULCANIUM = new TinkersMaterial("vulcanium",16745728,"Vulcanium",
            false, FluidInit.FLUID_VULCANIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>().addE(TinkerTraits.autosmelt).addE(TinkerTraits.superheat).addE(TinkerTraits.flammable)),
            (new List<>().addE(MaterialTypes.HEAD).addE(null).addE(null)));
}