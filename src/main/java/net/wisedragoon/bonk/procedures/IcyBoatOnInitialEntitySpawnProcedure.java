package net.wisedragoon.bonk.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import java.util.Collections;

public class IcyBoatOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		while ((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.WATER
				|| (world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.WATER) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (entity.getY() + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer) {
					_serverPlayer.connection.teleport(x, (entity.getY() + 1), z, _ent.getYRot(), _ent.getXRot(), Collections.emptySet());
				}
			}
		}
	}
}
