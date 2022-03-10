package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.init.BonkModItems;
import net.wisedragoon.bonk.init.BonkModEnchantments;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class BeanRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (itemstack.getItem() == BonkModItems.BEAN_SWORD
				&& EnchantmentHelper.getItemEnchantmentLevel(BonkModEnchantments.TRANSFORM, itemstack) != 0) {
			if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("The Bean was transformed into an Ultimate Bean!"), (true));
			BeanItIsStruckByLightningProcedure.execute(world, x, y, z, entity);
		}
	}
}
