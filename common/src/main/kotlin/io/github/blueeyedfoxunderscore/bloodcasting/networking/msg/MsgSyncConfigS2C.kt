package io.github.blueeyedfoxunderscore.bloodcasting.networking.msg

import io.github.blueeyedfoxunderscore.bloodcasting.config.BloodcastingServerConfig
import net.minecraft.network.FriendlyByteBuf

data class MsgSyncConfigS2C(val serverConfig: BloodcastingServerConfig.ServerConfig) : BloodcastingMessageS2C {
    companion object : BloodcastingMessageCompanion<MsgSyncConfigS2C> {
        override val type = MsgSyncConfigS2C::class.java

        override fun decode(buf: FriendlyByteBuf) = MsgSyncConfigS2C(
            serverConfig = BloodcastingServerConfig.ServerConfig().decode(buf),
        )

        override fun MsgSyncConfigS2C.encode(buf: FriendlyByteBuf) {
            serverConfig.encode(buf)
        }
    }
}
