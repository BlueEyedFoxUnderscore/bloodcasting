package io.github.blueeyedfoxunderscore.bloodcasting.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.blueeyedfoxunderscore.bloodcasting.config.BloodcastingServerConfig
import io.github.blueeyedfoxunderscore.bloodcasting.networking.msg.*

fun BloodcastingMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            BloodcastingServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
