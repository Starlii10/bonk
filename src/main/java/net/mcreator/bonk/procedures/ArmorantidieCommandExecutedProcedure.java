package net.mcreator.bonk.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.bonk.init.BonkModEnchantments;

public class ArmorantidieCommandExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))
				.enchant(BonkModEnchantments.ANTI_DIE, 1);
		((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY))
				.enchant(BonkModEnchantments.ANTI_DIE, 1);
		((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))
				.enchant(BonkModEnchantments.ANTI_DIE, 1);
		((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))
				.enchant(BonkModEnchantments.ANTI_DIE, 1);
	}
}
