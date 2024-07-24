package net.lonely.storm.item;

import net.lonely.storm.StormMod;
import net.lonely.storm.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StormMod.MOD_ID);

    public static final RegistryObject<Item> ATHETITE_CLUMP = ITEMS.register("athetite_clump", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROOTED_GINGER = ITEMS.register("rooted_ginger", () -> new ItemNameBlockItem(ModBlocks.ROOTED_GINGER_CROP.get(), new Item.Properties().food(ModFoods.ROOTED_GINGER)));


    public static final RegistryObject<Item> ETHERIUM = ITEMS.register("etherium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLORIUM = ITEMS.register("florium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEOLIUM = ITEMS.register("geolium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ILLOITE = ITEMS.register("illoite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KROTEIS = ITEMS.register("kroteis", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORIBIUM = ITEMS.register("oribium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHOENITE = ITEMS.register("phoenite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RIDONEITE = ITEMS.register("ridoneite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STARMEAR = ITEMS.register("starmear", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRANGERS_DIAMOND = ITEMS.register("strangers_diamond", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THE_LOST = ITEMS.register("the_lost", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THORIUM = ITEMS.register("thorium", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
