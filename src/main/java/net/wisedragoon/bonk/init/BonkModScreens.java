
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.client.gui.VariablesScreen;
import net.wisedragoon.bonk.client.gui.OtherModsScreen;
import net.wisedragoon.bonk.client.gui.NameChangerGUIScreen;
import net.wisedragoon.bonk.client.gui.MultimenuScreen;
import net.wisedragoon.bonk.client.gui.HelpScreen;
import net.wisedragoon.bonk.client.gui.GUIsScreen;
import net.wisedragoon.bonk.client.gui.DebuggerGUIScreen;
import net.wisedragoon.bonk.client.gui.ComingSoonScreen;
import net.wisedragoon.bonk.client.gui.AskToSetSpawnDimensionScreen;
import net.wisedragoon.bonk.client.gui.AboutBonkScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BonkModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BonkModMenus.MULTIMENU, MultimenuScreen::new);
			MenuScreens.register(BonkModMenus.ASK_TO_SET_SPAWN_DIMENSION, AskToSetSpawnDimensionScreen::new);
			MenuScreens.register(BonkModMenus.NAME_CHANGER_GUI, NameChangerGUIScreen::new);
			MenuScreens.register(BonkModMenus.DEBUGGER_GUI, DebuggerGUIScreen::new);
			MenuScreens.register(BonkModMenus.VARIABLES, VariablesScreen::new);
			MenuScreens.register(BonkModMenus.GU_IS, GUIsScreen::new);
			MenuScreens.register(BonkModMenus.ABOUT_BONK, AboutBonkScreen::new);
			MenuScreens.register(BonkModMenus.COMING_SOON, ComingSoonScreen::new);
			MenuScreens.register(BonkModMenus.HELP, HelpScreen::new);
			MenuScreens.register(BonkModMenus.OTHER_MODS, OtherModsScreen::new);
		});
	}
}
