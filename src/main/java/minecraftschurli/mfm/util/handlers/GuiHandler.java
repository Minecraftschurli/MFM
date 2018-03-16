package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.objects.blocks.machines.alloyer.ContainerAlloyingFurnace;
import minecraftschurli.mfm.objects.blocks.machines.alloyer.GuiAlloyingFurnace;
import minecraftschurli.mfm.objects.blocks.machines.alloyer.TileEntityAlloyingFurnace;
import minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.ContainerStaniumSmelter;
import minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.GuiStaniumSmelter;
import minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.TileEntityStaniumSmelter;
import minecraftschurli.mfm.util.Reference;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if(ID == Reference.GUI_ALLOYING_FURNACE)return new ContainerAlloyingFurnace(player.inventory, (TileEntityAlloyingFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_STANIUM_SMELTER)return new ContainerStaniumSmelter(player.inventory, (TileEntityStaniumSmelter)world.getTileEntity(new BlockPos(x,y,z)));
		if (ID == Reference.GUI_GODIUM_REFINER)
			return new ContainerFurnace(player.inventory, (TileEntityFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_ALLOYING_FURNACE)return new GuiAlloyingFurnace(player.inventory, (TileEntityAlloyingFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_STANIUM_SMELTER)return new GuiStaniumSmelter(player.inventory, (TileEntityStaniumSmelter)world.getTileEntity(new BlockPos(x,y,z)));
		if (ID == Reference.GUI_GODIUM_REFINER)
			return new GuiFurnace(player.inventory, (TileEntityFurnace) world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

}
