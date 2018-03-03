package minecraftschurli.mfm.util.integrations;

import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.misc.List;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;
import slimeknights.tconstruct.tools.TinkerTraits;


public class TinkersInit
{
    public static final List<TinkersMaterial> MATERIALS = new List<>();
    public static final List<ICastingRecipe> RECIPES = new List<>();

    public static final TinkersMaterial MATERIAL_VULCANIUM = new TinkersMaterial("vulcanium",16739840,"Vulcanium",
            false, FluidInit.FLUID_VULCANIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>().addE(TinkerTraits.autosmelt).addE(TinkerTraits.superheat).addE(TinkerTraits.flammable)),
            (new List<>().addE(MaterialTypes.HEAD).addE(null).addE(null)));

    public static final TinkersMaterial MATERIAL_KANDIUM = new TinkersMaterial("kandium",58567,"Kandium",
            false, FluidInit.FLUID_KANDIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

    public static final TinkersMaterial MATERIAL_KANADIUM = new TinkersMaterial("kanadium",30719,"Kanadium",
            false, FluidInit.FLUID_KANADIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

    public static final TinkersMaterial MATERIAL_CRYSTAL = new TinkersMaterial("crystal",13697023,"Crystal",
            true, null, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

}