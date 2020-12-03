package ladysnake.frostlegion.common.init;

import ladysnake.frostlegion.common.FrostLegion;
import ladysnake.frostlegion.common.block.SnowMineBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static Block SNOW_MINE;

    public static void init() {
        SNOW_MINE = registerBlock(new SnowMineBlock(FabricBlockSettings.of(Material.SNOW_LAYER).ticksRandomly().strength(0.1F).requiresTool().sounds(BlockSoundGroup.SNOW)), "snow_mine", ItemGroup.MISC);
    }

    private static Block registerBlock(Block block, String name, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, FrostLegion.MODID + ":" + name, block);

        if (itemGroup != null) {
            BlockItem item = new BlockItem(block, new Item.Settings().group(itemGroup));
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            Items.registerItem(item, name);
        }

        return block;
    }

}