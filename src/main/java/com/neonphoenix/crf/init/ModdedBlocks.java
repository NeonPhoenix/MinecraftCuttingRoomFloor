package com.neonphoenix.crf.init;

import com.neonphoenix.crf.CuttingRoomFloor;
import com.neonphoenix.crf.blocks.ColoredWoodenPlank;
import com.neonphoenix.crf.blocks.ColoredWoodenSlab;
import com.neonphoenix.crf.blocks.ColoredWoodenStair;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Logger;

import java.util.stream.Stream;

import static com.neonphoenix.crf.lists.CRFBlocks.*;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModdedBlocks
{
    public static final ItemGroup creativeTab = CuttingRoomFloor.crfCreativeTab;
    public static final Logger log = CuttingRoomFloor.log;
    public static final String modid = CuttingRoomFloor.modid;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent<Block> event)
    {
        //Organic


        //Metal blocks
        STEEL_BLOCK = registerBlock(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.METAL)), location("steel_block"));

        //Building blocks
        RED_MOSSY_COBBLESTONE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_cobblestone"));
        RED_MOSSY_COBBLESTONE_SLAB = registerSlabBlock(new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_cobblestone_slab"));
        RED_MOSSY_COBBLESTONE_STAIRS = registerStairsBlock(new StairsBlock(() -> RED_MOSSY_COBBLESTONE.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_cobblestone_stairs"));
        RED_MOSSY_COBBLESTONE_WALL = registerWallBlock(new WallBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_cobblestone_wall"));

        RED_MOSSY_STONE_BRICK = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_stone_brick"));
        RED_MOSSY_STONE_BRICK_SLAB = registerSlabBlock(new SlabBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_stone_brick_slab"));
        RED_MOSSY_STONE_BRICK_STAIRS = registerStairsBlock(new StairsBlock(() -> RED_MOSSY_STONE_BRICK.getDefaultState(), Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_stone_brick_stairs"));
        RED_MOSSY_STONE_BRICK_WALL = registerWallBlock(new WallBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.STONE)), location("red_mossy_stone_brick_wall"));

        //Ore
        NETHER_GOLD_ORE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)), location("nether_gold_ore"));
        RED_MOSS_ORE = registerBlock(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)), location("red_moss_ore"));

        //Colored Blocks
        Stream.of(DyeColor.values()).forEach(dyeColor -> {
            ColoredWoodenPlank plank = new ColoredWoodenPlank(Material.WOOD, dyeColor);

            registerBlock(plank, location(dyeColor + "_wooden_planks"));
            registerSlabBlock(new ColoredWoodenSlab(Material.WOOD, dyeColor), location(dyeColor + "_wooden_slabs"));
            registerStairsBlock(new ColoredWoodenStair(Material.WOOD, dyeColor, () -> plank.getDefaultState()), location(dyeColor + "_wooden_stairs"));
        });

        log.info("Blocks registered.");
    }

    public static Block registerBlock(Block block, ResourceLocation name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(creativeTab));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);

        return block;
    }

    public static SlabBlock registerSlabBlock(SlabBlock block, ResourceLocation name)
    {
        BlockItem itemSlab = new BlockItem(block, new Item.Properties().group(creativeTab));
        block.setRegistryName(name);
        itemSlab.setRegistryName(name);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemSlab);

        return block;
    }

    public static StairsBlock registerStairsBlock(StairsBlock block, ResourceLocation name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(creativeTab));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);

        return block;
    }

    public static WallBlock registerWallBlock(WallBlock block, ResourceLocation name)
    {
        BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(creativeTab));
        block.setRegistryName(name);
        itemBlock.setRegistryName(name);

        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock);

        return block;
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(modid, name);
    }
}
