package minecraftschurli.mfm;


import minecraftschurli.mfm.proxy.CommonProxy;
import minecraftschurli.mfm.tabs.MFMTab;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import minecraftschurli.mfm.util.integrations.TinkersIntegration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MCVERSION)
public class Main 
{
	
	public static final CreativeTabs CREATIVETAB = new MFMTab("mfmtab");
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENTSIDE , serverSide = Reference.SERVERSIDE)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
        /*if(Loader.isModLoaded("tconstruct"))*/TinkersIntegration.register();
        RegistryHandler.onFluidRegister();
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
	    RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
        RegistryHandler.postInitRegistries();
	}

}
