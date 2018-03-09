package minecraftschurli.mfm.objects.tools.sword;

import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.objects.armor.godium.ArmorGodium;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class SwordGodium extends SwordBase {

    public SwordGodium() {
        super("sword_godium", ItemInit.TOOL_GODIUM);
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase player) {
        if (player.world.isRemote) {
            return true;
        }
        if (victim instanceof EntityPlayer) {
            EntityPlayer pvp = (EntityPlayer) victim;
            if (ArmorGodium.isInfinite(pvp)) {
                //if(Belmont.isVampire(pvp))
                //    victim.attackEntityFrom(new DamageSourceInfinitySword(player).setFireDamage().setDamageBypassesArmor(), 4.0F);
                //else
                victim.attackEntityFrom(new DamageSourceGodiumSword(player).setDamageBypassesArmor(), 4.0F);
                return true;
            }
            if (pvp.getHeldItem(EnumHand.MAIN_HAND) != ItemStack.EMPTY && pvp.getHeldItem(EnumHand.MAIN_HAND).getItem() == ItemInit.SWORD_GODIUM && pvp.isHandActive()) {
                return true;
            }
        }

        victim.getCombatTracker().trackDamage(new DamageSourceGodiumSword(player), victim.getHealth(), victim.getHealth());
        victim.setHealth(0);
        //if(Belmont.isVampire(victim))
        //    victim.onDeath(new EntityDamageSource("infinity", player).setFireDamage());
        //else
        victim.onDeath(new EntityDamageSource("infinity", player));
        return true;
    }

    public class DamageSourceGodiumSword extends EntityDamageSource {

        DamageSourceGodiumSword(Entity source) {
            super("godlike", source);
        }

        @Override
        public ITextComponent getDeathMessage(EntityLivingBase entity) {
            ItemStack itemstack = damageSourceEntity instanceof EntityLivingBase ? ((EntityLivingBase) damageSourceEntity).getHeldItem(EnumHand.MAIN_HAND) : null;
            String s = "death.attack.infinity";
            int rando = entity.getEntityWorld().rand.nextInt(5);
            if (rando != 0) {
                s = s + "." + rando;
            }
            return new TextComponentTranslation(s, entity.getDisplayName(), itemstack.getDisplayName());
        }

        @Override
        public boolean isDifficultyScaled() {
            return false;
        }
    }
}
