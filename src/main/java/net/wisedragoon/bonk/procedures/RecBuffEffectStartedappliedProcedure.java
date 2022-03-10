package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.init.BonkModItems;
import net.wisedragoon.bonk.init.BonkModEnchantments;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class RecBuffEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack previousheaditem = ItemStack.EMPTY;
		previousheaditem = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
		if (entity instanceof LivingEntity _entity) {
			if (_entity instanceof Player _player)
				_player.getInventory().armor.set(0, new ItemStack(BonkModItems.BEANIER_ARMOR_HELMET));
			else
				_entity.setItemSlot(EquipmentSlot.FEET, new ItemStack(BonkModItems.BEANIER_ARMOR_HELMET));
			if (_entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.getInventory().setChanged();
		}
		((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))
				.enchant(BonkModEnchantments.ANTI_DIE, 1);
		MilkProjectileHitsBlockProcedure.execute(world, x, y, z);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bonk:recroom")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("bonk:recroom")), SoundSource.NEUTRAL, 1, 1,
						false);
			}
		}
		if (entity instanceof LivingEntity _entity) {
			if (_entity instanceof Player _player)
				_player.getInventory().armor.set(0, (previousheaditem));
			else
				_entity.setItemSlot(EquipmentSlot.FEET, (previousheaditem));
			if (_entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.getInventory().setChanged();
		}
	}
}
