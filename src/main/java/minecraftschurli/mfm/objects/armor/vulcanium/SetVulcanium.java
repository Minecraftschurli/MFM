package minecraftschurli.mfm.objects.armor.vulcanium;

import minecraftschurli.mfm.util.interfaces.IArmorSet;
import net.minecraft.item.ItemStack;

public interface SetVulcanium extends IArmorSet {
    @Override
    default boolean isCompleteSetEquipped(Iterable<ItemStack> armor) {
        for (ItemStack armorPiece : armor) {
            if (!(armorPiece.getItem() instanceof SetVulcanium)) {
                return false;
            }
        }
        return true;
    }
}
