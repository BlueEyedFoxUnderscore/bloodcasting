@file:JvmName("BloodcastingAbstractions")

package io.github.blueeyedfoxunderscore.bloodcasting

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.blueeyedfoxunderscore.bloodcasting.registry.BloodcastingRegistrar

fun initRegistries(vararg registries: BloodcastingRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: BloodcastingRegistrar<T>) {
    throw AssertionError()
}
