
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.bonk.item.YeeterMilkItem;
import net.mcreator.bonk.item.UpgradedMilkItem;
import net.mcreator.bonk.item.SplitterMilkItem;
import net.mcreator.bonk.item.RichMilkItem;
import net.mcreator.bonk.item.RecRoomFirstImpressionsItem;
import net.mcreator.bonk.item.PizzaItem;
import net.mcreator.bonk.item.PencilItem;
import net.mcreator.bonk.item.MultiWaterItem;
import net.mcreator.bonk.item.MultiSwordItem;
import net.mcreator.bonk.item.MultiShovelItem;
import net.mcreator.bonk.item.MultiPickaxeItem;
import net.mcreator.bonk.item.MultiItem;
import net.mcreator.bonk.item.MultiHoeItem;
import net.mcreator.bonk.item.MultiAxeItem;
import net.mcreator.bonk.item.MinerMilkItem;
import net.mcreator.bonk.item.MilkyounerdItem;
import net.mcreator.bonk.item.MilkItem;
import net.mcreator.bonk.item.MilkCoreItem;
import net.mcreator.bonk.item.LaserItem;
import net.mcreator.bonk.item.LaserGunItem;
import net.mcreator.bonk.item.HammerItem;
import net.mcreator.bonk.item.GigaMilkItem;
import net.mcreator.bonk.item.FOOTItem;
import net.mcreator.bonk.item.BonkingBatItem;
import net.mcreator.bonk.item.BeanyMilkItem;
import net.mcreator.bonk.item.BeanierArmorItem;
import net.mcreator.bonk.item.BeanSwordItem;
import net.mcreator.bonk.item.BeanAppleItem;
import net.mcreator.bonk.item.AnActualMilkGunItem;
import net.mcreator.bonk.item.AmbushMilkItem;

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
