package io.github.blueeyedfoxunderscore.bloodcasting.fabric

import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import net.fabricmc.api.DedicatedServerModInitializer

object FabricBloodcastingServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Bloodcasting.initServer()
    }
}
