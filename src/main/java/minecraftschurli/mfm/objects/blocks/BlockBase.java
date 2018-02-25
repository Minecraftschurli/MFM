package minecraftschurli.mfm.objects.blocks;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

public class BlockBase extends Block implements IHasModel
{

    public final String oreDictName;

	public BlockBase(String name, Material material, String oreDict)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = "block"+oreDict;

        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

    public BlockBase(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.CREATIVETAB);
        this.oreDictName = null;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

	public BlockBase(String name, Material material, float hardness, float resistance, String toolClass, int level, String oreDict)
    {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(toolClass, level);
        this.oreDictName = "block"+oreDict;

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockBase(String name, Material material, float hardness, float resistance, String oreDict) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.CREATIVETAB);
		setHardness(hardness);
		setResistance(resistance);
        this.oreDictName = "block"+oreDict;

        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
