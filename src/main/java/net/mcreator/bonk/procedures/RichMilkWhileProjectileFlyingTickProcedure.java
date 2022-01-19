package net.mcreator.bonk.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import java.util.Random;

public class RichMilkWhileProjectileFlyingTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Direction.getRandom(new Random()) == Direction.DOWN) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"summon minecraft:item ~ ~ ~ {Item:{id:\"minecraft:netherite_block\",Count:1}}");
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"summon minecraft:item ~ ~ ~ {Item:{id:\"minecraft:diamond_block\",Count:1}}");
			}
		}
	}
}
