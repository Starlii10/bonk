
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.bonk.client.gui.NameChangerGUIScreen;
import net.mcreator.bonk.client.gui.MultimenuScreen;
import net.mcreator.bonk.client.gui.MilkContainerGUIScreen;
import net.mcreator.bonk.client.gui.ItemSyncerGUIScreen;
import net.mcreator.bonk.client.gui.AskToSetSpawnDimensionScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BonkModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BonkModMenus.MULTIMENU, MultimenuScreen::new);
			MenuScreens.register(BonkModMenus.MILK_CONTAINER_GUI, MilkContainerGUIScreen::new);
			MenuScreens.register(BonkModMenus.ASK_TO_SET_SPAWN_DIMENSION, AskToSetSpawnDimensionScreen::new);
			MenuScreens.register(BonkModMenus.NAME_CHANGER_GUI, NameChangerGUIScreen::new);
			MenuScreens.register(BonkModMenus.ITEM_SYNCER_GUI, ItemSyncerGUIScreen::new);
		});
	}
}
