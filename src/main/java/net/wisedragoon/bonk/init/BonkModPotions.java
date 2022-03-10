
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModPotions {
	private static final List<Potion> REGISTRY = new ArrayList<>();
	public static final Potion REC_BUFF_POTION = register(
			new Potion(new MobEffectInstance(BonkModMobEffects.REC_BUFF, 3600, 0, false, true)).setRegistryName("rec_buff_potion"));

	private static Potion register(Potion potion) {
		REGISTRY.add(potion);
		return potion;
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Potion[0]));
	}
}
