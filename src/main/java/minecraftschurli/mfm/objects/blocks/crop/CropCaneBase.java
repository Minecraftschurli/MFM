package minecraftschurli.mfm.objects.blocks.crop;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.BlockReed;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;

public class CropCaneBase extends BlockReed implements IHasModel {
    public CropCaneBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
        disableStats();

        BlockInit.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
