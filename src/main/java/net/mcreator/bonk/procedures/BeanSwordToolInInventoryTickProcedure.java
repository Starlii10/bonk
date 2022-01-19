package net.mcreator.bonk.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import net.mcreator.bonk.init.BonkModEnchantments;

public class BeanSwordToolInInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (!(EnchantmentHelper.getItemEnchantmentLevel(BonkModEnchantments.BEANY, itemstack) != 0)) {
			(itemstack).enchant(BonkModEnchantments.BEANY, 5);
		}
	}
}
