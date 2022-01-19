package net.mcreator.bonk.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.bonk.entity.UpgradedMilkEntity;

public class SplitterMilkProjectileHitsBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
				UpgradedMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
			}
		}
	}
}
