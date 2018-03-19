package minecraftschurli.mfm.objects.armor.horsearmor;

import minecraftschurli.mfm.objects.items.ItemBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HorseArmorBase extends ItemBase {
    private final HorseArmorType type;

    public HorseArmorBase(String name, HorseArmorType type) {
        super(name);
        this.type = type;
    }

    @Override
    public void onHorseArmorTick(World world, EntityLiving horse, ItemStack armor) {
        super.onHorseArmorTick(world, horse, armor);
    }

    @Override
    public HorseArmorType getHorseArmorType(ItemStack stack) {
        return type;
    }
}
