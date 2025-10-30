package io.github.blueeyedfoxunderscore.bloodcasting.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.blueeyedfoxunderscore.bloodcasting.BloodcastingClient

object FabricBloodcastingModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(BloodcastingClient::getConfigScreen)
}
