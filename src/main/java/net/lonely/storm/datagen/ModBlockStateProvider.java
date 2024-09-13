package net.lonely.storm.datagen;

import net.lonely.storm.StormMod;
import net.lonely.storm.block.ModBlocks;
import net.lonely.storm.block.custom.RootedGingerCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        logBlock(((RotatedPillarBlock) ModBlocks.GRIMWOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.GRIMWOOD_WOOD.get()), blockTexture(ModBlocks.GRIMWOOD_LOG.get()), blockTexture(ModBlocks.GRIMWOOD_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_GRIMWOOD_LOG.get(), new ResourceLocation(StormMod.MOD_ID, "block/stripped_grimwood_log"),
                new ResourceLocation(StormMod.MOD_ID, "block/stripped_grimwood_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_GRIMWOOD_WOOD.get(), new ResourceLocation(StormMod.MOD_ID, "block/stripped_grimwood_log"),
                new ResourceLocation(StormMod.MOD_ID, "block/stripped_grimwood_log"));

        blockItem(ModBlocks.GRIMWOOD_LOG);
        blockItem(ModBlocks.GRIMWOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_GRIMWOOD_LOG);
        blockItem(ModBlocks.STRIPPED_GRIMWOOD_WOOD);

        blockWithItem(ModBlocks.GRIMWOOD_PLANKS);

        leavesBlock(ModBlocks.GRIMWOOD_LEAVES);
        saplingBlock(ModBlocks.GRIMWOOD_SAPLING);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("storm:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("storm:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
