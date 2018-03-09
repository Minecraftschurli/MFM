package minecraftschurli.mfm.objects.armor.kanadium;

import minecraftschurli.mfm.util.interfaces.IArmorSet;
import net.minecraft.item.ItemStack;

public interface SetKanadium extends IArmorSet {
    @Override
    default boolean isCompleteSetEquipped(Iterable<ItemStack> armor) {
        for (ItemStack armorPiece : armor) {
            if (!(armorPiece.getItem() instanceof SetKanadium)) {
                return false;
            }
        }
        return true;
    }
}
