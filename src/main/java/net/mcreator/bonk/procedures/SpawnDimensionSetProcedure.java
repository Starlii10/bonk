package net.mcreator.bonk.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.bonk.network.BonkModVariables;

public class SpawnDimensionSetProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			BonkModVariables.MapVariables.get(world).spawndimension = "overworld";
			BonkModVariables.MapVariables.get(world).syncData(world);
		} else if ((entity.level.dimension()) == (Level.NETHER)) {
			BonkModVariables.MapVariables.get(world).spawndimension = "nether";
			BonkModVariables.MapVariables.get(world).syncData(world);
		} else {
			BonkModVariables.MapVariables.get(world).spawndimension = "end";
			BonkModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
