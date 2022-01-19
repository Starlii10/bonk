
package net.mcreator.bonk.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.bonk.init.BonkModFluids;

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
