package cy.jdkdigital.jearchaeology.compat;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Map;
import java.util.Optional;

/**
 * Lookups for the blocks and items another mod contributes
 */
public final class CompatLookup
{
    public static ResourceKey<LootTable> lootTable(String identifier) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse(identifier));
    }

    public static Optional<Block> block(String identifier) {
        return BuiltInRegistries.BLOCK.get(Identifier.parse(identifier)).map(Holder::value);
    }

    public static Optional<Item> item(String identifier) {
        return BuiltInRegistries.ITEM.get(Identifier.parse(identifier)).map(Holder::value);
    }

    /**
     * Registers a loot table keyed off a block from another mod, skipping it when that block is absent.
     */
    public static void putBlockTable(Map<ResourceKey<LootTable>, Pair<String, Ingredient>> tables, String tableId, String name, String blockId) {
        block(blockId).ifPresent(block -> tables.put(lootTable(tableId), Pair.of(name, Ingredient.of(block))));
    }

    private CompatLookup() {}
}
