package minecraftschurli.mfm.util.integrations.tinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

import java.awt.*;

public class TraitGodlike extends AbstractTrait {
    public static TraitGodlike INSTANCE = new TraitGodlike();

    public TraitGodlike() {
        super("godlike", new Color(222, 220, 14).getRGB());
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);

        ToolNBT stats = TagUtil.getToolStats(rootCompound);
        stats.durability = 999999;
        stats.attack = 999999f;
        stats.speed = 999999f;
        stats.modifiers = 0;
        TagUtil.setToolTag(rootCompound, stats.get());
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        // doesn't take damage at all
        return 0;
    }
}
