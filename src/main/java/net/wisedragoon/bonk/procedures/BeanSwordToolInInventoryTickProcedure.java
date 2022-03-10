package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.init.BonkModEnchantments;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class BeanSwordToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (!(EnchantmentHelper.getItemEnchantmentLevel(BonkModEnchantments.BEANY, itemstack) != 0)) {
			(itemstack).enchant(BonkModEnchantments.BEANY, 5);
		}
	}
}
