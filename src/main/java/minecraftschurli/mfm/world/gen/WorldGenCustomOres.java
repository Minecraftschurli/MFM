package minecraftschurli.mfm.world.gen;

import minecraftschurli.mfm.init.Init;
import minecraftschurli.mfm.objects.blocks.OreBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator 
{
	private List<WorldGenerator> ores;
	private List<int[]> data;
	
	public WorldGenCustomOres() 
	{
		ores = new ArrayList<>();
		data = new ArrayList<>();
		
		for (OreBase ore : Init.ORES) {
			addOreToGenerate(ore.getDefaultState(), ore.getBaseBlock(), ore.getVeinSize(), ore.getDimension(), ore.getRarity(), ore.getMinHeight(), ore.getMaxHeight());
		}
		
	}
	
	public void addOreToGenerate(IBlockState ore, Block base, int veinSize, int dimension, int rarity, int minHeight,int maxHeight)
	{
		int[] arr = {dimension,rarity,minHeight,maxHeight};
		data.add(arr);
		ores.add(new WorldGenMinable(ore, veinSize,BlockMatcher.forBlock(base)));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		for (int i = 0; i < ores.size(); i++) 
		{
			int[] dataTmp = data.get(i);
			WorldGenerator ore = ores.get(i);
			if (dataTmp[0] == world.provider.getDimension())
			{
				runGenerator(ore, world, random, chunkX, chunkZ, dataTmp[1], dataTmp[2], dataTmp[3]);
			}
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}

}
