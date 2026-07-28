package cy.jdkdigital.jearchaeology.client;

import cy.jdkdigital.jearchaeology.network.ArchaeologyRecipesPayload;
import cy.jdkdigital.jearchaeology.recipe.BrushingRecipe;
import cy.jdkdigital.jearchaeology.recipe.SniffRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the recipes the server sent for this session
 */
public class ClientRecipeCache
{
    private static List<RecipeHolder<SniffRecipe>> sniffing = List.of();
    private static List<RecipeHolder<BrushingRecipe>> brushing = List.of();

    @SuppressWarnings("unchecked")
    public static void accept(ArchaeologyRecipesPayload payload) {
        List<RecipeHolder<SniffRecipe>> sniffRecipes = new ArrayList<>();
        List<RecipeHolder<BrushingRecipe>> brushRecipes = new ArrayList<>();
        for (RecipeHolder<?> holder : payload.recipes()) {
            if (holder.value() instanceof SniffRecipe) {
                sniffRecipes.add((RecipeHolder<SniffRecipe>) holder);
            } else if (holder.value() instanceof BrushingRecipe) {
                brushRecipes.add((RecipeHolder<BrushingRecipe>) holder);
            }
        }
        sniffing = List.copyOf(sniffRecipes);
        brushing = List.copyOf(brushRecipes);
    }

    public static void clear() {
        sniffing = List.of();
        brushing = List.of();
    }

    public static List<RecipeHolder<SniffRecipe>> getSniffingRecipes() {
        return sniffing;
    }

    public static List<RecipeHolder<BrushingRecipe>> getBrushingRecipes() {
        return brushing;
    }
}
