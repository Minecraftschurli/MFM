package minecraftschurli.mfm.util.interfaces;

import net.minecraft.item.ItemStack;

public interface IArmorSet {
    boolean isCompleteSetEquipped(Iterable<ItemStack> armor);
}
