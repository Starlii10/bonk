package net.wisedragoon.bonk.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class XPEntityDiesProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!("" + sourceentity).equals("null")) {
			if (sourceentity instanceof Player _player)
				_player.giveExperienceLevels(32767);
		}
	}
}
