package net.foowrot.copperrevolution.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.foowrot.copperrevolution.CopperRevolution;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{

    public static final Item DYNAMICS = registerItem("dynamics", new Item(new FabricItemSettings().group(ModItemGroup.COPPERREVOLUTION)));
    public static final Item STATICS = registerItem("statics", new Item(new FabricItemSettings().group(ModItemGroup.COPPERREVOLUTION)));
    public static final Item GLUE = registerItem("glue", new Item(new FabricItemSettings().group(ModItemGroup.COPPERREVOLUTION)));
    public static final Item BEARING = registerItem("bearing", new Item(new FabricItemSettings().group(ModItemGroup.COPPERREVOLUTION)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CopperRevolution.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        CopperRevolution.LOGGER.debug("Registering mod items for " + CopperRevolution.MOD_ID);
    }
}
