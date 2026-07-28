package cy.jdkdigital.jearchaeology.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import cy.jdkdigital.jearchaeology.JEArchaeology;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import java.util.List;

public class SniffRecipe implements Recipe<RecipeInput>
{
    public static final MapCodec<SniffRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder.group(
                            LootItems.CODEC.fieldOf("items").forGetter(recipe -> recipe.items),
                            Codec.FLOAT.fieldOf("chance").orElse(0.05f).forGetter(recipe -> recipe.chance)
                    )
                    .apply(builder, SniffRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, SniffRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_LIST_STREAM_CODEC, recipe -> recipe.items,
            ByteBufCodecs.FLOAT, recipe -> recipe.chance,
            SniffRecipe::new
    );

    public static final RecipeSerializer<SniffRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    /**
     * The items a sniffer can turn up. They are rolled off the sniffer digging loot table rather than matched
     * against an input, so they keep their counts and components and are only ever displayed.
     */
    public final List<ItemStack> items;
    public final float chance;

    public SniffRecipe(List<ItemStack> items, float chance) {
        this.items = items;
        this.chance = chance;
    }

    @Override
    public boolean matches(RecipeInput inv, Level levelIn) {
        return false;
    }

    @Nonnull
    @Override
    public ItemStack assemble(RecipeInput inv) {
        return ItemStack.EMPTY;
    }

    @Nonnull
    @Override
    public String group() {
        return "";
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Nonnull
    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Nonnull
    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Nonnull
    @Override
    public RecipeSerializer<SniffRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Nonnull
    @Override
    public RecipeType<SniffRecipe> getType() {
        return JEArchaeology.SNIFF_TYPE.get();
    }
}
