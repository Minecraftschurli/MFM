package minecraftschurli.mfm.objects.armor.op;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class LeggingsOp extends ArmorBase implements SetOp {

	public LeggingsOp(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super("leggings_op", materialIn, renderIndexIn, equipmentSlotIn);
	}

}
