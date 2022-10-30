package net.foowrot.copperrevolution.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.foowrot.copperrevolution.CopperRevolution;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModItemGroup
{
    public static final ItemGroup COPPERREVOLUTION = FabricItemGroupBuilder.build(new Identifier
            (CopperRevolution.MOD_ID, "copperrevolution"), () -> new ItemStack(Items.COPPER_INGOT));
}
