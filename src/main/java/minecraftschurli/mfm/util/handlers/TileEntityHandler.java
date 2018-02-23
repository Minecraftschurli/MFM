package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.objects.blocks.machines.alloyer.TileEntityAlloyingFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityAlloyingFurnace.class, "alloying_furnace");
	}
}
