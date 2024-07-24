package net.lonely.storm.datagen;

import net.lonely.storm.StormMod;
import net.lonely.storm.block.ModBlocks;
import net.lonely.storm.block.custom.RootedGingerCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        makeCrop(((RootedGingerCropBlock) ModBlocks.ROOTED_GINGER_CROP.get()), "rooted_ginger_stage", "rooted_ginger_stage");

    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RootedGingerCropBlock) block).getAgeProperty()),
                new ResourceLocation(StormMod.MOD_ID, "block/" + textureName + state.getValue(((RootedGingerCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
