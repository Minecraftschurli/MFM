package minecraftschurli.mfm.objects.tools.sword;

import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class SwordVulcanium extends SwordBase
{
    public SwordVulcanium()
    {
        super("sword_vulcanium", ItemInit.VULCANIUM.TOOL_MATERIAL);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        entity.setFire(15);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
