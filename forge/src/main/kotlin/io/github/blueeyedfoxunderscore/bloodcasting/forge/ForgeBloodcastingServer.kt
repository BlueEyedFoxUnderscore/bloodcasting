package io.github.blueeyedfoxunderscore.bloodcasting.forge

import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeBloodcastingServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Bloodcasting.initServer()
    }
}
