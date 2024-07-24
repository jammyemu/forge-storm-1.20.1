package net.lonely.storm.datagen;

import net.lonely.storm.StormMod;
import net.lonely.storm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StormMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ATHETITE_CLUMP);
        simpleItem(ModItems.ROOTED_GINGER);

        simpleItem(ModItems.ETHERIUM);
        simpleItem(ModItems.FLORIUM);
        simpleItem(ModItems.GEOLIUM);
        simpleItem(ModItems.ILLOITE);
        simpleItem(ModItems.KROTEIS);
        simpleItem(ModItems.ORIBIUM);
        simpleItem(ModItems.PHOENITE);
        simpleItem(ModItems.RIDONEITE);
        simpleItem(ModItems.STARMEAR);
        simpleItem(ModItems.STRANGERS_DIAMOND);
        simpleItem(ModItems.THE_LOST);
        simpleItem(ModItems.THORIUM);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StormMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}