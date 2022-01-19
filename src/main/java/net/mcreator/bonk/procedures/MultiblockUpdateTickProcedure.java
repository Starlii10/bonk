package net.mcreator.bonk.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Direction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

public class MultiblockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Direction.getRandom(new Random()) == Direction.DOWN) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""),
								_level.getServer(), null).withSuppressedOutput(),
						"summon minecraft:item ~ ~ ~ {Item:{id:\"minecraft:netherite_ingot\",Count:1}}");
		}
	}
}
