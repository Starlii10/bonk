
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.wisedragoon.bonk.block.PizzaPlantBlock;
import net.wisedragoon.bonk.block.NeonBlockBlock;
import net.wisedragoon.bonk.block.NameChangerBlock;
import net.wisedragoon.bonk.block.MultiblockBlock;
import net.wisedragoon.bonk.block.MultiWaterBlock;
import net.wisedragoon.bonk.block.MultiOreBlock;
import net.wisedragoon.bonk.block.MineBlock;
import net.wisedragoon.bonk.block.MilkyounerdBlock;
import net.wisedragoon.bonk.block.EBlock;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

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
	public static final Block E = register(new EBlock());
	public static final Block MINE = register(new MineBlock());

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
			EBlock.registerRenderLayer();
		}
	}
}
