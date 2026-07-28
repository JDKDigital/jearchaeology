package cy.jdkdigital.jearchaeology.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import cy.jdkdigital.jearchaeology.JEArchaeology;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
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

public class BrushingRecipe implements Recipe<RecipeInput>
{
    public static final MapCodec<BrushingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder.group(
                            LootItems.CODEC.fieldOf("items").forGetter(recipe -> recipe.items),
                            Codec.FLOAT.fieldOf("chance").orElse(0.05f).forGetter(recipe -> recipe.chance),
                            Ingredient.CODEC.fieldOf("brushableBlock").forGetter(recipe -> recipe.brushableBlock)
                    )
                    .apply(builder, BrushingRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, BrushingRecipe> STREAM_CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_LIST_STREAM_CODEC, recipe -> recipe.items,
            ByteBufCodecs.FLOAT, recipe -> recipe.chance,
            Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.brushableBlock,
            BrushingRecipe::new
    );

    public static final RecipeSerializer<BrushingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    /**
     * The items brushing the block can turn up. They are rolled off the block's archaeology loot table rather than
     * matched against an input, so they keep their counts and components and are only ever displayed.
     */
    public final List<ItemStack> items;
    public final float chance;
    public final Ingredient brushableBlock;

    public BrushingRecipe(List<ItemStack> items, float chance, Ingredient brushableBlock) {
        this.items = items;
        this.chance = chance;
        this.brushableBlock = brushableBlock;
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
    public RecipeSerializer<BrushingRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Nonnull
    @Override
    public RecipeType<BrushingRecipe> getType() {
        return JEArchaeology.BRUSH_TYPE.get();
    }
}
