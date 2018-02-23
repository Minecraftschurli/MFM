package minecraftschurli.mfm.objects.blocks.machines.staniumsmelter;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class StaniumSmelterRecipes 
{
	private static final StaniumSmelterRecipes INSTANCE = new StaniumSmelterRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static StaniumSmelterRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private StaniumSmelterRecipes() 
	{
		registerDefaultRecipes();
	}

	
	public void addStaniumSmelterRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getStaniumSmelterResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	private void registerDefaultRecipes()
	{
		addStaniumSmelterRecipe(new ItemStack(Blocks.GOLD_BLOCK), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(ItemInit.INGOT_OP_BASE, 3), 0.0F);
		addStaniumSmelterRecipe(new ItemStack(ItemInit.INGOT_OP_BASE), new ItemStack(ItemInit.GEM_SEADIAMOND), new ItemStack(ItemInit.INGOT_OP), 0.0F);
	}
	
	public ItemStack getStaniumSmelterResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getStaniumSmelterExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
