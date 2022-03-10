package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.network.BonkModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SetItemNameProcedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		((BonkModVariables.MapVariables.get(world).iteminmainhand)).setHoverName(
				new TextComponent((guistate.containsKey("text:DisplayName") ? ((EditBox) guistate.get("text:DisplayName")).getValue() : "")));
	}
}
