package minecraftschurli.mfm.util.handlers;

import lance5057.tDefense.core.materials.ShieldMaterialStats;
import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.FluidInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.init.PotionInit;
import minecraftschurli.mfm.objects.items.ItemBase;
import minecraftschurli.mfm.util.Reference;
import minecraftschurli.mfm.util.integrations.tinkers.CastingRecipe;
import minecraftschurli.mfm.util.integrations.tinkers.MeltingRecipe;
import minecraftschurli.mfm.util.integrations.tinkers.TinkersInit;
import minecraftschurli.mfm.util.integrations.tinkers.TinkersMaterial;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import minecraftschurli.mfm.world.gen.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;

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
        /*for (Block block:BlockInit.BLOCKS)
        {
            if(block instanceof BlockBase)
            {
                if (((BlockBase) block).oreDictName != null)
                {
                    OreDictionary.registerOre(((BlockBase) block).oreDictName,block);
                }
            }
        }*/

		TileEntityHandler.registerTileEntities();

        onFluidRegister(event);
    }

    private static void onFluidRegister(RegistryEvent.Register<Block> event)
    {
        Fluid fluid;
        for (int i=0;i<FluidInit.FLUIDS.size();i++)
        {
            fluid = (Fluid)FluidInit.FLUIDS.get(i);
            if (fluid != null)
            {
                FluidRegistry.registerFluid(fluid); // fluid has to be registered
                FluidRegistry.addBucketForFluid(fluid); // add a bucket for the fluid
                try {
                    event.getRegistry().register(new BlockFluidClassic(fluid, net.minecraft.block.material.Material.LAVA));
                } catch (Exception ignored) {
                }
            }

        }

    }


    public static void onTinkersRegister(boolean tD)
    {
        for (int i = 0; i < TinkersInit.MATERIALS.size(); i++)
        {
            TinkersMaterial mat = TinkersInit.MATERIALS.get(i);
            slimeknights.tconstruct.library.materials.Material material = mat.material;
            if (tD) {
                TinkerRegistry.addMaterialStats(material,
                        new HeadMaterialStats(mat.matStat.getHeadDurability(), mat.matStat.getMiningSpeed(), mat.matStat.getAttackDamage(), mat.matStat.getMiningLevel()),
                        new HandleMaterialStats(mat.matStat.getHandleModifier(), mat.matStat.getHandleDurability()),
                        new ExtraMaterialStats(mat.matStat.getExtraDurability()),
                        new BowMaterialStats(mat.matStat.getDrawspeed(), mat.matStat.getRange(), mat.matStat.getBonusDamage()),
                        new ArrowShaftMaterialStats(mat.matStat.getArrowShaftModifier(), mat.matStat.getBonusAmmo()),
                        new ShieldMaterialStats(mat.matStat.getShieldDurability(), mat.matStat.getShieldBlocking())
                );
            } else {
                TinkerRegistry.addMaterialStats(material,
                        new HeadMaterialStats(mat.matStat.getHeadDurability(), mat.matStat.getMiningSpeed(), mat.matStat.getAttackDamage(), mat.matStat.getMiningLevel()),
                        new HandleMaterialStats(mat.matStat.getHandleModifier(), mat.matStat.getHandleDurability()),
                        new ExtraMaterialStats(mat.matStat.getExtraDurability()),
                        new BowMaterialStats(mat.matStat.getDrawspeed(), mat.matStat.getRange(), mat.matStat.getBonusDamage()),
                        new ArrowShaftMaterialStats(mat.matStat.getArrowShaftModifier(), mat.matStat.getBonusAmmo())
                );
            }
            TinkerRegistry.addMaterial(material);
        }
        for (int i = 0; i < TinkersInit.CASTING_RECIPES.size(); i++)
        {
            ICastingRecipe recipe = TinkersInit.CASTING_RECIPES.get(i);
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
            MeltingRecipe recipe = TinkersInit.MELTING_RECIPES.get(i);
            TinkerRegistry.registerMelting(recipe);
        }

    }
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
        OBJLoader.INSTANCE.addDomain(Reference.MOD_ID + ":models/block");
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

    public static void registerPotionsX() {
        //registerPotionTypes();
    }

    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        event.getRegistry().registerAll(PotionInit.POTIONS.toArray(new Potion[0]));
    }

    @SubscribeEvent
    public static void registerPotionTypes(RegistryEvent.Register<PotionType> event) {
        PotionInit.POTION_ITEMS.add(new PotionType("bleeding", new PotionEffect(PotionInit.BLEEDING, 900, 0)).setRegistryName(Reference.MOD_ID, "bleeding"));
        PotionInit.POTION_ITEMS.add(new PotionType("bleeding", new PotionEffect(PotionInit.BLEEDING, 1800, 0)).setRegistryName(Reference.MOD_ID, "long_bleeding"));
        PotionInit.POTION_ITEMS.add(new PotionType("bleeding", new PotionEffect(PotionInit.BLEEDING, 432, 1)).setRegistryName(Reference.MOD_ID, "strong_bleeding"));
        PotionInit.POTION_ITEMS.add(new PotionType(new PotionEffect(PotionInit.SLOWFALL, 3600, 0)).setRegistryName(Reference.MOD_ID, "slowfall"));
        PotionInit.POTION_ITEMS.add(new PotionType(new PotionEffect(PotionInit.HIGH, 1800), new PotionEffect(MobEffects.RESISTANCE, 1800, 1), new PotionEffect(MobEffects.ABSORPTION, 1800, 1), new PotionEffect(MobEffects.SPEED, 1800), new PotionEffect(MobEffects.STRENGTH, 1800)).setRegistryName(Reference.MOD_ID, "anabolic"));

        event.getRegistry().registerAll(PotionInit.POTION_ITEMS.toArray(new PotionType[0]));
        for (PotionType potion : PotionInit.POTION_ITEMS) {
            PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potion);
        }

    }

    public static void registerRecipes() {
        RecipeHandler.addStandardRecipes();
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
