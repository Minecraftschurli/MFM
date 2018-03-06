package minecraftschurli.mfm.util.integrations.tinkers;

import minecraftschurli.mfm.util.misc.List;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;

import java.util.Objects;

import static slimeknights.tconstruct.library.materials.Material.VALUE_Ingot;

public class CastingRecipe extends slimeknights.tconstruct.library.smeltery.CastingRecipe implements ICastingRecipe
{
    private boolean basin;

    CastingRecipe(ItemStack output, Fluid fluid, int amount)
    {
        super(output, fluid, amount, calcCooldownTime(fluid, amount));

        basin = true;

        TinkersInit.CASTING_RECIPES.addE(this);
    }

    CastingRecipe(ItemStack output, RecipeMatch cast, Fluid fluid, int amount)
    {
        super(output, cast, new FluidStack(fluid, amount), calcCooldownTime(fluid, amount), false, false);

        basin = false;

        TinkersInit.CASTING_RECIPES.addE(this);
    }

    public boolean isBasin() {
        return basin;
    }

    @Override
    public ItemStack getResult() {
        return super.getResult();
    }

    @Override
    public FluidStack getFluid() {
        return super.getFluid();
    }

    public static List<CastingRecipe> addPartCasts(String material,Fluid fluid)
    {
        List<CastingRecipe> castingRecipeList = new List<>();
        NBTTagCompound nbt;

        String[] casts = {"pan_head","hammer_head","large_plate","axe_head","tool_rod","large_sword_blade","tough_tool_rod",
                "sign_head","cross_guard","tough_binding","hand_guard","knife_blade","shard","kama_head","shovel_head",
                "pick_head","scythe_head","excavator_head","wide_guard","bow_limb","broad_axe_head","sword_blade",
                "sharpening_kit","binding","arrow_head"};

        for (int i = 0; i < casts.length; i++)
        {
            nbt = new NBTTagCompound();
            nbt.setString("Material",material);
            ItemStack result = new ItemStack(Objects.requireNonNull(Item.getByNameOrId("tconstruct:" + casts[i])));
            result.setTagCompound(nbt);
            nbt = new NBTTagCompound();
            nbt.setString("PartType","tconstruct:"+casts[i]);
            ItemStack cast = new ItemStack(Objects.requireNonNull(Item.getByNameOrId("tconstruct:cast")));
            cast.setTagCompound(nbt);
            castingRecipeList.addE(new CastingRecipe(result,RecipeMatch.ofNBT(cast,
                    (int)((VALUE_Ingot)*valueMultiplicator(i))),
                    fluid,(int)((VALUE_Ingot)*valueMultiplicator(i))));
        }
        return castingRecipeList;
    }

    private static double valueMultiplicator(int i)
    {
        return (i==0?3:i==1?8:i==2?8:i==3?2:i==4?1:i==5?8:i==6?3:i==7?3:i==8?1:i==9?3:i==10?1:i==11?1:i==12?0.5:i==13?2:i==14?2:i==15?2:i==16?8:i==17?8:i==18?1:i==19?3:i==20?8:i==21?2:i==22?2:i==23?1:i==24?2:0);
    }
}
