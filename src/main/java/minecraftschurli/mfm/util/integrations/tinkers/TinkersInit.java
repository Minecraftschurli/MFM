package minecraftschurli.mfm.util.integrations.tinkers;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.misc.Pair;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static slimeknights.tconstruct.library.materials.Material.*;

@SuppressWarnings({"unchecked", "ConfusingArgumentToVarargsMethod"})
public class TinkersInit
{
    public static final List<TinkersMaterial> MATERIALS = new ArrayList<>();
    public static final List<ICastingRecipe> CASTING_RECIPES = new ArrayList<>();
    public static final List<MeltingRecipe> MELTING_RECIPES = new ArrayList<>();
    public static final String NONE = null;

    public static final TinkersMaterial MATERIAL_VULCANIUM = new TinkersMaterial("vulcanium",
            new Color(222, 155, 0, 255).getRGB(), "Vulcanium", false, true,
            FluidInit.FLUID_VULCANIUM, new MaterialStats(900, 6, 100,
            300, 10, 5.5F, 1.5F, 7, 1.2F, 8.5F,
            9, 1, 900, 33),
            new Pair<>(TraitsAndModifires.liquidizing, MaterialTypes.HEAD), new Pair<>(TraitsAndModifires.vulcanic, NONE));


    public static final TinkersMaterial MATERIAL_KANDIUM = new TinkersMaterial("kandium",
            new Color(0, 228, 199, 255).getRGB(), "Kandium", false, true,
            FluidInit.FLUID_KANDIUM, new MaterialStats(0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0),
            new Pair<>(null, null));

    public static final TinkersMaterial MATERIAL_KANADIUM = new TinkersMaterial("kanadium",new Color(0,119,255,255).getRGB(),"Kanadium",
            false,true, FluidInit.FLUID_KANADIUM, new MaterialStats(0,0,0,0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            new Pair<>(null, null));

    public static final TinkersMaterial MATERIAL_CRYSTAL = new TinkersMaterial("crystal",new Color(240,255,255,255).getRGB(),"Crystal",
            true,false, null, new MaterialStats(0,0,0,0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            new Pair<>(null, null));

    public static final CastingRecipe CASTING_BLOCK_VULCANIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_VULCANIUM),
            FluidInit.FLUID_VULCANIUM,VALUE_Block);
    public static final CastingRecipe CASTING_BLOCK_KANDIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_KANDIUM),
            FluidInit.FLUID_KANDIUM,VALUE_Block);
    public static final CastingRecipe CASTING_BLOCK_KANADIUM = new CastingRecipe(new ItemStack(BlockInit.BLOCK_KANADIUM),
            FluidInit.FLUID_KANADIUM,VALUE_Block);

    public static final CastingRecipe CASTING_INGOT_VULCANIUM = new CastingRecipe(new ItemStack(ItemInit.INGOT_VULCANIUM),
            RecipeMatch.of(Item.getByNameOrId("tconstruct:cast_custom")),FluidInit.FLUID_VULCANIUM,VALUE_Ingot);
    public static final CastingRecipe CASTING_INGOT_KANDIUM = new CastingRecipe(new ItemStack(ItemInit.INGOT_KANDIUM),
            RecipeMatch.of(Item.getByNameOrId("tconstruct:cast_custom")),FluidInit.FLUID_KANDIUM,VALUE_Ingot);
    public static final CastingRecipe CASTING_INGOT_KANADIUM = new CastingRecipe(new ItemStack(ItemInit.INGOT_KANADIUM),
            RecipeMatch.of(Item.getByNameOrId("tconstruct:cast_custom")),FluidInit.FLUID_KANADIUM,VALUE_Ingot);

    public static final List<CastingRecipe> CASTING_PARTS_VULCANIUM = CastingRecipe.addPartCasts("vulcanium",FluidInit.FLUID_VULCANIUM);
    public static final List<CastingRecipe> CASTING_PARTS_KANDIUM = CastingRecipe.addPartCasts("kandium",FluidInit.FLUID_KANDIUM);
    public static final List<CastingRecipe> CASTING_PARTS_KANADIUM = CastingRecipe.addPartCasts("kanadium",FluidInit.FLUID_KANADIUM);

    public static final MeltingRecipe MELTING_ORE_VULCANIUM = new MeltingRecipe(RecipeMatch.of(BlockInit.ORE_NETHER_VULCANIUM,VALUE_Ore()),
            new FluidStack(FluidInit.FLUID_VULCANIUM,VALUE_Ore()),1000000);
    public static final MeltingRecipe MELTING_ORE_KANDIUM = new MeltingRecipe(RecipeMatch.of(BlockInit.ORE_OVERWORLD_KANDIUM,VALUE_Ore()),
            new FluidStack(FluidInit.FLUID_KANDIUM, VALUE_Ore()));

    public static final MeltingRecipe MELTING_INGOT_VULCANIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.INGOT_VULCANIUM,VALUE_Ingot),
            new FluidStack(FluidInit.FLUID_VULCANIUM,VALUE_Ingot),1000000);
    public static final MeltingRecipe MELTING_INGOT_KANDIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.INGOT_KANDIUM,VALUE_Ingot),
            new FluidStack(FluidInit.FLUID_KANDIUM,VALUE_Ingot));
    public static final MeltingRecipe MELTING_INGOT_KANADIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.INGOT_KANADIUM,VALUE_Ingot),
            new FluidStack(FluidInit.FLUID_KANADIUM,VALUE_Ingot));

    public static final MeltingRecipe MELTING_BLOCK_VULCANIUM = new MeltingRecipe(RecipeMatch.of(BlockInit.BLOCK_VULCANIUM,VALUE_Block),
            new FluidStack(FluidInit.FLUID_VULCANIUM,VALUE_Block),1000000);
    public static final MeltingRecipe MELTING_BLOCK_KANDIUM = new MeltingRecipe(RecipeMatch.of(BlockInit.BLOCK_KANDIUM,VALUE_Block),
            new FluidStack(FluidInit.FLUID_KANDIUM,VALUE_Block));
    public static final MeltingRecipe MELTING_BLOCK_KANADIUM = new MeltingRecipe(RecipeMatch.of(BlockInit.BLOCK_KANADIUM,VALUE_Block),
            new FluidStack(FluidInit.FLUID_KANADIUM,VALUE_Block));

    public static final MeltingRecipe MELTING_NUGGET_VULCANIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_VULCANIUM,VALUE_Nugget),
            new FluidStack(FluidInit.FLUID_VULCANIUM,VALUE_Nugget),1000000);
    public static final MeltingRecipe MELTING_NUGGET_KANDIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_KANDIUM,VALUE_Nugget),
            new FluidStack(FluidInit.FLUID_KANDIUM,VALUE_Nugget));
    public static final MeltingRecipe MELTING_NUGGET_KANADIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_KANADIUM,VALUE_Nugget),
            new FluidStack(FluidInit.FLUID_KANADIUM,VALUE_Nugget));

    /*public static final MeltingRecipe MELTING_PARTS_VULCANIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_VULCANIUM),
            new FluidStack(FluidInit.FLUID_VULCANIUM,VALUE_Nugget),1000000);
    public static final MeltingRecipe MELTING_PARTS_KANDIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_KANDIUM),
            new FluidStack(FluidInit.FLUID_KANDIUM,VALUE_Nugget));
    public static final MeltingRecipe MELTING_PARTS_KANADIUM = new MeltingRecipe(RecipeMatch.of(ItemInit.NUGGET_KANADIUM),
            new FluidStack(FluidInit.FLUID_KANADIUM,VALUE_Nugget));*/


}