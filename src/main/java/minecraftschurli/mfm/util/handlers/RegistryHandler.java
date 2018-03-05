package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.objects.blocks.BlockBase;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.util.integrations.tinkers.*;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.world.gen.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.Cast;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;

import static slimeknights.tconstruct.library.materials.Material.VALUE_Block;
import static slimeknights.tconstruct.library.materials.Material.VALUE_Ingot;

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
        for (int i=0;i<FluidInit.FLUIDS.size();i++)
        {
            fluid = (Fluid)FluidInit.FLUIDS.get(i);
            if (fluid != null)
            {
                FluidRegistry.registerFluid(fluid); // fluid has to be registered
                FluidRegistry.addBucketForFluid(fluid); // add a bucket for the fluid
                //BlockInit.BLOCKS.add(new BlockFluidClassic(fluid, Material.LAVA));
            }

        }

    }

    public static void onTinkersRegister()
    {
        for (int i = 0; i < TinkersInit.MATERIALS.size(); i++)
        {
            TinkersMaterial mat = (TinkersMaterial)TinkersInit.MATERIALS.get(i);
            slimeknights.tconstruct.library.materials.Material material = mat.material;
            TinkerRegistry.addMaterialStats(material,
                    new HeadMaterialStats(mat.matStat.getHeadDurability(), mat.matStat.getMiningSpeed(), mat.matStat.getAttackDamage(), mat.matStat.getMiningLevel()),
                    new HandleMaterialStats(mat.matStat.getHandleModifier(), mat.matStat.getHandleDurability()),
                    new ExtraMaterialStats(mat.matStat.getExtraDurability()),
                    new BowMaterialStats(mat.matStat.getDrawspeed(), mat.matStat.getRange(), mat.matStat.getBonusDamage()),
                    new ArrowShaftMaterialStats(mat.matStat.getArrowShaftModifier(),mat.matStat.getBonusAmmo())
            );

            TinkerRegistry.addMaterial(material);
        }
        for (int i = 0; i < TinkersInit.CASTING_RECIPES.size(); i++)
        {
            ICastingRecipe recipe = (ICastingRecipe) TinkersInit.CASTING_RECIPES.get(i);
            if(recipe instanceof CastingRecipe)
            {

                CastingRecipe rec = ((CastingRecipe)recipe);
                if(rec.isBasin())
                {
                    TinkerRegistry.registerBasinCasting(rec);
                }
                else
                {
                    TinkerRegistry.registerTableCasting(rec);
                }
            }
        }
        for (int i = 0; i < TinkersInit.MELTING_RECIPES.size(); i++)
        {
            MeltingRecipe recipe = (MeltingRecipe) TinkersInit.MELTING_RECIPES.get(i);
            TinkerRegistry.registerMelting(recipe);
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
