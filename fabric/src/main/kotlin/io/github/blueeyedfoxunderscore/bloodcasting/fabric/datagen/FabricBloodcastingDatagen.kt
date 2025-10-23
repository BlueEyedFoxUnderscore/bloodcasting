package io.github.blueeyedfoxunderscore.bloodcasting.fabric.datagen

import io.github.blueeyedfoxunderscore.bloodcasting.datagen.BloodcastingActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricBloodcastingDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::BloodcastingActionTags)
    }
}
