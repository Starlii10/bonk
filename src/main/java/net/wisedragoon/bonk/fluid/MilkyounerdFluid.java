
package net.wisedragoon.bonk.fluid;

import net.wisedragoon.bonk.init.BonkModItems;
import net.wisedragoon.bonk.init.BonkModFluids;
import net.wisedragoon.bonk.init.BonkModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

public abstract class MilkyounerdFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> BonkModFluids.MILKYOUNERD,
			() -> BonkModFluids.FLOWING_MILKYOUNERD,
			FluidAttributes.builder(new ResourceLocation("bonk:blocks/milkyounerd"), new ResourceLocation("bonk:blocks/milkyounerd"))

	).explosionResistance(100f)

			.bucket(() -> BonkModItems.MILKYOUNERD_BUCKET).block(() -> (LiquidBlock) BonkModBlocks.MILKYOUNERD);

	private MilkyounerdFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MilkyounerdFluid {
		public Source() {
			super();
			setRegistryName("milkyounerd");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MilkyounerdFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_milkyounerd");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
