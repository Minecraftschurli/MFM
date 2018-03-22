package minecraftschurli.mfm.util.integrations.tinkers;

public class MaterialStats
{
    private final float drawspeed,range,bonusDamage,handleModifier,miningSpeed,attackDamage,arrowShaftModifier;
    private final int headDurability, miningLevel, handleDurability, extraDurability, bonusAmmo, shieldDurability, shieldBlocking;

    public MaterialStats(int headDurability, int miningLevel, int handleDurability, int extraDurability, int bonusAmmo,
                         float drawspeed, float range, float bonusDamage, float handleModifier, float miningSpeed,
                         float attackDamage, float arrowShaftModifier, int shieldDurability, int shieldBlocking)
    {
        this.attackDamage = attackDamage;
        this.bonusDamage = bonusDamage;
        this.drawspeed = drawspeed;
        this.extraDurability = extraDurability;
        this.handleDurability = handleDurability;
        this.handleModifier = handleModifier;
        this.headDurability = headDurability;
        this.miningLevel = miningLevel;
        this.miningSpeed = miningSpeed;
        this.range = range;
        this.arrowShaftModifier = arrowShaftModifier;
        this.bonusAmmo = bonusAmmo;
        this.shieldDurability = shieldDurability;
        this.shieldBlocking = shieldBlocking;
    }

    public int getHeadDurability() {
        return headDurability;
    }

    public float getMiningSpeed() {
        return miningSpeed;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public float getHandleModifier() {
        return handleModifier;
    }

    public int getHandleDurability() {
        return handleDurability;
    }

    public int getExtraDurability() {
        return extraDurability;
    }

    public float getDrawspeed() {
        return drawspeed;
    }

    public float getRange() {
        return range;
    }

    public float getBonusDamage() {
        return bonusDamage;
    }

    public float getArrowShaftModifier() {
        return arrowShaftModifier;
    }

    public int getBonusAmmo() {
        return bonusAmmo;
    }

    public int getShieldDurability() {
        return shieldDurability;
    }

    public int getShieldBlocking() {
        return shieldBlocking;
    }
}
