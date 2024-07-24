package net.lonely.storm.worldgen.biome.surface;

import net.lonely.storm.block.ModBlocks;
import net.lonely.storm.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource ATHETITE_BLOCK = makeStateRule(ModBlocks.ATHETITE_BLOCK.get());
    //private static final SurfaceRules.RuleSource RAW_ALEXANDRITE = makeStateRule(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, ATHETITE_BLOCK)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ATHETITE_BLOCK)),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.TEST_BIOME_2),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, DIRT)),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, DIRT)),

                //GUIDE - THE FORSAKEN FURBY

                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}