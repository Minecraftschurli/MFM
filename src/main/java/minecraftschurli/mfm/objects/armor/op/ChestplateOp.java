package minecraftschurli.mfm.objects.armor.op;

import minecraftschurli.mfm.objects.armor.ArmorBase;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ChestplateOp extends ArmorBase implements SetOp {


    public ChestplateOp(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super("chestplate_op", materialIn, renderIndexIn, equipmentSlotIn);
    }
    
		
}
