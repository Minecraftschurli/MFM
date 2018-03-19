package minecraftschurli.mfm;


import minecraftschurli.mfm.proxy.CommonProxy;
import minecraftschurli.mfm.tabs.MFMTab;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.handlers.RegistryHandler;
import minecraftschurli.mfm.util.integrations.tinkers.TinkersIntegration;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.MC_VERSION_STRING + "-" + Reference.MAJOR_MOD_VERSION + "." + Reference.MAJOR_API_VERSION + "." + Reference.MINOR_API_MOD_VERSION + "." + Reference.PATCH_VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = "after:tconstruct, after:thermalfoundation"
)
public class Main 
{
	
	public static final CreativeTabs CREATIVETAB = new MFMTab("mfmtab");
    public static final CreativeTabs CREATIVETAB2 = new CreativeTabs("mapBuildingUtils") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Blocks.COMMAND_BLOCK);
        }
    };

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
            TinkersIntegration.INSTANCE.integrate().close();
        }
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
        RegistryHandler.postInitRegistries();
        Item.getByNameOrId("command_block_minecart").setCreativeTab(CREATIVETAB2);//TODO move to its own mod
        Blocks.COMMAND_BLOCK.setCreativeTab(CREATIVETAB2);
        Blocks.CHAIN_COMMAND_BLOCK.setCreativeTab(CREATIVETAB2);
        Blocks.REPEATING_COMMAND_BLOCK.setCreativeTab(CREATIVETAB2);
        Blocks.STRUCTURE_BLOCK.setCreativeTab(CREATIVETAB2);
        Blocks.STRUCTURE_VOID.setCreativeTab(CREATIVETAB2);
        Blocks.BARRIER.setCreativeTab(CREATIVETAB2);
	}

}
