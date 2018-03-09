package minecraftschurli.mfm.objects.armor.op;

import minecraftschurli.mfm.util.interfaces.IArmorSet;
import net.minecraft.item.ItemStack;

public interface SetOp extends IArmorSet {

	void registerModels();

    default boolean isCompleteSetEquipped(Iterable<ItemStack> armor) {
        for (ItemStack armorPiece : armor) {
            if (!(armorPiece.getItem() instanceof SetOp)) {
                return false;
            }
        }
        return true;
    }
	
}
