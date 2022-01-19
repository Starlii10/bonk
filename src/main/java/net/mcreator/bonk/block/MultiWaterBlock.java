
package net.mcreator.bonk.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.bonk.init.BonkModFluids;

public class MultiWaterBlock extends LiquidBlock {
	public MultiWaterBlock() {
		super(BonkModFluids.MULTI_WATER, BlockBehaviour.Properties.of(Material.WATER).strength(100f).hasPostProcess((bs, br, bp) -> true)
				.emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 15));
		setRegistryName("multi_water");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
