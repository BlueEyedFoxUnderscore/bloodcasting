package io.github.blueeyedfoxunderscore.bloodcasting.forge

import dev.architectury.platform.forge.EventBuses
import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import io.github.blueeyedfoxunderscore.bloodcasting.forge.datagen.ForgeBloodcastingDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Bloodcasting.MODID)
class ForgeBloodcasting {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Bloodcasting.MODID, this)
            addListener(ForgeBloodcastingClient::init)
            addListener(ForgeBloodcastingDatagen::init)
            addListener(ForgeBloodcastingServer::init)
        }
        Bloodcasting.init()
    }
}
