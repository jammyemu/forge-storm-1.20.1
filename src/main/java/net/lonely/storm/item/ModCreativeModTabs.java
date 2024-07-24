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

                        pOutput.accept(ModBlocks.ATHETITE_BLOCK.get());

                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
