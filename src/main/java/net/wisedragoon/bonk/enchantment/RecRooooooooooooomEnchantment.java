
package net.wisedragoon.bonk.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class RecRooooooooooooomEnchantment extends Enchantment {
	public RecRooooooooooooomEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean isCurse() {
		return true;
	}
}
