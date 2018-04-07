package minecraftschurli.mfm.init;

import minecraftschurli.mfm.objects.blocks.BlockBase;
import minecraftschurli.mfm.objects.blocks.OreBase;
import minecraftschurli.mfm.objects.blocks.crop.CropCaneBase;
import minecraftschurli.mfm.objects.blocks.machines.alloyer.BlockAlloyingFurnace;
import minecraftschurli.mfm.objects.blocks.machines.multiblocks.godiumrefiner.BlockGodiumRefinerController;
import minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.BlockStaniumSmelter;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

	//Blocks
	public static final Block BLOCK_OP = new BlockBase("block_op",Material.IRON,"Op");
	public static final Block BLOCK_VULCANIUM = new BlockBase("block_vulcanium",Material.IRON,"Vulcanium");
	public static final Block BLOCK_KANDIUM = new BlockBase("block_kandium",Material.IRON,"Kandium");
	public static final Block BLOCK_KANADIUM = new BlockBase("block_kanadium",Material.IRON,"Kanadium");
	public static final Block BLOCK_STANIUM = new BlockBase("block_stanium",Material.IRON,"Stanium");
	public static final Block BLOCK_CRYSTAL = new BlockBase("block_crystal",Material.IRON,"Crystal");
    public static final Block BLOCK_GODIUM = new BlockBase("block_godium", Material.IRON, "Godium");
    public static final Block GREENSCREEN = new BlockBase("greenscreen", Material.ROCK).setLightLevel(1.0F).setResistance(6000000.0F);

	//Ores
	public static final Block ORE_NETHER_VULCANIUM = new OreBase("ore_nether_vulcanium",
            new Material(MapColor.NETHERRACK), -1, 8, 11, 10, 100,
			Blocks.NETHERRACK, 20, 40, "pickaxe", 5, "Vulcanium").setGenerate();

	public static final Block ORE_NETHER_STANIUM = new OreBase("ore_nether_stanium",
            new Material(MapColor.NETHERRACK), -1, 10, 20, 10, 110, 1,
            Blocks.NETHERRACK, 18F, 30F, "pickaxe", 2, new ItemStack(ItemInit.GEM_STANIUM),
			"Stanium").setGenerate();

	public static final Block ORE_OVERWORLD_KANDIUM = new OreBase("ore_overworld_kandium",
            new Material(MapColor.STONE), 0, 8, 4, 4, 10, Blocks.STONE,
			18, 45, "pickaxe", 3, "Kandium").setGenerate();

	public static final Block ORE_OVERWORLD_CRYSTAL = new OreBase("ore_overworld_crystal",
            new Material(MapColor.STONE), 0, 2, 5, 4, 40, 5, Blocks.STONE,
			16F, 20F, "pickaxe", 3, new ItemStack(ItemInit.GEM_CRYSTAL),
			"Crystal").setGenerate();

	public static final Block ORE_END_CRYSTAL = new OreBase("ore_end_crystal", new Material(MapColor.SAND),
            1, 5, 15, 0, 256, 5, Blocks.END_STONE, 20F,
			40F, "pickaxe", 4, new ItemStack(ItemInit.GEM_CRYSTAL),
			"Crystal").setGenerate();
	
	//TileEntitys
	public static final Block ALLOYING_FURNACE = new BlockAlloyingFurnace("alloying_furnace");
	public static final Block STANIUM_SMELTER = new BlockStaniumSmelter("stanium_smelter");
	public static final Block GODIUM_REFINER_CONTROLLER = new BlockGodiumRefinerController();


    public static final Block CROP_ENDCANE = new CropCaneBase("crop_endcane", ItemInit.ENDCANE, 4, Blocks.END_STONE.getDefaultState());
}
