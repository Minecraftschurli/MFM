package minecraftschurli.mfm.objects.armor.op;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class HelmetOp extends ArmorBase implements SetOp {

	public HelmetOp(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super("helmet_op", materialIn, renderIndexIn, equipmentSlotIn);
	}

}
