package io.github.blueeyedfoxunderscore.bloodcasting.fabric

import io.github.blueeyedfoxunderscore.bloodcasting.BloodcastingClient
import net.fabricmc.api.ClientModInitializer

object FabricBloodcastingClient : ClientModInitializer {
    override fun onInitializeClient() {
        BloodcastingClient.init()
    }
}
