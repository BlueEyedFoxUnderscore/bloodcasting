package io.github.blueeyedfoxunderscore.bloodcasting.forge

import io.github.blueeyedfoxunderscore.bloodcasting.BloodcastingClient
import net.minecraftforge.client.ConfigScreenHandler.ConfigScreenFactory
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import thedarkcolour.kotlinforforge.forge.LOADING_CONTEXT

object ForgeBloodcastingClient {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLClientSetupEvent) {
        BloodcastingClient.init()
        LOADING_CONTEXT.registerExtensionPoint(ConfigScreenFactory::class.java) {
            ConfigScreenFactory { _, parent -> BloodcastingClient.getConfigScreen(parent) }
        }
    }
}
