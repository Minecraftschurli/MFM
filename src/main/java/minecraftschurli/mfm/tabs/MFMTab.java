package minecraftschurli.mfm.tabs;

import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MFMTab extends CreativeTabs {

	public MFMTab(String label) {
		super("mfmtab");
//		this.setBackgroundImageName("mfm.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.ITEM_CORE);
	}

}
