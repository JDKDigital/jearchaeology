package cy.jdkdigital.jearchaeology.compat;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.Map;

public class MegaShowdownCompat
{
    static Ingredient SUS_GRAVEL = Ingredient.of(Blocks.SUSPICIOUS_GRAVEL);
    static Ingredient SUS_SAND = Ingredient.of(Blocks.SUSPICIOUS_SAND);
    public static Map<ResourceKey<LootTable>, Pair<String, Ingredient>> getTables() {
        return new HashMap<>() {{
            put(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("mega_showdown:archaeological_site/archaeological_site_rare")), Pair.of("archaeological_site_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("mega_showdown:archaeological_site/archaeological_site")), Pair.of("archaeological_site", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("mega_showdown:wishing_weald/wishing_weald")), Pair.of("wishing_weald", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("mega_showdown:archaeology/observatory_sus")), Pair.of("observatory", SUS_GRAVEL));
        }};
    }
}
