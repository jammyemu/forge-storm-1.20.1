package net.lonely.storm.item;

import net.lonely.storm.StormMod;
import net.lonely.storm.block.ModBlocks;
import net.lonely.storm.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StormMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("storm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ATHETITE_CLUMP.get()))
                    .title(Component.translatable("creativetab.storm_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ATHETITE_CLUMP.get());
                        pOutput.accept(ModItems.ROOTED_GINGER.get());
                        pOutput.accept(ModItems.ETHERIUM.get());
                        pOutput.accept(ModItems.FLORIUM.get());
                        pOutput.accept(ModItems.GEOLIUM.get());
                        pOutput.accept(ModItems.ILLOITE.get());
                        pOutput.accept(ModItems.KROTEIS.get());
                        pOutput.accept(ModItems.ORIBIUM.get());
                        pOutput.accept(ModItems.PHOENITE.get());
                        pOutput.accept(ModItems.RIDONEITE.get());
                        pOutput.accept(ModItems.STARMEAR.get());
                        pOutput.accept(ModItems.STRANGERS_DIAMOND.get());
                        pOutput.accept(ModItems.THE_LOST.get());
                        pOutput.accept(ModItems.THORIUM.get());


                        pOutput.accept(ModBlocks.ATHETITE_BLOCK.get());

                        pOutput.accept(ModBlocks.GRIMWOOD_LOG.get());
                        pOutput.accept(ModBlocks.GRIMWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_GRIMWOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_GRIMWOOD_WOOD.get());
                        pOutput.accept(ModBlocks.GRIMWOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.GRIMWOOD_SAPLING.get());
                        pOutput.accept(ModBlocks.GRIMWOOD_LEAVES.get());

                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
