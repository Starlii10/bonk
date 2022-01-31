
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.bonk.block.PizzaPlantBlock;
import net.mcreator.bonk.block.NeonBlockBlock;
import net.mcreator.bonk.block.NameChangerBlock;
import net.mcreator.bonk.block.MultiblockBlock;
import net.mcreator.bonk.block.MultiWaterBlock;
import net.mcreator.bonk.block.MultiOreBlock;
import net.mcreator.bonk.block.MilkyounerdBlock;
import net.mcreator.bonk.block.ItemSyncerBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block NEON_BLOCK = register(new NeonBlockBlock());
	public static final Block PIZZA_PLANT = register(new PizzaPlantBlock());
	public static final Block MULTI_WATER = register(new MultiWaterBlock());
	public static final Block MULTI_ORE = register(new MultiOreBlock());
	public static final Block MULTIBLOCK = register(new MultiblockBlock());
	public static final Block MILKYOUNERD = register(new MilkyounerdBlock());
	public static final Block NAME_CHANGER = register(new NameChangerBlock());
	public static final Block ITEM_SYNCER = register(new ItemSyncerBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			NeonBlockBlock.registerRenderLayer();
			PizzaPlantBlock.registerRenderLayer();
		}
	}
}
