
package net.mcreator.bonk.fluid;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

import net.mcreator.bonk.init.BonkModItems;
import net.mcreator.bonk.init.BonkModFluids;
import net.mcreator.bonk.init.BonkModBlocks;

public abstract class MultiWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> BonkModFluids.MULTI_WATER,
			() -> BonkModFluids.FLOWING_MULTI_WATER,
			FluidAttributes.builder(new ResourceLocation("bonk:blocks/multiblocc"), new ResourceLocation("bonk:blocks/multiblocc")).luminosity(60)

					.sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bonk:recroom")))).explosionResistance(100f).canMultiply()
							.tickRate(1)

							.bucket(() -> BonkModItems.MULTI_WATER_BUCKET).block(() -> (LiquidBlock) BonkModBlocks.MULTI_WATER);

	private MultiWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.RAIN;
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(25);
	}

	public static class Source extends MultiWaterFluid {
		public Source() {
			super();
			setRegistryName("multi_water");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MultiWaterFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_multi_water");
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
