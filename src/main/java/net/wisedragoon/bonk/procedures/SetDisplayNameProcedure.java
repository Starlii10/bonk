package net.wisedragoon.bonk.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SetDisplayNameProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		entity.setCustomName(
				new TextComponent((guistate.containsKey("text:DisplayName") ? ((EditBox) guistate.get("text:DisplayName")).getValue() : "")));
	}
}
