package net.mcreator.bonk.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.bonk.init.BonkModGameRules;
import net.mcreator.bonk.init.BonkModEnchantments;

public class ArmorantidieCommandExecutedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BonkModGameRules.BONKDEBUGCOMMANDS)) {
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))
					.enchant(BonkModEnchantments.ANTI_DIE, 1);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY))
					.enchant(BonkModEnchantments.ANTI_DIE, 1);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY))
					.enchant(BonkModEnchantments.ANTI_DIE, 1);
			((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY))
					.enchant(BonkModEnchantments.ANTI_DIE, 1);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Bonk Gameplay Commands is disabled. Please enable them to use this command."),
						(false));
		}
	}
}
