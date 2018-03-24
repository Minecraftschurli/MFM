package minecraftschurli.mfm.util.integrations.tinkers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.awt.*;

public class TraitVulcanic extends AbstractTrait {
    protected float bonus = 0.70f;

    public TraitVulcanic() {
        super("vulcanic", new Color(222, 155, 0, 255).getRGB());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if (target.isBurning()) {
            newDamage += damage * this.bonus;
        }

        return newDamage;
    }

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent livingHurtEvent) {
        if (livingHurtEvent.getEntityLiving() instanceof EntityPlayer && !livingHurtEvent.getEntityLiving().getEntityWorld().isRemote) {
            EntityPlayer entityPlayer = (EntityPlayer) livingHurtEvent.getEntityLiving();
            Entity attacker = livingHurtEvent.getSource().getTrueSource();

            if (attacker instanceof EntityLiving && !attacker.isDead) {
                ItemStack tool = ToolHelper.playerIsHoldingItemWith(entityPlayer, this::isToolWithTrait);
                if (!tool.isEmpty() && !ToolHelper.isBroken(tool)) {
                    attacker.setFire(3);
                }
            }
        }
    }

    @Override
    public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
        // block fire damage
        if (event.getSource().isFireDamage()) {
            event.setCanceled(true);
            ToolHelper.damageTool(tool, 3, player);
        }
    }
}
