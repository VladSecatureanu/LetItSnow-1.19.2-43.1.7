package net.sec.letitsnow.world.biomemods;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import org.jetbrains.annotations.NotNull;

public record ModClimateBiomeModifier(HolderSet<Biome> biomes) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if(phase == Phase.MODIFY && !biomes.contains(biome)) {
            builder.getClimateSettings().setPrecipitation(Biome.Precipitation.SNOW);
            builder.getClimateSettings().setTemperature(0F);
            builder.getClimateSettings().setTemperatureModifier(Biome.TemperatureModifier.NONE);
        }
    }

    @Override
    public @NotNull Codec<? extends BiomeModifier> codec() {
        return (Codec<? extends BiomeModifier>) ModBiomeModifiers.CLIMATE_MODIFIER.get();
    }
}

