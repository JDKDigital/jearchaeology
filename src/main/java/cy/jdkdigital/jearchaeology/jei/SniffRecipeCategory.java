package cy.jdkdigital.jearchaeology.jei;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import cy.jdkdigital.jearchaeology.recipe.SniffRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SniffRecipeCategory extends AbstractRecipeCategory<RecipeHolder<SniffRecipe>>
{
    private static final int COLUMNS = 7;

    public SniffRecipeCategory(IGuiHelper guiHelper) {
        super(
                JeiPlugin.SNIFF_RECIPE_TYPE.get(),
                Component.translatable(JEArchaeology.MODID + ".recipe.sniff"),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.SNIFFER_EGG)),
                126, 70
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<SniffRecipe> recipe, @NotNull IFocusGroup iFocusGroup) {
        List<ItemStack> items = recipe.value().items;
        for (int i = 0; i < items.size(); i++) {
            int row = i / COLUMNS;
            builder.addSlot(RecipeIngredientRole.OUTPUT, (i - (row * COLUMNS)) * 18, row * 18)
                    .add(items.get(i))
                    .setSlotName("thing" + i);
        }
    }
}
