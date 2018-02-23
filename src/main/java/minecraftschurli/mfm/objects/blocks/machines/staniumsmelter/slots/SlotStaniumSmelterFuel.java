package minecraftschurli.mfm.objects.blocks.machines.staniumsmelter.slots;

import minecraftschurli.mfm.objects.blocks.machines.alloyer.TileEntityAlloyingFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotStaniumSmelterFuel extends Slot {

	public SlotStaniumSmelterFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityAlloyingFurnace.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}

}
