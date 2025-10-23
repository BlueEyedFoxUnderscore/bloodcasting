package io.github.blueeyedfoxunderscore.bloodcasting

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.blueeyedfoxunderscore.bloodcasting.config.BloodcastingServerConfig
import io.github.blueeyedfoxunderscore.bloodcasting.networking.BloodcastingNetworking
import io.github.blueeyedfoxunderscore.bloodcasting.registry.BloodcastingActions

object Bloodcasting {
    const val MODID = "bloodcasting"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        BloodcastingServerConfig.init()
        initRegistries(
            BloodcastingActions,
        )
        BloodcastingNetworking.init()
    }

    fun initServer() {
        BloodcastingServerConfig.initServer()
    }
}
