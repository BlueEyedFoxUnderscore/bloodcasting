package io.github.blueeyedfoxunderscore.bloodcasting.fabric

import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import net.fabricmc.api.ModInitializer

object FabricBloodcasting : ModInitializer {
    override fun onInitialize() {
        Bloodcasting.init()
    }
}
