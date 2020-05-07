package com.neonphoenix.mcrf.blocks;

import com.neonphoenix.mcrf.objectholders.ColoredWoodenSlabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.stream.Stream;

public class ColoredWoodenSlab extends Block
{
    public ColoredWoodenSlab(Material mat, DyeColor dyeColor)
    {
        super(Properties.create(mat, dyeColor).hardnessAndResistance(1.8F));
    }

    public static Stream<Block> allBlocks()
    {
        return Stream.of(
                ColoredWoodenSlabs.WHITE,
                ColoredWoodenSlabs.ORANGE,
                ColoredWoodenSlabs.MAGENTA,
                ColoredWoodenSlabs.LIGHT_BLUE,
                ColoredWoodenSlabs.YELLOW,
                ColoredWoodenSlabs.LIME,
                ColoredWoodenSlabs.PINK,
                ColoredWoodenSlabs.GRAY,
                ColoredWoodenSlabs.LIGHT_GRAY,
                ColoredWoodenSlabs.CYAN,
                ColoredWoodenSlabs.PURPLE,
                ColoredWoodenSlabs.BLUE,
                ColoredWoodenSlabs.BROWN,
                ColoredWoodenSlabs.GREEN,
                ColoredWoodenSlabs.RED,
                ColoredWoodenSlabs.BLACK
        );
    }
}
