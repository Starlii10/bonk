package net.mcreator.bonk.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.bonk.init.BonkModFluids;
import net.mcreator.bonk.init.BonkModBlocks;

public class MilkContainerNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(new BlockPos((int) x, (int) (y + 1), (int) z)).createLegacyBlock()).getBlock() == BonkModBlocks.MILKYOUNERD) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = 1000;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).ifPresent(
							capability -> capability.fill(new FluidStack(BonkModFluids.MILKYOUNERD, _amount), IFluidHandler.FluidAction.EXECUTE));
			}
		}
	}
}
