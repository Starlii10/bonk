package net.mcreator.bonk.procedures;

import net.minecraft.world.entity.Entity;

public class WoodCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null)
				_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
						"give @s minecraft:oak_log 64");
		}
	}
}
