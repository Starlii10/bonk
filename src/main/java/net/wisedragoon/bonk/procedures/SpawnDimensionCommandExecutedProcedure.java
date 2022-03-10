package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.network.BonkModVariables;
import net.wisedragoon.bonk.init.BonkModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import java.util.HashMap;

public class SpawnDimensionCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BonkModGameRules.BONKDEBUGCOMMANDS)) {
			if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("overworld")) {
				if ((BonkModVariables.MapVariables.get(world).spawndimension).equals("overworld")) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("Your spawn dimension is already Overworld!"), (false));
				} else {
					BonkModVariables.MapVariables.get(world).spawndimension = "overworld";
					BonkModVariables.MapVariables.get(world).syncData(world);
				}
			} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("nether")) {
				if ((BonkModVariables.MapVariables.get(world).spawndimension).equals("nether")) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("Your spawn dimension is already Nether!"), (false));
				} else {
					BonkModVariables.MapVariables.get(world).spawndimension = "nether";
					BonkModVariables.MapVariables.get(world).syncData(world);
				}
			} else {
				if ((BonkModVariables.MapVariables.get(world).spawndimension).equals("end")) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent("Your spawn dimension is already End!"), (false));
				} else {
					BonkModVariables.MapVariables.get(world).spawndimension = "end";
					BonkModVariables.MapVariables.get(world).syncData(world);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Bonk Gameplay Commands is disabled. Please enable them to use this command."),
						(false));
		}
	}
}
