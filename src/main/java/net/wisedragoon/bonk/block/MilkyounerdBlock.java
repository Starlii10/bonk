
package net.wisedragoon.bonk.block;

import net.wisedragoon.bonk.init.BonkModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class MilkyounerdBlock extends LiquidBlock {
	public MilkyounerdBlock() {
		super(BonkModFluids.MILKYOUNERD, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("milkyounerd");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
