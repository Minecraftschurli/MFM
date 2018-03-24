package minecraftschurli.mfm.util.integrations.tinkers.traits;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;

import java.awt.*;

public class TraitWorkable extends AbstractTraitLeveled {

    public TraitWorkable(int levels) {
        super("workable", String.valueOf(levels), new Color(214, 216, 219).getRGB(), 4, 1);
    }

    @Override
    public void applyModifierEffect(NBTTagCompound rootCompound) {
        // yaaay, modifiers
        NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
        int modifiers = toolTag.getInteger(Tags.FREE_MODIFIERS) + levels;
        toolTag.setInteger(Tags.FREE_MODIFIERS, Math.max(0, modifiers));
        TagUtil.setToolTag(rootCompound, toolTag);
    }
}