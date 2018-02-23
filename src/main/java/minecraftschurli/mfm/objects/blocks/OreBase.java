package minecraftschurli.mfm.objects.blocks;

import java.util.Random;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreBase extends Block implements IHasModel 
{

	private final ItemStack item;
	private final int dimension;
	private final int veinSize;
	private final int rarity;
	private final int minHeight;
	private final int maxHeight;
	private final Block baseBlock;
	private final int exp;
	
	/**
	 * 
	 * @param name
	 * @param material
	 * @param dimension
	 * @param veinSize
	 * @param rarity
	 * @param minHeight
	 * @param maxHeight
	 * @param exp
	 * @param baseBlock
	 * @param hardness
	 * @param resistance
	 * @param toolClass
	 * @param level
	 * @param item
	 */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, int exp, Block baseBlock, float hardness, float resistance, String toolClass, int level, ItemStack item) 
	{
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolClass, level);
        this.item = item;
        this.dimension = dimension;
        this.veinSize = veinSize;
        this.rarity = rarity;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.baseBlock = baseBlock;
        this.exp = exp;
        
        BlockInit.BLOCKS.add(this);
        BlockInit.ORES.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	/**
	 * 
	 * @param name
	 * @param material
	 * @param dimension
	 * @param veinSize
	 * @param rarity
	 * @param minHeight
	 * @param maxHeight
	 * @param exp
	 * @param hardness
	 * @param resistance
	 * @param toolClass
	 * @param level
	 * @param item
	 */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, int exp, float hardness, float resistance, String toolClass, int level, ItemStack item) 
	{
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolClass, level);
        this.item = item;
        this.dimension = dimension;
        this.veinSize = veinSize;
        this.rarity = rarity;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.baseBlock = dimension==-1?Blocks.NETHERRACK:dimension==1?Blocks.END_STONE:Blocks.STONE;
        this.exp = exp;
        
        BlockInit.BLOCKS.add(this);
        BlockInit.ORES.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	/**
	 * 
	 * @param name
	 * @param material
	 * @param dimension
	 * @param veinSize
	 * @param rarity
	 * @param minHeight
	 * @param maxHeight
	 * @param baseBlock
	 * @param hardness
	 * @param resistance
	 * @param toolClass
	 * @param level
	 */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, Block baseBlock, float hardness, float resistance, String toolClass, int level) 
	{
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolClass, level);
        this.item = null;
        this.dimension = dimension;
        this.veinSize = veinSize;
        this.rarity = rarity;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.baseBlock = baseBlock;
        this.exp = 0;
        
        BlockInit.BLOCKS.add(this);
        BlockInit.ORES.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	/**
	 * 
	 * @param name
	 * @param material
	 * @param dimension
	 * @param veinSize
	 * @param rarity
	 * @param minHeight
	 * @param maxHeight
	 * @param hardness
	 * @param resistance
	 * @param toolClass
	 * @param level
	 */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, float hardness, float resistance, String toolClass, int level) 
	{
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolClass, level);
        this.item = null;
        this.dimension = dimension;
        this.veinSize = veinSize;
        this.rarity = rarity;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.baseBlock = dimension==-1?Blocks.NETHERRACK:dimension==1?Blocks.END_STONE:Blocks.STONE;
        this.exp = 0;
        
        BlockInit.BLOCKS.add(this);
        BlockInit.ORES.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	public int getDimension() 
	{
		return dimension;
	}
	
	public int getVeinSize() 
	{
		return veinSize;
	}
	
	public int getRarity() 
	{
		return rarity;
	}
	
	public int getMinHeight() 
	{
		return minHeight;
	}
	
	public int getMaxHeight() 
	{
		return maxHeight;
	}
	
	public Block getBaseBlock() 
	{
		return baseBlock;
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return  item != null ? item.getItem() : Item.getItemFromBlock(this);
    }
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return super.getSilkTouchDrop(state);
	}
	
	public int quantityDropped(Random random)
    {
        return (Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(),random,0)) ? 1 + random.nextInt(2) : 1;
    }
	
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
    
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) 
    {
    	return Item.getItemFromBlock(this)==this.getItemDropped(state, null, fortune)?this.exp:0;
    }

}
