package minecraftschurli.mfm.util.misc;

import net.minecraftforge.fluids.FluidStack;

public class FluidWithAmount
{
    private int amount;
    private FluidStack fluid;

    public FluidWithAmount(FluidStack fluid, int amount)
    {
        this.fluid = fluid;
        this.amount = amount;
    }

    public FluidStack getFluid() {
        return fluid;
    }

    public int getAmount() {
        return amount;
    }
}
