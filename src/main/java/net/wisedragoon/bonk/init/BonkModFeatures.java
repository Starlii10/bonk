
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.world.features.plants.PizzaPlantFeature;
import net.wisedragoon.bonk.world.features.ores.MultiOreFeature;
import net.wisedragoon.bonk.world.features.ores.MineFeature;
import net.wisedragoon.bonk.world.features.lakes.MultiWaterFeature;
import net.wisedragoon.bonk.world.features.lakes.MilkyounerdFeature;
import net.wisedragoon.bonk.world.features.RecroomFeature;
import net.wisedragoon.bonk.world.features.AmogusFeature;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModFeatures {
	private static final Map<Feature<?>, FeatureRegistration> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(PizzaPlantFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION,
				PizzaPlantFeature.GENERATE_BIOMES, PizzaPlantFeature.CONFIGURED_FEATURE));
		REGISTRY.put(MultiWaterFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.LAKES, MultiWaterFeature.GENERATE_BIOMES, MultiWaterFeature.CONFIGURED_FEATURE));
		REGISTRY.put(MultiOreFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, MultiOreFeature.GENERATE_BIOMES,
				MultiOreFeature.CONFIGURED_FEATURE));
		REGISTRY.put(RecroomFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, RecroomFeature.GENERATE_BIOMES,
				RecroomFeature.CONFIGURED_FEATURE));
		REGISTRY.put(AmogusFeature.FEATURE, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AmogusFeature.GENERATE_BIOMES,
				AmogusFeature.CONFIGURED_FEATURE));
		REGISTRY.put(MilkyounerdFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.LAKES, MilkyounerdFeature.GENERATE_BIOMES, MilkyounerdFeature.CONFIGURED_FEATURE));
		REGISTRY.put(MineFeature.FEATURE,
				new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, MineFeature.GENERATE_BIOMES, MineFeature.CONFIGURED_FEATURE));
	}

	@SubscribeEvent
	public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
		event.getRegistry().registerAll(REGISTRY.keySet().toArray(new Feature[0]));
		REGISTRY.forEach((feature, registration) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, feature.getRegistryName(),
				registration.configuredFeature()));
	}

	@Mod.EventBusSubscriber
	private static class BiomeFeatureLoader {
		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			for (FeatureRegistration registration : REGISTRY.values()) {
				if (registration.biomes() == null || registration.biomes().contains(event.getName())) {
					event.getGeneration().getFeatures(registration.stage()).add(() -> registration.configuredFeature());
				}
			}
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			ConfiguredFeature<?, ?> configuredFeature) {
	}
}
