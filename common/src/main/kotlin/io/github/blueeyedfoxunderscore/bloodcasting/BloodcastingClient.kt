package io.github.blueeyedfoxunderscore.bloodcasting

import io.github.blueeyedfoxunderscore.bloodcasting.config.BloodcastingClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object BloodcastingClient {
    fun init() {
        BloodcastingClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(BloodcastingClientConfig.GlobalConfig::class.java, parent).get()
    }
}
