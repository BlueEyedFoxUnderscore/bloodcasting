@file:JvmName("BloodcastingAbstractionsImpl")

package io.github.blueeyedfoxunderscore.bloodcasting.fabric

import io.github.blueeyedfoxunderscore.bloodcasting.registry.BloodcastingRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: BloodcastingRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
