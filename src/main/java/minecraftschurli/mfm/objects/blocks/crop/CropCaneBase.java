package minecraftschurli.mfm.objects.blocks.crop;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.util.interfaces.IHasModel;
import net.minecraft.block.BlockReed;
import net.minecraft.block.SoundType;

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

    }
}
