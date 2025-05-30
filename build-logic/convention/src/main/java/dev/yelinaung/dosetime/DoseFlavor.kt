package dev.yelinaung.dosetime

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

@Suppress("EnumEntryName")
enum class DoseDimension {
    environment
}

@Suppress("EnumEntryName")
enum class DoseFlavor(
    val dimension: DoseDimension,
    val applicationIdSuffix: String? = null,
    val isDefault: Boolean = false
) {
    demo(DoseDimension.environment, applicationIdSuffix = ".demo", isDefault = true),
    prod(DoseDimension.environment),
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: DoseFlavor) -> Unit = {},
) {
    commonExtension.apply {
        DoseDimension.values().forEach { flavorDimension ->
            flavorDimensions += flavorDimension.name
        }

        productFlavors {
            DoseFlavor.values().forEach { doseFlavor ->
                register(doseFlavor.name) {
                    dimension = doseFlavor.dimension.name
                    flavorConfigurationBlock(this, doseFlavor)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (doseFlavor.applicationIdSuffix != null) {
                            applicationIdSuffix = doseFlavor.applicationIdSuffix
                            isDefault = doseFlavor.isDefault
                        }
                    }
                }
            }
        }
    }
}
