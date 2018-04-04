package minecraftschurli.mfm;


import minecraftschurli.mfm.proxy.CommonProxy;
import minecraftschurli.mfm.tabs.MFMTab;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import minecraftschurli.mfm.util.integrations.tinkers.TinkersIntegration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION_STRING,
        acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = Reference.DEPENDENCIES
)
public class Main 
{
	
	public static final CreativeTabs CREATIVETAB = new MFMTab("mfmtab");

    @Instance(Reference.MOD_ID)
	public static Main instance;

    @SidedProxy(modId = Reference.MOD_ID, clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
	    RegistryHandler.initRegistries();
        if(Loader.isModLoaded("tconstruct"))
        {
            if (Loader.isModLoaded("tinkersdefense")) {
                TinkersIntegration.INSTANCE.integrateWithShieldMaterials().close();
            } else {
                TinkersIntegration.INSTANCE.integrate().close();
            }
        }
		RegistryHandler.registerPotionsX();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
        RegistryHandler.registerRecipes();
        RegistryHandler.postInitRegistries();
    }

}
