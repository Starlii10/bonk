
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("bonk", "bonk"), new SoundEvent(new ResourceLocation("bonk", "bonk")));
		REGISTRY.put(new ResourceLocation("bonk", "milk"), new SoundEvent(new ResourceLocation("bonk", "milk")));
		REGISTRY.put(new ResourceLocation("bonk", "hytale"), new SoundEvent(new ResourceLocation("bonk", "hytale")));
		REGISTRY.put(new ResourceLocation("bonk", "recroom"), new SoundEvent(new ResourceLocation("bonk", "recroom")));
		REGISTRY.put(new ResourceLocation("bonk", "jojolovania"), new SoundEvent(new ResourceLocation("bonk", "jojolovania")));
		REGISTRY.put(new ResourceLocation("bonk", "foot"), new SoundEvent(new ResourceLocation("bonk", "foot")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
