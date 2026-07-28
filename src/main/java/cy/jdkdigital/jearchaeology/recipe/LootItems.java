package cy.jdkdigital.jearchaeology.recipe;

import com.mojang.serialization.Codec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

import java.util.List;

/**
 * The list of loot results a brushing or sniffing recipe displays
 */
public final class LootItems
{
    public static final Codec<List<ItemStack>> CODEC = ItemStackTemplate.CODEC
            .listOf()
            .xmap(
                    templates -> templates.stream().map(ItemStackTemplate::create).filter(stack -> !stack.isEmpty()).toList(),
                    stacks -> stacks.stream().filter(stack -> !stack.isEmpty()).map(ItemStackTemplate::fromNonEmptyStack).toList()
            );

    private LootItems() {}
}
