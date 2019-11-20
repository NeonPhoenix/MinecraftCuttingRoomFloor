package com.neonphoenix.mcrf.util;

import com.neonphoenix.mcrf.lists.ModdedBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MCRFItemGroup extends ItemGroup
{
    public MCRFItemGroup()
    {
        super("mcrf");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Item.BLOCK_TO_ITEM.get(ModdedBlocks.NETHER_GOLD_ORE));
    }
}
