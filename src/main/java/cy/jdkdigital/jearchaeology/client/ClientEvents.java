package cy.jdkdigital.jearchaeology.client;

import cy.jdkdigital.jearchaeology.JEArchaeology;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

@EventBusSubscriber(modid = JEArchaeology.MODID, value = Dist.CLIENT)
public class ClientEvents
{
    @SubscribeEvent
    public static void onLoggingOut(ClientPlayerNetworkEvent.LoggingOut event) {
        ClientRecipeCache.clear();
    }
}
