package minecraftschurli.mfm.util.integrations.tinkers.traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.awt.*;
import java.util.Random;

public class TraitLiquidizing extends AbstractTrait {
    private final float bonus = 0.1f;

    public TraitLiquidizing() {
        super("liquidizing", new Color(222, 155, 0, 255).getRGB());
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        // 20% bonus speed on Metal ores
        for (ItemStack stack : OreDictionary.getOres("oreMetal")) {
            if (event.getState().getBlock().getItemDropped(event.getState(), new Random(), 0).equals(stack.getItem())) {
                event.setNewSpeed(event.getNewSpeed() * (1 + (bonus * 2)));
                return;
            }
        }
        // 5% bonus speed on all other blocks
        event.setNewSpeed(event.getNewSpeed() * (1 + (bonus / 2)));
    }
}
