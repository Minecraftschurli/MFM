package minecraftschurli.mfm.objects.armor.op;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class BootsOp extends ArmorBase implements SetOp {

	public BootsOp(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super("boots_op", materialIn, renderIndexIn, equipmentSlotIn);
	}

}
