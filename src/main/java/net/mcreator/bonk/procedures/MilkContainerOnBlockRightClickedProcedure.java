package net.mcreator.bonk.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.bonk.init.BonkModItems;

import java.util.concurrent.atomic.AtomicInteger;

public class MilkContainerOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int drainTankSimulate(LevelAccessor level, BlockPos pos, int amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.drain(amount, IFluidHandler.FluidAction.SIMULATE).getAmount()));
				return _retval.get();
			}
		}.drainTankSimulate(world, new BlockPos((int) x, (int) y, (int) z), 1000) == 1000) {
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
				int _amount = 1000;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.drain(_amount, IFluidHandler.FluidAction.EXECUTE));
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(BonkModItems.MILK);
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
