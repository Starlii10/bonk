package net.mcreator.bonk.procedures;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.bonk.network.BonkModVariables;

import java.util.HashMap;

public class SetItemNameProcedure {
	public static void execute(HashMap guistate) {
		if (guistate == null)
			return;
		((BonkModVariables.synceditem)).setHoverName(
				new TextComponent((guistate.containsKey("text:DisplayName") ? ((EditBox) guistate.get("text:DisplayName")).getValue() : "")));
	}
}
