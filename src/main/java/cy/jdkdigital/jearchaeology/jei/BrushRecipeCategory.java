package cy.jdkdigital.jearchaeology.jei;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import cy.jdkdigital.jearchaeology.recipe.BrushingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BrushRecipeCategory extends AbstractRecipeCategory<RecipeHolder<BrushingRecipe>>
{
    private static final int COLUMNS = 8;

    public BrushRecipeCategory(IGuiHelper guiHelper) {
        super(
                JeiPlugin.BRUSH_RECIPE_TYPE.get(),
                Component.translatable(JEArchaeology.MODID + ".recipe.brush"),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.BRUSH)),
                144, 93
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<BrushingRecipe> recipe, @NotNull IFocusGroup iFocusGroup) {
        List<ItemStack> items = recipe.value().items;
        for (int i = 0; i < items.size(); i++) {
            int row = i / COLUMNS;
            builder.addSlot(RecipeIngredientRole.OUTPUT, (i - (row * COLUMNS)) * 18, row * 18)
                    .add(items.get(i))
                    .setSlotName("thing" + i);
        }
        builder.addSlot(RecipeIngredientRole.INPUT, 0, 74).add(recipe.value().brushableBlock).setSlotName("sussy_block");
    }

    @Override
    public void draw(RecipeHolder<BrushingRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        var name = recipe.id().identifier().getPath().replace("archeology/", "").replace("archaeology/", "").replaceAll("_[0-9]", "");
        guiGraphics.text(minecraft.font, Component.translatable(JEArchaeology.MODID + ".brush.structure." + name), 22, 78, 0xFF000000, false);
    }
}
