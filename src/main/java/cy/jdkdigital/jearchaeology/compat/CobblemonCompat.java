package cy.jdkdigital.jearchaeology.compat;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashMap;
import java.util.Map;

public class CobblemonCompat
{
    static Ingredient SUS_BLOCKS = Ingredient.of(Blocks.SUSPICIOUS_SAND, Blocks.SUSPICIOUS_GRAVEL);
    static Ingredient SUS_GRAVEL = Ingredient.of(Blocks.SUSPICIOUS_GRAVEL);
    static Ingredient SUS_SAND = Ingredient.of(Blocks.SUSPICIOUS_SAND);
    public static Map<ResourceKey<LootTable>, Pair<String, Ingredient>> getTables() {
        return new HashMap<>() {{
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_birch_tree")), Pair.of("prehistoric_birch_tree_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_dripstone_oasis")), Pair.of("prehistoric_dripstone_oasis_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_enhydro_agate")), Pair.of("prehistoric_enhydro_agate_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_eroded_pillar")), Pair.of("prehistoric_eroded_pillar_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_frozen_pond")), Pair.of("prehistoric_frozen_pond_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_frozen_spike")), Pair.of("prehistoric_frozen_spike_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_hydrothermal_vents")), Pair.of("prehistoric_hydrothermal_vents_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_lush_den")), Pair.of("prehistoric_lush_den_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_mossy_pond")), Pair.of("prehistoric_mossy_pond_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_mud_pit")), Pair.of("prehistoric_mud_pit_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_oak_tree")), Pair.of("prehistoric_oak_tree_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_powdered_deposit")), Pair.of("prehistoric_powdered_deposit_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_preserved_skeleton")), Pair.of("prehistoric_preserved_skeleton_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_rooted_pit")), Pair.of("prehistoric_rooted_pit_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_sandy_den")), Pair.of("prehistoric_sandy_den_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_spruce_tree")), Pair.of("prehistoric_spruce_tree_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_submerged_impact")), Pair.of("prehistoric_submerged_impact_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_submerged_spike")), Pair.of("prehistoric_submerged_spike_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_sunscorched_den")), Pair.of("prehistoric_sunscorched_den_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_sunscorched_remains")), Pair.of("prehistoric_sunscorched_remains_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_suspicious_mound")), Pair.of("prehistoric_suspicious_mound_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_underwater_fissure")), Pair.of("prehistoric_underwater_fissure_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/common/prehistoric_vibrant_hydrothermal_vents")), Pair.of("prehistoric_vibrant_hydrothermal_vents_common", SUS_BLOCKS));

            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_birch_tree")), Pair.of("prehistoric_birch_tree_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_dripstone_oasis")), Pair.of("prehistoric_dripstone_oasis_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_enhydro_agate")), Pair.of("prehistoric_enhydro_agate_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_eroded_pillar")), Pair.of("prehistoric_eroded_pillar_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_frozen_pond")), Pair.of("prehistoric_frozen_pond_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_frozen_spike")), Pair.of("prehistoric_frozen_spike_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_hydrothermal_vents")), Pair.of("prehistoric_hydrothermal_vents_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_lush_den")), Pair.of("prehistoric_lush_den_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_mossy_pond")), Pair.of("prehistoric_mossy_pond_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_mud_pit")), Pair.of("prehistoric_mud_pit_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_oak_tree")), Pair.of("prehistoric_oak_tree_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_powdered_deposit")), Pair.of("prehistoric_powdered_deposit_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_preserved_skeleton")), Pair.of("prehistoric_preserved_skeleton_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_rooted_pit")), Pair.of("prehistoric_rooted_pit_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_sandy_den")), Pair.of("prehistoric_sandy_den_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_spruce_tree")), Pair.of("prehistoric_spruce_tree_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_submerged_impact")), Pair.of("prehistoric_submerged_impact_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_submerged_spike")), Pair.of("prehistoric_submerged_spike_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_sunscorched_den")), Pair.of("prehistoric_sunscorched_den_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_sunscorched_remains")), Pair.of("prehistoric_sunscorched_remains_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_suspicious_mound")), Pair.of("prehistoric_suspicious_mound_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_underwater_fissure")), Pair.of("prehistoric_underwater_fissure_uncommon", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/uncommon/prehistoric_vibrant_hydrothermal_vents")), Pair.of("prehistoric_vibrant_hydrothermal_vents_uncommon", SUS_BLOCKS));

            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/plume_fossil")), Pair.of("prehistoric_birch_tree_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/claw_fossil")), Pair.of("prehistoric_dripstone_oasis_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/fish_fossil")), Pair.of("prehistoric_enhydro_agate_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/jaw_fossil")), Pair.of("prehistoric_eroded_pillar_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/sail_fossil")), Pair.of("prehistoric_frozen_pond_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/dino_fossil")), Pair.of("prehistoric_frozen_spike_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/dome_fossil")), Pair.of("prehistoric_hydrothermal_vents_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/jaw_fossil")), Pair.of("prehistoric_lush_den_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/claw_fossil")), Pair.of("prehistoric_mossy_pond_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/skull_fossil")), Pair.of("prehistoric_mud_pit_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/old_amber_fossil")), Pair.of("prehistoric_oak_tree_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/sail_fossil")), Pair.of("prehistoric_powdered_deposit_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/galar_bottom_fossils")), Pair.of("prehistoric_preserved_skeleton_rare_bottom", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/galar_top_fossils")), Pair.of("prehistoric_preserved_skeleton_rare_top", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/root_fossil")), Pair.of("prehistoric_rooted_pit_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/helix_fossil")), Pair.of("prehistoric_sandy_den_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/old_amber_fossil")), Pair.of("prehistoric_spruce_tree_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/fish_fossil")), Pair.of("prehistoric_submerged_impact_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/cover_fossil")), Pair.of("prehistoric_submerged_spike_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/armor_fossil")), Pair.of("prehistoric_sunscorched_den_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/drake_fossil")), Pair.of("prehistoric_sunscorched_remains_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/bird_fossil")), Pair.of("prehistoric_suspicious_mound_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/cover_fossil")), Pair.of("prehistoric_underwater_fissure_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:fossils/rare/cover_fossil")), Pair.of("prehistoric_vibrant_hydrothermal_vents_rare", SUS_SAND));


            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/crumbling_arch_ruins")), Pair.of("crumbling_arch_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/decaying_crypt_ruins")), Pair.of("decaying_crypt_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/deserted_gimmi_tower")), Pair.of("deserted_gimmi_tower_common", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/deserted_house_ruins")), Pair.of("deserted_house_ruins_common", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/deserted_tower_ruins")), Pair.of("deserted_tower_ruins_common", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/deserted_town_center_ruins")), Pair.of("deserted_town_center_ruins_common", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/fallen_statue_ruins")), Pair.of("fallen_statue_ruins_common", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/luna_henge_ruins")), Pair.of("luna_henge_ruins_common", SUS_BLOCKS));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_frozen")), Pair.of("frozen_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/hidden_bunker_ruins")), Pair.of("hidden_bunker_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_lush")), Pair.of("honey_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/luna_henge_ruins")), Pair.of("luna_henge_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_lush")), Pair.of("lush_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/rooted_arch_ruins")), Pair.of("rooted_arch_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_rooted")), Pair.of("rooted_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/sol_henge_ruins")), Pair.of("sol_henge_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/stonjourner_henge_ruins")), Pair.of("stonjourner_henge_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_sunscorched")), Pair.of("sunscorched_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/gimmi_tower_temperate")), Pair.of("temperate_gimmi_tower_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/toppled_pillars_ruins")), Pair.of("toppled_pillars_ruins_common", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/common/unstable_cave_ruins")), Pair.of("unstable_cave_ruins_common", SUS_SAND));

            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/crumbling_arch_ruins")), Pair.of("crumbling_arch_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/decaying_crypt_ruins")), Pair.of("decaying_crypt_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/deserted_gimmi_tower")), Pair.of("deserted_gimmi_tower_uncommon", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/deserted_house_ruins")), Pair.of("deserted_house_ruins_uncommon", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/deserted_tower_ruins")), Pair.of("deserted_tower_ruins_uncommon", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/fallen_statue_ruins")), Pair.of("fallen_statue_ruins_uncommon", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_frozen")), Pair.of("frozen_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/hidden_bunker_ruins")), Pair.of("hidden_bunker_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/luna_henge_ruins")), Pair.of("luna_henge_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_lush")), Pair.of("honey_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_lush")), Pair.of("lush_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/mossy_oubliette_ruins")), Pair.of("mossy_oubliette_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/rooted_arch_ruins")), Pair.of("rooted_arch_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_rooted")), Pair.of("rooted_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/sol_henge_ruins")), Pair.of("sol_henge_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/stonjourner_henge_ruins")), Pair.of("stonjourner_henge_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_sunscorched")), Pair.of("sunscorched_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/gimmi_tower_temperate")), Pair.of("temperate_gimmi_tower_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/toppled_pillars_ruins")), Pair.of("toppled_pillars_ruins_uncommon", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/uncommon/unstable_cave_ruins")), Pair.of("unstable_cave_ruins_uncommon", SUS_SAND));

            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/black_tumblestone")), Pair.of("crumbling_arch_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/sky_tumblestone")), Pair.of("deserted_gimmi_tower_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/tumblestone")), Pair.of("deserted_house_ruins_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/sky_tumblestone")), Pair.of("deserted_tower_ruins_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/sky_tumblestone")), Pair.of("fallen_statue_ruins_rare", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/automaton_armor_trim_smithing_template")), Pair.of("fallen_statue_ruins_rare_automaton", SUS_SAND));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/sky_tumblestone")), Pair.of("hidden_bunker_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/black_tumblestone")), Pair.of("luna_henge_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/black_tumblestone")), Pair.of("mossy_oubliette_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/tumblestone")), Pair.of("rooted_arch_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/sky_tumblestone")), Pair.of("sol_henge_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/tumblestone")), Pair.of("stonjourner_henge_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/tumblestone")), Pair.of("toppled_pillars_ruins_rare", SUS_GRAVEL));
            put(ResourceKey.create(Registries.LOOT_TABLE, Identifier.parse("cobblemon:ruins/rare/black_tumblestone")), Pair.of("unstable_cave_ruins_rare", SUS_SAND));
        }};
    }
}
