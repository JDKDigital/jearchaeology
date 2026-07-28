package cy.jdkdigital.jearchaeology.jei;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import cy.jdkdigital.jearchaeology.client.ClientRecipeCache;
import cy.jdkdigital.jearchaeology.compat.CompatHandler;
import cy.jdkdigital.jearchaeology.recipe.BrushingRecipe;
import cy.jdkdigital.jearchaeology.recipe.SniffRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin
{
    private static final Identifier pluginId = Identifier.fromNamespaceAndPath(JEArchaeology.MODID, JEArchaeology.MODID);

    public static Supplier<IRecipeHolderType<SniffRecipe>> SNIFF_RECIPE_TYPE = IRecipeHolderType.createDeferred(JEArchaeology.SNIFF_TYPE);
    public static Supplier<IRecipeHolderType<BrushingRecipe>> BRUSH_RECIPE_TYPE = IRecipeHolderType.createDeferred(JEArchaeology.BRUSH_TYPE);

    public JeiPlugin() {
    }

    @Nonnull
    @Override
    public Identifier getPluginUid() {
        return pluginId;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(SNIFF_RECIPE_TYPE.get(), Items.SNIFFER_EGG);
        registration.addCraftingStation(BRUSH_RECIPE_TYPE.get(), Items.BRUSH);
        CompatHandler.addRecipeCatalyst(registration, BRUSH_RECIPE_TYPE.get());
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        registration.addRecipeCategories(new SniffRecipeCategory(guiHelper));
        registration.addRecipeCategories(new BrushRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(SNIFF_RECIPE_TYPE.get(), ClientRecipeCache.getSniffingRecipes());
        registration.addRecipes(BRUSH_RECIPE_TYPE.get(), ClientRecipeCache.getBrushingRecipes());
    }
}
