package net.wisedragoon.bonk.procedures;

import net.minecraftforge.fmllegacy.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import java.util.HashMap;

public class RecRooooooooooooooooomCommandExecutedProcedure {
	public static void execute(LevelAccessor world, HashMap cmdparams) {
		if (cmdparams == null)
			return;
		if (!world.isClientSide()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.broadcastMessage(new TextComponent(((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "")
								+ " just got Rec Rooooooooooooomed! They must Rec Rooooooooooooom someone else to be un-Rec Rooooooooooooomed!")),
								ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
