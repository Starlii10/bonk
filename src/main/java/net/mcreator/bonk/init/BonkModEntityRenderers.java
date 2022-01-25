
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.bonk.client.renderer.XPRenderer;
import net.mcreator.bonk.client.renderer.UltimateBeanRenderer;
import net.mcreator.bonk.client.renderer.UFORenderer;
import net.mcreator.bonk.client.renderer.NyooommmRenderer;
import net.mcreator.bonk.client.renderer.BonkerRenderer;
import net.mcreator.bonk.client.renderer.BonkerBuddyRenderer;
import net.mcreator.bonk.client.renderer.BeanRenderer;
import net.mcreator.bonk.client.renderer.AntiBeanRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BonkModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BonkModEntities.BEAN, BeanRenderer::new);
		event.registerEntityRenderer(BonkModEntities.NYOOOMMM, NyooommmRenderer::new);
		event.registerEntityRenderer(BonkModEntities.MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.XP, XPRenderer::new);
		event.registerEntityRenderer(BonkModEntities.UPGRADED_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.GIGA_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.BEANY_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.SPLITTER_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.YEETER_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.RICH_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.AMBUSH_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.MINER_MILK, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.BONKER, BonkerRenderer::new);
		event.registerEntityRenderer(BonkModEntities.BONKER_BUDDY, BonkerBuddyRenderer::new);
		event.registerEntityRenderer(BonkModEntities.AN_ACTUAL_MILK_GUN, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.ANTI_BEAN, AntiBeanRenderer::new);
		event.registerEntityRenderer(BonkModEntities.ULTIMATE_BEAN, UltimateBeanRenderer::new);
		event.registerEntityRenderer(BonkModEntities.LASER_GUN, ThrownItemRenderer::new);
		event.registerEntityRenderer(BonkModEntities.UFO, UFORenderer::new);
	}
}
