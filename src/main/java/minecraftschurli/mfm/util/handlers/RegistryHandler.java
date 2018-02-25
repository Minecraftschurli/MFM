package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.objects.blocks.BlockBase;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.world.gen.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
        for (Item item:ItemInit.ITEMS)
        {
            if(item instanceof ItemBase)
            {
                if (((ItemBase) item).oreDictName != null)
                {

                    OreDictionary.registerOre(((ItemBase) item).oreDictName,item);
                }
            }
        }
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        for (Block block:BlockInit.BLOCKS)
        {
            if(block instanceof BlockBase)
            {
                if (((BlockBase) block).oreDictName != null)
                {
                    OreDictionary.registerOre(((BlockBase) block).oreDictName,block);
                }
            }
        }

		TileEntityHandler.registerTileEntities();
	}

    public static void onFluidRegister()
    {
        Fluid fluid;
        if (FluidInit.FLUIDS != null)
            for (int i=0;i<FluidInit.FLUIDS.size();i++)
            {
                fluid = FluidInit.FLUIDS.get(i);
                if (fluid != null)
                {
                    FluidRegistry.registerFluid(fluid); // fluid has to be registered
                    FluidRegistry.addBucketForFluid(fluid); // add a bucket for the fluid
                    //BlockInit.BLOCKS.add(new BlockFluidClassic(fluid, Material.LAVA));
                }

            }
    }
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS)
		{	
			if (item instanceof IHasModel) 
			{
				((IHasModel) item).registerModels();
			}
		}
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries()
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
	
	public static void postInitRegistries()
	{
		
	}
	
	public static void otherRegistries() 
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
}
