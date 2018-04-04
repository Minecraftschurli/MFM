package minecraftschurli.mfm.util.misc;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MaterialTripplet extends org.apache.commons.lang3.tuple.Triple<Block, Item, Item> {
    private Block B;
    private Item I;
    private Item N;

    public MaterialTripplet(Block block, Item item, Item nugget) {
        this.B = block;
        this.I = item;
        this.N = nugget;
    }

    public Block getBlock() {
        return B;
    }

    public Item getIngot() {
        return I;
    }

    public Item getNugget() {
        return N;
    }

    @Override
    public Block getLeft() {
        return B;
    }

    @Override
    public Item getMiddle() {
        return I;
    }

    @Override
    public Item getRight() {
        return N;
    }
}
