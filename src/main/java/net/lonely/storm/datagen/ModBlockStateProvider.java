package net.lonely.storm.datagen;

import net.lonely.storm.StormMod;
import net.lonely.storm.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StormMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ATHETITE_BLOCK);
        //blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        //blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.END_STONE_ALEXANDRITE_ORE);
        //blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);

        //blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
