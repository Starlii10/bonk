package net.wisedragoon.bonk.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class MultiPickLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		MultiblockUpdateTickProcedure.execute(world, x, y, z);
		BeansCommandExecutedProcedure.execute(world, x, y, z, entity);
		WoodCommandExecutedProcedure.execute(world, entity);
		BeanAppleFoodEatenProcedure.execute(entity);
		HytaleButAProcedure.execute(world, x, y, z, entity);
		GigaMilkProjectileHitsBlockProcedure.execute(world, x, y, z, entity);
	}
}
