
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.item.YeeterMilkItem;
import net.wisedragoon.bonk.item.UpgradedMilkItem;
import net.wisedragoon.bonk.item.SplitterMilkItem;
import net.wisedragoon.bonk.item.RichMilkItem;
import net.wisedragoon.bonk.item.RecRoomFirstImpressionsItem;
import net.wisedragoon.bonk.item.PizzaItem;
import net.wisedragoon.bonk.item.PencilItem;
import net.wisedragoon.bonk.item.MultiWaterItem;
import net.wisedragoon.bonk.item.MultiSwordItem;
import net.wisedragoon.bonk.item.MultiShovelItem;
import net.wisedragoon.bonk.item.MultiPickaxeItem;
import net.wisedragoon.bonk.item.MultiPickItem;
import net.wisedragoon.bonk.item.MultiItem;
import net.wisedragoon.bonk.item.MultiHoeItem;
import net.wisedragoon.bonk.item.MultiAxeItem;
import net.wisedragoon.bonk.item.MinerMilkItem;
import net.wisedragoon.bonk.item.MilkyounerdItem;
import net.wisedragoon.bonk.item.MilkItem;
import net.wisedragoon.bonk.item.MilkCoreItem;
import net.wisedragoon.bonk.item.LaserItem;
import net.wisedragoon.bonk.item.LaserGunItem;
import net.wisedragoon.bonk.item.IcyBoatSpawnerItem;
import net.wisedragoon.bonk.item.HammerItem;
import net.wisedragoon.bonk.item.GigaMilkItem;
import net.wisedragoon.bonk.item.FOOTItem;
import net.wisedragoon.bonk.item.DebuggerItem;
import net.wisedragoon.bonk.item.BonkingBatItem;
import net.wisedragoon.bonk.item.BeanyMilkItem;
import net.wisedragoon.bonk.item.BeanierArmorItem;
import net.wisedragoon.bonk.item.BeanSwordItem;
import net.wisedragoon.bonk.item.BeanAppleItem;
import net.wisedragoon.bonk.item.AnActualMilkGunItem;
import net.wisedragoon.bonk.item.AmbushMilkItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item BEAN_SWORD = register(new BeanSwordItem());
	public static final Item BEAN = register(
			new SpawnEggItem(BonkModEntities.BEAN, -13434625, -16750849, new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB))
					.setRegistryName("bean_spawn_egg"));
	public static final Item NYOOOMMM = register(
			new SpawnEggItem(BonkModEntities.NYOOOMMM, -1, -1, new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB))
					.setRegistryName("nyooommm_spawn_egg"));
	public static final Item MILK = register(new MilkItem());
	public static final Item BEAN_APPLE = register(new BeanAppleItem());
	public static final Item HAMMER = register(new HammerItem());
	public static final Item XP = register(
			new SpawnEggItem(BonkModEntities.XP, -1, -1, new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB)).setRegistryName("xp_spawn_egg"));
	public static final Item BEANIER_ARMOR_HELMET = register(new BeanierArmorItem.Helmet());
	public static final Item BEANIER_ARMOR_CHESTPLATE = register(new BeanierArmorItem.Chestplate());
	public static final Item BEANIER_ARMOR_LEGGINGS = register(new BeanierArmorItem.Leggings());
	public static final Item BEANIER_ARMOR_BOOTS = register(new BeanierArmorItem.Boots());
	public static final Item NEON_BLOCK = register(BonkModBlocks.NEON_BLOCK, BonkModTabs.TAB_BONK_TAB);
	public static final Item PIZZA = register(new PizzaItem());
	public static final Item PIZZA_PLANT = register(BonkModBlocks.PIZZA_PLANT, CreativeModeTab.TAB_FOOD);
	public static final Item MULTI_WATER_BUCKET = register(new MultiWaterItem());
	public static final Item REC_ROOM_FIRST_IMPRESSIONS = register(new RecRoomFirstImpressionsItem());
	public static final Item UPGRADED_MILK = register(new UpgradedMilkItem());
	public static final Item MULTI = register(new MultiItem());
	public static final Item MULTI_ORE = register(BonkModBlocks.MULTI_ORE, BonkModTabs.TAB_BONK_TAB);
	public static final Item MULTI_PICKAXE = register(new MultiPickaxeItem());
	public static final Item MULTI_AXE = register(new MultiAxeItem());
	public static final Item MULTI_SWORD = register(new MultiSwordItem());
	public static final Item MULTI_SHOVEL = register(new MultiShovelItem());
	public static final Item MULTI_HOE = register(new MultiHoeItem());
	public static final Item MULTIBLOCK = register(BonkModBlocks.MULTIBLOCK, BonkModTabs.TAB_BONK_TAB);
	public static final Item GIGA_MILK = register(new GigaMilkItem());
	public static final Item BEANY_MILK = register(new BeanyMilkItem());
	public static final Item SPLITTER_MILK = register(new SplitterMilkItem());
	public static final Item YEETER_MILK = register(new YeeterMilkItem());
	public static final Item RICH_MILK = register(new RichMilkItem());
	public static final Item FOOT = register(new FOOTItem());
	public static final Item AMBUSH_MILK = register(new AmbushMilkItem());
	public static final Item MILK_CORE = register(new MilkCoreItem());
	public static final Item MINER_MILK = register(new MinerMilkItem());
	public static final Item BONKER = register(
			new SpawnEggItem(BonkModEntities.BONKER, -3355444, -10066330, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("bonker_spawn_egg"));
	public static final Item BONKER_BUDDY = register(
			new SpawnEggItem(BonkModEntities.BONKER_BUDDY, -3355444, -10066330, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("bonker_buddy_spawn_egg"));
	public static final Item AN_ACTUAL_MILK_GUN = register(new AnActualMilkGunItem());
	public static final Item MILKYOUNERD_BUCKET = register(new MilkyounerdItem());
	public static final Item ANTI_BEAN = register(
			new SpawnEggItem(BonkModEntities.ANTI_BEAN, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("anti_bean_spawn_egg"));
	public static final Item ULTIMATE_BEAN = register(
			new SpawnEggItem(BonkModEntities.ULTIMATE_BEAN, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("ultimate_bean_spawn_egg"));
	public static final Item NAME_CHANGER = register(BonkModBlocks.NAME_CHANGER, BonkModTabs.TAB_BONK_TAB);
	public static final Item PENCIL = register(new PencilItem());
	public static final Item LASER = register(new LaserItem());
	public static final Item LASER_GUN = register(new LaserGunItem());
	public static final Item UFO = register(
			new SpawnEggItem(BonkModEntities.UFO, -16724737, -3394561, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("ufo_spawn_egg"));
	public static final Item BONKING_BAT = register(new BonkingBatItem());
	public static final Item MULTI_PICK = register(new MultiPickItem());
	public static final Item ICY_BOAT = register(
			new SpawnEggItem(BonkModEntities.ICY_BOAT, -16711681, -10040065, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("icy_boat_spawn_egg"));
	public static final Item ICY_BOAT_SPAWNER = register(new IcyBoatSpawnerItem());
	public static final Item E = register(BonkModBlocks.E, BonkModTabs.TAB_BONK_TAB);
	public static final Item MINE = register(BonkModBlocks.MINE, BonkModTabs.TAB_BONK_TAB);
	public static final Item DEBUGGER = register(new DebuggerItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
