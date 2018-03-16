package minecraftschurli.mfm.proxy;

import minecraftschurli.mfm.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class CommonProxy
{

	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation((new ResourceLocation(Reference.MOD_ID, filename)), id));
	}

}
