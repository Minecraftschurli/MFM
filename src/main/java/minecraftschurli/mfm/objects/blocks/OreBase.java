package minecraftschurli.mfm.objects.blocks;

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

import java.util.Objects;
import java.util.Random;

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
    private final String oreDictName;

    /**
     *
     * @param name The name of the Ore
     * @param material The material of the Ore
     * @param dimension The dimension the Ore generates in
     * @param veinSize The size of the Ore vein
     * @param rarity The rarity of the Ore
     * @param minHeight The minimum height the Ore spawns at
     * @param maxHeight The maximum height the Ore spawns at
     * @param exp The experience the Ore drops when harvested
     * @param baseBlock The base of the Ore
     * @param hardness The block hardness
     * @param resistance The explosion resistance of the Ore
     * @param toolClass The tool class the Ore can be broken with
     * @param level The harvest level of the Ore
     * @param item The Item that drops from the Ore
	 */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, int exp, Block baseBlock, float hardness, float resistance, String toolClass, int level, ItemStack item, String oreDict)
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
        this.oreDictName = "block"+oreDict;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
    }

    /**
     * @param name       The name of the Ore
     * @param material   The material of the Ore
     * @param dimension  The dimension the Ore generates in
     * @param veinSize   The size of the Ore vein
     * @param rarity     The rarity of the Ore
     * @param minHeight  The minimum height the Ore spawns at
     * @param maxHeight  The maximum height the Ore spawns at
     * @param exp        The experience the Ore drops when harvested
     * @param hardness   The block hardness
     * @param resistance The explosion resistance of the Ore
     * @param toolClass  The tool class the Ore can be broken with
     * @param level      The harvest level of the Ore
     * @param item       The Item that drops from the Ore
     */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, int exp, float hardness, float resistance, String toolClass, int level, ItemStack item, String oreDict)
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
        this.oreDictName = "ore"+oreDict;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
    }

    /**
     * @param name       The name of the Ore
     * @param material   The material of the Ore
     * @param dimension  The dimension the Ore generates in
     * @param veinSize   The size of the Ore vein
     * @param rarity     The rarity of the Ore
     * @param minHeight  The minimum height the Ore spawns at
     * @param maxHeight  The maximum height the Ore spawns at
     * @param baseBlock  The base of the Ore
     * @param hardness   The block hardness
     * @param resistance The explosion resistance of the Ore
     * @param toolClass  The tool class the Ore can be broken with
     * @param level      The harvest level of the Ore
     */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, Block baseBlock, float hardness, float resistance, String toolClass, int level, String oreDict)
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
        this.oreDictName = "ore"+oreDict;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
    }

    /**
     * @param name       The name of the Ore
     * @param material   The material of the Ore
     * @param dimension  The dimension the Ore generates in
     * @param veinSize   The size of the Ore vein
     * @param rarity     The rarity of the Ore
     * @param minHeight  The minimum height the Ore spawns at
     * @param maxHeight  The maximum height the Ore spawns at
     * @param hardness   The block hardness
     * @param resistance The explosion resistance of the Ore
     * @param toolClass  The tool class the Ore can be broken with
     * @param level      The harvest level of the Ore
     */
	public OreBase(String name, Material material, int dimension, int veinSize, int rarity, int minHeight, int maxHeight, float hardness, float resistance, String toolClass, int level, String oreDict)
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
        this.oreDictName = "ore"+oreDict;

		BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));
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
        return this.item != null ? item.getItem() : Item.getItemFromBlock(this);
    }
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return super.getSilkTouchDrop(state);
	}

    @Override
	public int quantityDropped(Random random)
    {
        return (Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(),random,0)) ? 1 + random.nextInt(2) : 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0) {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    @Override
    public boolean canHarvestBlock(net.minecraft.world.IBlockAccess world, BlockPos pos, EntityPlayer player) {
        IBlockState state = world.getBlockState(pos);
        ItemStack stack = player.getHeldItemMainhand();
        return (stack.getItem().getHarvestLevel(stack, Objects.requireNonNull(this.getHarvestTool(state)), player, state) >= this.getHarvestLevel(state)) && (!stack.isEmpty()) && (net.minecraftforge.common.ForgeHooks.canHarvestBlock(this, player, world, pos));
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this) && this.item != null) {
            return RANDOM.nextInt(this.exp);
        }
        return 0;
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type != null && type.equals(this.getHarvestTool(state));
    }

    public OreBase setGeneratable() {
        BlockInit.ORES.add(this);
        return this;
    }
}
