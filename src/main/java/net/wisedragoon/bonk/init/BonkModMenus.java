
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.world.inventory.VariablesMenu;
import net.wisedragoon.bonk.world.inventory.OtherModsMenu;
import net.wisedragoon.bonk.world.inventory.NameChangerGUIMenu;
import net.wisedragoon.bonk.world.inventory.MultimenuMenu;
import net.wisedragoon.bonk.world.inventory.HelpMenu;
import net.wisedragoon.bonk.world.inventory.GUIsMenu;
import net.wisedragoon.bonk.world.inventory.DebuggerGUIMenu;
import net.wisedragoon.bonk.world.inventory.ComingSoonMenu;
import net.wisedragoon.bonk.world.inventory.AskToSetSpawnDimensionMenu;
import net.wisedragoon.bonk.world.inventory.AboutBonkMenu;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<MultimenuMenu> MULTIMENU = register("multimenu", (id, inv, extraData) -> new MultimenuMenu(id, inv, extraData));
	public static final MenuType<AskToSetSpawnDimensionMenu> ASK_TO_SET_SPAWN_DIMENSION = register("ask_to_set_spawn_dimension",
			(id, inv, extraData) -> new AskToSetSpawnDimensionMenu(id, inv, extraData));
	public static final MenuType<NameChangerGUIMenu> NAME_CHANGER_GUI = register("name_changer_gui",
			(id, inv, extraData) -> new NameChangerGUIMenu(id, inv, extraData));
	public static final MenuType<DebuggerGUIMenu> DEBUGGER_GUI = register("debugger_gui",
			(id, inv, extraData) -> new DebuggerGUIMenu(id, inv, extraData));
	public static final MenuType<VariablesMenu> VARIABLES = register("variables", (id, inv, extraData) -> new VariablesMenu(id, inv, extraData));
	public static final MenuType<GUIsMenu> GU_IS = register("gu_is", (id, inv, extraData) -> new GUIsMenu(id, inv, extraData));
	public static final MenuType<AboutBonkMenu> ABOUT_BONK = register("about_bonk", (id, inv, extraData) -> new AboutBonkMenu(id, inv, extraData));
	public static final MenuType<ComingSoonMenu> COMING_SOON = register("coming_soon",
			(id, inv, extraData) -> new ComingSoonMenu(id, inv, extraData));
	public static final MenuType<HelpMenu> HELP = register("help", (id, inv, extraData) -> new HelpMenu(id, inv, extraData));
	public static final MenuType<OtherModsMenu> OTHER_MODS = register("other_mods", (id, inv, extraData) -> new OtherModsMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
