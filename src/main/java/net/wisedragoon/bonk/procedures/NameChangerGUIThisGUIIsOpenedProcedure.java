package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.network.BonkModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class NameChangerGUIThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		BonkModVariables.MapVariables
				.get(world).iteminmainhand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		BonkModVariables.MapVariables.get(world).syncData(world);
	}
}
