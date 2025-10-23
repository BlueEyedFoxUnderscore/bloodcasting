package io.github.blueeyedfoxunderscore.bloodcasting.networking

import dev.architectury.networking.NetworkChannel
import io.github.blueeyedfoxunderscore.bloodcasting.Bloodcasting
import io.github.blueeyedfoxunderscore.bloodcasting.networking.msg.BloodcastingMessageCompanion

object BloodcastingNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Bloodcasting.id("networking_channel"))

    fun init() {
        for (subclass in BloodcastingMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
