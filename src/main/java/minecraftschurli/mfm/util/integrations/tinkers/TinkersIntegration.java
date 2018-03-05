package minecraftschurli.mfm.util.integrations.tinkers;


import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class TinkersIntegration
{
    public static TinkersIntegration INSTANCE = new TinkersIntegration();

    private TinkersIntegration() {}

    public TinkersIntegration integrate()
    {
        RegistryHandler.onTinkersRegister();
        TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidInit.FLUID_STANIUM,1),10000);

        return this;
    }

    public void close() { INSTANCE = null; }
}
