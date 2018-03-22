package minecraftschurli.mfm.util.integrations.tinkers;


import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;

public class TinkersIntegration
{
    public static TinkersIntegration INSTANCE = new TinkersIntegration();

    private TinkersIntegration() {}

    public TinkersIntegration integrate()
    {
        RegistryHandler.onTinkersRegister(false);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidInit.FLUID_STANIUM,1),10000);

        return this;
    }

    public void close() { INSTANCE = null; }

    public TinkersIntegration integrateWithShieldMaterials() {
        RegistryHandler.onTinkersRegister(true);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidInit.FLUID_STANIUM, 1), 10000);

        return this;
    }
}
