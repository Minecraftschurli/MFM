package minecraftschurli.mfm.util.integrations.tinkers;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.misc.List;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;
import slimeknights.tconstruct.tools.TinkerTraits;

import static slimeknights.tconstruct.library.materials.Material.VALUE_Block;


public class TinkersInit
{
    public static final List<TinkersMaterial> MATERIALS = new List<>();
    public static final List<ICastingRecipe> RECIPES = new List<>();

    public static final TinkersMaterial MATERIAL_VULCANIUM = new TinkersMaterial("vulcanium",16739840,"Vulcanium",
            false,true, FluidInit.FLUID_VULCANIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>().addE(TinkerTraits.autosmelt).addE(TinkerTraits.superheat).addE(TinkerTraits.flammable)),
            (new List<>().addE(MaterialTypes.HEAD).addE(null).addE(null)));

    public static final TinkersMaterial MATERIAL_KANDIUM = new TinkersMaterial("kandium",58567,"Kandium",
            false,true, FluidInit.FLUID_KANDIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

    public static final TinkersMaterial MATERIAL_KANADIUM = new TinkersMaterial("kanadium",30719,"Kanadium",
            false,true, FluidInit.FLUID_KANADIUM, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

    public static final TinkersMaterial MATERIAL_CRYSTAL = new TinkersMaterial("crystal",15794175,"Crystal",
            true,false, null, new MaterialStats(0,0,0,0,
            0,0,0,0,0,0),
            (new List<>()),
            (new List<>()));

    public static final CastingRecipe BLOCK_VULCANIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_VULCANIUM),FluidInit.FLUID_VULCANIUM,VALUE_Block);
    public static final CastingRecipe BLOCK_KANDIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_KANDIUM),FluidInit.FLUID_KANDIUM,VALUE_Block);
    public static final CastingRecipe BLOCK_KANADIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_KANADIUM),FluidInit.FLUID_KANADIUM,VALUE_Block);

}