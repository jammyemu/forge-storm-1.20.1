package net.lonely.storm.datagen.loot;

import net.lonely.storm.block.ModBlocks;
import net.lonely.storm.block.custom.RootedGingerCropBlock;
import net.lonely.storm.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ATHETITE_BLOCK.get());


        /*this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        */

        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ROOTED_GINGER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RootedGingerCropBlock.AGE, 3));
        this.add(ModBlocks.ROOTED_GINGER_CROP.get(), this.createCropDrops(ModBlocks.ROOTED_GINGER_CROP.get(),
                ModItems.ROOTED_GINGER.get(), ModItems.ROOTED_GINGER.get(), lootitemcondition$builder1));

        this.dropSelf(ModBlocks.GRIMWOOD_LOG.get());
        this.dropSelf(ModBlocks.GRIMWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_GRIMWOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_GRIMWOOD_WOOD.get());
        this.dropSelf(ModBlocks.GRIMWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.GRIMWOOD_SAPLING.get());

        this.add(ModBlocks.GRIMWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.GRIMWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}