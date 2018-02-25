package minecraftschurli.mfm.init;

import java.util.ArrayList;
import java.util.List;

import minecraftschurli.mfm.objects.blocks.BlockBase;
import minecraftschurli.mfm.objects.blocks.OreBase;
import minecraftschurli.mfm.objects.blocks.machines.alloyer.BlockAlloyingFurnace;
import minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.BlockStaniumSmelter;
import minecraftschurli.mfm.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<OreBase> ORES = new ArrayList<OreBase>();
	
	//Blocks
	public static final Block BLOCK_OP = new BlockBase("block_op",Material.IRON,"Op");
	public static final Block BLOCK_VULCANIUM = new BlockBase("block_vulcanium",Material.IRON,"Vulcanium");
	public static final Block BLOCK_KANDIUM = new BlockBase("block_kandium",Material.IRON,"Kandium");
	public static final Block BLOCK_KANADIUM = new BlockBase("block_kanadium",Material.IRON,"Kanadium");
	public static final Block BLOCK_STANIUM = new BlockBase("block_stanium",Material.IRON,"Stanium");
	public static final Block BLOCK_CRYSTAL = new BlockBase("block_crystal",Material.IRON,"Crystal");

	//Ores
	public static final Block ORE_NETHER_VULCANIUM = new OreBase("ore_nether_vulcanium", new Material(MapColor.NETHERRACK), -1, 8, 11,10, 100, 20, 40, "pickaxe", 4,"Vulcanium");
	public static final Block ORE_NETHER_STANIUM = new OreBase("ore_nether_stanium", new Material(MapColor.NETHERRACK), -1, 10, 20, 10, 110, 18, 30, "pickaxe", 2,"Stanium");
	public static final Block ORE_OVERWORLD_KANDIUM = new OreBase("ore_overworld_kandium", new Material(MapColor.STONE), 0, 8, 4, 4, 10, 18, 45, "pickaxe", 3,"Kandium");
	public static final Block ORE_OVERWORLD_CRYSTAL = new OreBase("ore_overworld_crystal", new Material(MapColor.STONE), 0, 2, 5, 4, 40, 5, 16F, 20F, "pickaxe", 2, new ItemStack(ItemInit.GEM_CRYSTAL),"Crystal");
	public static final Block ORE_END_CRYSTAL = new OreBase("ore_end_crystal", new Material(MapColor.SAND), 1, 5, 10, 0, 256, 5, 20F, 40F, "pickaxe", 3, new ItemStack(ItemInit.GEM_CRYSTAL),"Crystal");
	
	//TileEntitys
	public static final Block ALLOYING_FURNACE = new BlockAlloyingFurnace("alloying_furnace");
	public static final Block STANIUM_SMELTER = new BlockStaniumSmelter("stanium_smelter");

	
}
