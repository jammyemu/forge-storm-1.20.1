package net.lonely.storm.worldgen.biome;


import net.lonely.storm.StormMod;
import net.lonely.storm.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.RegionType;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(StormMod.MOD_ID, "overworld"), 5));
    }
}
