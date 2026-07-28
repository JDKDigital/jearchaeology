package cy.jdkdigital.jearchaeology.compat;

import com.mojang.datafixers.util.Pair;
import cy.jdkdigital.jearchaeology.JEArchaeology;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.Map;

public class BetterAcheologyCompat
{
    public static Map<ResourceKey<LootTable>, Pair<String, Ingredient>> getTables() {
        Map<ResourceKey<LootTable>, Pair<String, Ingredient>> tables = new HashMap<>();
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/mesa_red_sand", "archeologist_camp_redsand", "betterarcheology:suspicious_red_sand");
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/taiga_dirt", "archeologist_camp_grassy", "betterarcheology:suspicious_dirt");
        tables.put(CompatLookup.lootTable("betterarcheology:archeology/plains_gravel"), Pair.of("plains_gravel", Ingredient.of(Blocks.SUSPICIOUS_GRAVEL)));
        tables.put(CompatLookup.lootTable("betterarcheology:archeology/desert_sand"), Pair.of("betterarcheology_desert", Ingredient.of(Blocks.SUSPICIOUS_SAND)));
        tables.put(CompatLookup.lootTable("betterarcheology:archeology/desert_sand"), Pair.of("archeologist_camp_sand", Ingredient.of(Blocks.SUSPICIOUS_SAND)));
        tables.put(CompatLookup.lootTable("betterarcheology:archeology/sussand_underwater"), Pair.of("underwater", Ingredient.of(Blocks.SUSPICIOUS_SAND)));
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/fossiliferous_dirt_chicken", "fossil_chicken", "betterarcheology:fossiliferous_dirt");
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/fossiliferous_dirt_creeper", "fossil_creeper", "betterarcheology:fossiliferous_dirt");
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/fossiliferous_dirt_jungle", "fossil_jungle", "betterarcheology:fossiliferous_dirt");
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/fossiliferous_dirt_sheep", "fossil_sheep", "betterarcheology:fossiliferous_dirt");
        CompatLookup.putBlockTable(tables, "betterarcheology:archeology/fossiliferous_dirt_villager", "fossil_villager", "betterarcheology:fossiliferous_dirt");
        return tables;
    }

    public static void addRecipeCatalyst(IRecipeCatalystRegistration registration, IRecipeType<?> recipeType) {
        JEArchaeology.LOGGER.info("adding brushes");
        for (String brush : new String[]{"betterarcheology:iron_brush", "betterarcheology:diamond_brush", "betterarcheology:netherite_brush"}) {
            CompatLookup.item(brush).ifPresent(item -> registration.addCraftingStation(recipeType, item));
        }
    }
}
