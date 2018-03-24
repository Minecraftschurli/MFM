package minecraftschurli.mfm.util.integrations.tinkers;

import minecraftschurli.mfm.util.integrations.tinkers.traits.TraitLiquidizing;
import minecraftschurli.mfm.util.integrations.tinkers.traits.TraitVulcanic;
import minecraftschurli.mfm.util.integrations.tinkers.traits.TraitWorkable;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitsAndModifires {

    public static final AbstractTrait vulcanic = new TraitVulcanic();
    public static final AbstractTrait liquidizing = new TraitLiquidizing();
    public static final AbstractTrait workable1 = new TraitWorkable(1);
    public static final AbstractTrait workable2 = new TraitWorkable(2);

}
