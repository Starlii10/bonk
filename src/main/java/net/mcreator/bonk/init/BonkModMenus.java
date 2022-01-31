
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.bonk.world.inventory.NameChangerGUIMenu;
import net.mcreator.bonk.world.inventory.MultimenuMenu;
import net.mcreator.bonk.world.inventory.MilkContainerGUIMenu;
import net.mcreator.bonk.world.inventory.ItemSyncerGUIMenu;
import net.mcreator.bonk.world.inventory.AskToSetSpawnDimensionMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<MultimenuMenu> MULTIMENU = register("multimenu", (id, inv, extraData) -> new MultimenuMenu(id, inv, extraData));
	public static final MenuType<MilkContainerGUIMenu> MILK_CONTAINER_GUI = register("milk_container_gui",
			(id, inv, extraData) -> new MilkContainerGUIMenu(id, inv, extraData));
	public static final MenuType<AskToSetSpawnDimensionMenu> ASK_TO_SET_SPAWN_DIMENSION = register("ask_to_set_spawn_dimension",
			(id, inv, extraData) -> new AskToSetSpawnDimensionMenu(id, inv, extraData));
	public static final MenuType<NameChangerGUIMenu> NAME_CHANGER_GUI = register("name_changer_gui",
			(id, inv, extraData) -> new NameChangerGUIMenu(id, inv, extraData));
	public static final MenuType<ItemSyncerGUIMenu> ITEM_SYNCER_GUI = register("item_syncer_gui",
			(id, inv, extraData) -> new ItemSyncerGUIMenu(id, inv, extraData));

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
