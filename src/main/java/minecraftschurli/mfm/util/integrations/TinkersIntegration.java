package minecraftschurli.mfm.util.integrations;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.misc.FluidWithAmount;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInterModComms;

import java.util.Map;

public class TinkersIntegration
{
    public static void register()
    {
        registerMaterial(FluidInit.FLUID_VULCANIUM, BlockInit.ORE_NETHER_VULCANIUM);
    }
    public static void registerMaterial(Fluid fluid, Block ore)
    {
        // create NBT for the IMC
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName()); // name of the fluid
        tag.setString("ore", ore.getUnlocalizedName()); // ore-suffix: ingotFoo, blockFoo, oreFoo,...
        tag.setBoolean("toolforge", false); // if set to true, blockFoo can be used to build a toolforge

        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
    }

    public static void registerMaterial(Fluid fluid, Item item)
    {
        // create NBT for the IMC
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName()); // name of the fluid
        tag.setString("ore", item.getUnlocalizedName()); // ore-suffix: ingotFoo, blockFoo, oreFoo,...
        tag.setBoolean("toolforge", false); // if set to true, blockFoo can be used to build a toolforge

        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
    }

    public static void registerAlloy(FluidWithAmount output, FluidWithAmount input1, FluidWithAmount... input2)
    {
        NBTTagList tagList = new NBTTagList();
        // alloy output fluid
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", output.getFluid().getFluid().getName());
        fluid.setInteger("Amount", output.getAmount());
        tagList.appendTag(fluid);
        // first alloy fluid
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", input1.getFluid().getFluid().getName());
        fluid.setInteger("Amount", input1.getAmount());
        tagList.appendTag(fluid);
        // other alloy fluids
        for (FluidWithAmount in : input2) {
            fluid = new NBTTagCompound();
            fluid.setString("FluidName", in.getFluid().getFluid().getName());
            fluid.setInteger("Amount", in.getAmount());
            tagList.appendTag(fluid);
        }

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }

    public static void registerDryingRackRecipe(ItemStack input,ItemStack output,int timeInSeconds)
    {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setTag("input", input.writeToNBT(new NBTTagCompound()));
        tagCompound.setTag("output", output.writeToNBT(new NBTTagCompound()));
        tagCompound.setInteger("time", timeInSeconds);
        FMLInterModComms.sendMessage("tconstruct", "addDryingRecipe", tagCompound);
    }

}
