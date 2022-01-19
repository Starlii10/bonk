
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.bonk.enchantment.TransformEnchantment;
import net.mcreator.bonk.enchantment.RecRooooooooooooomEnchantment;
import net.mcreator.bonk.enchantment.NukedEnchantment;
import net.mcreator.bonk.enchantment.HytaleEnchantment;
import net.mcreator.bonk.enchantment.BeanyEnchantment;
import net.mcreator.bonk.enchantment.AntiDieEnchantment;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModEnchantments {
	private static final List<Enchantment> REGISTRY = new ArrayList<>();
	public static final Enchantment BEANY = register("bonk:beany", new BeanyEnchantment());
	public static final Enchantment NUKED = register("bonk:nuked", new NukedEnchantment());
	public static final Enchantment HYTALE = register("bonk:hytale", new HytaleEnchantment());
	public static final Enchantment ANTI_DIE = register("bonk:anti_die", new AntiDieEnchantment());
	public static final Enchantment REC_ROOOOOOOOOOOOOM = register("bonk:rec_rooooooooooooom", new RecRooooooooooooomEnchantment());
	public static final Enchantment TRANSFORM = register("bonk:transform", new TransformEnchantment());

	private static Enchantment register(String registryname, Enchantment enchantment) {
		REGISTRY.add(enchantment.setRegistryName(registryname));
		return enchantment;
	}

	@SubscribeEvent
	public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Enchantment[0]));
	}
}
