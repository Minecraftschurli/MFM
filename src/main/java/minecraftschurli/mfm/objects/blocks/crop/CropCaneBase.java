package minecraftschurli.mfm.objects.blocks.crop;

import minecraftschurli.mfm.Main;
import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.BlockReed;
import net.minecraft.item.ItemBlock;

public class CropCaneBase extends BlockReed implements IHasModel {
    public CropCaneBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.CREATIVETAB);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {

    }
}
