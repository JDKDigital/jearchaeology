package cy.jdkdigital.jearchaeology;

import com.mojang.logging.LogUtils;
import cy.jdkdigital.jearchaeology.client.ClientRecipeCache;
import cy.jdkdigital.jearchaeology.network.ArchaeologyRecipesPayload;
import cy.jdkdigital.jearchaeology.recipe.BrushingRecipe;
import cy.jdkdigital.jearchaeology.recipe.Helper;
import cy.jdkdigital.jearchaeology.recipe.SniffRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(JEArchaeology.MODID)
public class JEArchaeology
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "jearchaeology";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SniffRecipe>> SNIFF = RECIPE_SERIALIZERS.register("sniff", () -> SniffRecipe.SERIALIZER);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BrushingRecipe>> BRUSH = RECIPE_SERIALIZERS.register("brush", () -> BrushingRecipe.SERIALIZER);
    public static DeferredHolder<RecipeType<?>, RecipeType<SniffRecipe>> SNIFF_TYPE = RECIPE_TYPES.register("sniff", () -> new RecipeType<>() {});
    public static DeferredHolder<RecipeType<?>, RecipeType<BrushingRecipe>> BRUSH_TYPE = RECIPE_TYPES.register("brush", () -> new RecipeType<>() {});

    public JEArchaeology(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
        RECIPE_TYPES.register(modEventBus);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @EventBusSubscriber(modid = JEArchaeology.MODID)
    class Events
    {
        @SubscribeEvent
        public static void registerPayloads(RegisterPayloadHandlersEvent event) {
            event.registrar("1").playToClient(
                    ArchaeologyRecipesPayload.TYPE,
                    ArchaeologyRecipesPayload.STREAM_CODEC,
                    (payload, context) -> ClientRecipeCache.accept(payload)
            );
        }

        @SubscribeEvent
        public static void onDataSync(OnDatapackSyncEvent event) {
            ServerLevel level = event.getPlayerList().getServer().getLevel(Level.OVERWORLD);
            if (level == null) {
                return;
            }

            long startTime = System.nanoTime();
            List<RecipeHolder<?>> brushing = Helper.getAllBrushingRecipes(level);
            List<RecipeHolder<?>> sniffing = Helper.getAllSniffingRecipes(level);
            List<RecipeHolder<?>> recipes = new ArrayList<>(brushing);
            recipes.addAll(sniffing);
            LOGGER.debug("Collecting {} brushing and {} sniffing recipes took {}ms", brushing.size(), sniffing.size(), (System.nanoTime() - startTime) / 1000000);

            ArchaeologyRecipesPayload payload = new ArchaeologyRecipesPayload(recipes);
            event.getRelevantPlayers().forEach(player -> PacketDistributor.sendToPlayer(player, payload));
        }
    }
}
