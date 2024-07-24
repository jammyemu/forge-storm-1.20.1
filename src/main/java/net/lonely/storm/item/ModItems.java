package net.lonely.storm.item;

import net.lonely.storm.StormMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StormMod.MOD_ID);

    public static final RegistryObject<Item> ATHETITE_CLUMP = ITEMS.register("athetite_clump", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROOTED_GINGER = ITEMS.register("rooted_ginger", () -> new Item(new Item.Properties().food(ModFoods.ROOTED_GINGER)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
