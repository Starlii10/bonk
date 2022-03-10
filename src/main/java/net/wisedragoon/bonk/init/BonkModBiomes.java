
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.world.biome.OpBiome;
import net.wisedragoon.bonk.world.biome.GigaWoodsBiome;
import net.wisedragoon.bonk.world.biome.BoomBiome;
import net.wisedragoon.bonk.world.biome.BEANWJIJAJNFJANBiome;
import net.wisedragoon.bonk.BonkMod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModBiomes {
	private static final List<Biome> REGISTRY = new ArrayList<>();
	public static Biome BEANWJIJAJNFJAN = register("beanwjijajnfjan", BEANWJIJAJNFJANBiome.createBiome());
	public static Biome OH_GOD_WHAT_HAVE_I_DONE = register("oh_god_what_have_i_done", GigaWoodsBiome.createBiome());
	public static Biome BOOM = register("boom", BoomBiome.createBiome());
	public static Biome OP = register("op", OpBiome.createBiome());

	private static Biome register(String registryname, Biome biome) {
		REGISTRY.add(biome.setRegistryName(new ResourceLocation(BonkMod.MODID, registryname)));
		return biome;
	}

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Biome[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BEANWJIJAJNFJANBiome.init();
			GigaWoodsBiome.init();
			BoomBiome.init();
			OpBiome.init();
		});
	}
}
