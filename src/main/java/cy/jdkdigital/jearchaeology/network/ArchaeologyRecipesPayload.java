package cy.jdkdigital.jearchaeology.network;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

/**
 * Carries the brushing and sniffing recipes to the client
 */
public record ArchaeologyRecipesPayload(List<RecipeHolder<?>> recipes) implements CustomPacketPayload
{
    public static final Type<ArchaeologyRecipesPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(JEArchaeology.MODID, "recipes"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ArchaeologyRecipesPayload> STREAM_CODEC = StreamCodec.composite(
            RecipeHolder.STREAM_CODEC.apply(ByteBufCodecs.list()), ArchaeologyRecipesPayload::recipes,
            ArchaeologyRecipesPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
