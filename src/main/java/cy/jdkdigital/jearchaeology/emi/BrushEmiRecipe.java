package cy.jdkdigital.jearchaeology.emi;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import cy.jdkdigital.jearchaeology.recipe.BrushingRecipe;
import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

public class BrushEmiRecipe extends BasicEmiRecipe
{
    private final RecipeHolder<BrushingRecipe> recipe;

    public BrushEmiRecipe(RecipeHolder<BrushingRecipe> recipe) {
        super(EmiPlugin.BRUSHING_CATEGORY, recipe.id(), 144, 93);

        this.inputs.add(EmiIngredient.of(recipe.value().brushableBlock));
        for (ItemStack itemStack : recipe.value().item.getItems()) {
            this.outputs.add(EmiStack.of(itemStack));
        }
        this.recipe = recipe;
    }

    @Override
    public boolean supportsRecipeTree() {
        return false;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addSlot(this.inputs.get(0), 0, 74).drawBack(false);

        for (int i = 0; i < this.outputs.size(); i++){
            int row = (int) Math.floor(i / 8f);
            widgets.addSlot(this.outputs.get(i), (i - (row * 8)) * 18, row * 18).drawBack(false).recipeContext(this);
        }

        var name = recipe.id().getPath().replace("archeology/", "").replace("archaeology/", "").replaceAll("_[0-9]", "");
        widgets.addText(Component.translatable(JEArchaeology.MODID + ".brush.structure." + name), 22, 78, 0xFF000000, false);
    }
}
