package net.mcreator.bonk.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class LapisCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(Blocks.LAPIS_BLOCK);
			_setstack.setCount(64);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}