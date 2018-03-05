package minecraftschurli.mfm.util.integrations.tinkers;


import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;

public class TinkersIntegration
{
    public static TinkersIntegration INSTANCE;

    public TinkersIntegration()
    {
        INSTANCE = this;
    }

    public TinkersIntegration integrate()
    {
        RegistryHandler.onTinkersRegister();
        TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidInit.FLUID_STANIUM,1),10000);

        return this;
    }

    public void close()
    {
        INSTANCE = null;
    }
}
