package cy.jdkdigital.jearchaeology.recipe;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Pair;
import cy.jdkdigital.jearchaeology.JEArchaeology;
import cy.jdkdigital.jearchaeology.compat.CompatHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.util.FakePlayerFactory;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Helper
{
    private static final UUID BRUSHER_PLAYER_UUID = UUID.nameUUIDFromBytes("jea_brusher_player".getBytes(StandardCharsets.UTF_8));
    private static List<RecipeHolder<?>> cachedBrushingRecipes = new ArrayList<>();
    private static List<RecipeHolder<?>> cachedSniffingRecipes = new ArrayList<>();

    private static ResourceKey<Recipe<?>> recipeKey(String name) {
        return ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(JEArchaeology.MODID, name));
    }

    public static List<RecipeHolder<?>> getAllBrushingRecipes(ServerLevel level) {
        if (level != null && cachedBrushingRecipes.isEmpty()) {
            List<RecipeHolder<?>> recipeList = new ArrayList<>();

            Map<ResourceKey<LootTable>, Pair<String, Ingredient>> tables = CompatHandler.getTables();

            Player fakePlayer = FakePlayerFactory.get(level, new GameProfile(BRUSHER_PLAYER_UUID, "jea_brusher_player"));
            LootParams lootparams = (new LootParams.Builder(level)).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(new BlockPos(0, 0, 0))).withLuck(1.0f).withParameter(LootContextParams.THIS_ENTITY, fakePlayer).create(LootContextParamSets.CHEST);
            tables.forEach((lootTableKey, pair) -> {
                Map<Item, ItemStack> items = new HashMap<>();
                var table = level.getServer().reloadableRegistries().getLootTable(lootTableKey);
                if (!table.equals(LootTable.EMPTY)) {
                    AtomicInteger countSinceLastHit = new AtomicInteger();
                    for (int i = 0; i < 600; i++) {
                        if (countSinceLastHit.get() > 50) {
                            break;
                        }
                        table.getRandomItems(lootparams).forEach(itemStack -> {
                            if (!items.containsKey(itemStack.getItem())) {
                                countSinceLastHit.set(0);
                                items.put(itemStack.getItem(), itemStack);
                            } else {
                                countSinceLastHit.getAndIncrement();
                            }
                        });
                    }
                }
                String locationName = pair.getFirst();
                List<ItemStack> loot = List.copyOf(items.values());
                if (loot.size() > 64) {
                    recipeList.add(new RecipeHolder<>(recipeKey(locationName + "_4"), new BrushingRecipe(loot.stream().limit(42).skip(21).toList(), 1f, pair.getSecond())));
                    recipeList.add(new RecipeHolder<>(recipeKey(locationName + "_3"), new BrushingRecipe(loot.stream().skip(42).toList(), 1f, pair.getSecond())));
                }
                if (loot.size() > 32) {
                    recipeList.add(new RecipeHolder<>(recipeKey(locationName + "_2"), new BrushingRecipe(loot.stream().limit(21).toList(), 1f, pair.getSecond())));
                    recipeList.add(new RecipeHolder<>(recipeKey(locationName + "_1"), new BrushingRecipe(loot.stream().skip(21).toList(), 1f, pair.getSecond())));
                } else {
                    recipeList.add(new RecipeHolder<>(recipeKey(locationName), new BrushingRecipe(loot, 1f, pair.getSecond())));
                }
            });
            cachedBrushingRecipes = recipeList;
        }
        return cachedBrushingRecipes;
    }

    public static List<RecipeHolder<?>> getAllSniffingRecipes(ServerLevel level) {
        if (level != null && cachedSniffingRecipes.isEmpty()) {
            var sniffer = EntityType.SNIFFER.create(level, EntitySpawnReason.NATURAL);
            LootParams lootparams = (new LootParams.Builder(level)).withParameter(LootContextParams.ORIGIN, new Vec3(0, 0, 0)).withParameter(LootContextParams.THIS_ENTITY, sniffer).create(LootContextParamSets.GIFT);
            Map<Item, ItemStack> items = new HashMap<>();
            var table = level.getServer().reloadableRegistries().getLootTable(BuiltInLootTables.SNIFFER_DIGGING);
            for (int i = 0; i < 400; i++) {
                table.getRandomItems(lootparams).forEach(itemStack -> {
                    if (!items.containsKey(itemStack.getItem())) {
                        items.put(itemStack.getItem(), itemStack);
                    }
                });
            }
            cachedSniffingRecipes = List.of(new RecipeHolder<>(recipeKey("sniffing"), new SniffRecipe(List.copyOf(items.values()), 1f)));
        }
        return cachedSniffingRecipes;
    }
}
