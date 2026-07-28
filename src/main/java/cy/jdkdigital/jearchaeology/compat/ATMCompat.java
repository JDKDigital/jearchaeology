package cy.jdkdigital.jearchaeology.compat;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.Map;

public class ATMCompat
{
    public static Map<ResourceKey<LootTable>, Pair<String, Ingredient>> getTables() {
        Map<ResourceKey<LootTable>, Pair<String, Ingredient>> tables = new HashMap<>();
        CompatLookup.putBlockTable(tables, "allthemodium:arch", "ancient_city", "allthemodium:suspicious_clay");
        CompatLookup.putBlockTable(tables, "allthemodium:arch2", "bastion", "allthemodium:suspicious_soul_sand");
        return tables;
    }
}
