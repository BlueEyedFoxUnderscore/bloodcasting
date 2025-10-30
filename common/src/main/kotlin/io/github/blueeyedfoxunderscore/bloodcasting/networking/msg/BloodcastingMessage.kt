package io.github.blueeyedfoxunderscore.bloodcasting.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import io.github.blueeyedfoxunderscore.bloodcasting.networking.BloodcastingNetworking
import io.github.blueeyedfoxunderscore.bloodcasting.networking.handler.applyOnClient
import io.github.blueeyedfoxunderscore.bloodcasting.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface BloodcastingMessage

sealed interface BloodcastingMessageC2S : BloodcastingMessage {
    fun sendToServer() {
        BloodcastingNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface BloodcastingMessageS2C : BloodcastingMessage {
    fun sendToPlayer(player: ServerPlayer) {
        BloodcastingNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        BloodcastingNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface BloodcastingMessageCompanion<T : BloodcastingMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Bloodcasting.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is BloodcastingMessageC2S -> msg.applyOnServer(ctx)
                    else -> Bloodcasting.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Bloodcasting.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is BloodcastingMessageS2C -> msg.applyOnClient(ctx)
                    else -> Bloodcasting.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
