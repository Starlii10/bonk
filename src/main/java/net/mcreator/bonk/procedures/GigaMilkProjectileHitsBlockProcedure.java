package net.mcreator.bonk.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.bonk.init.BonkModMobEffects;
import net.mcreator.bonk.entity.YeeterMilkEntity;
import net.mcreator.bonk.entity.UpgradedMilkEntity;
import net.mcreator.bonk.entity.SplitterMilkEntity;
import net.mcreator.bonk.entity.RichMilkEntity;
import net.mcreator.bonk.entity.MinerMilkEntity;
import net.mcreator.bonk.entity.MilkEntity;
import net.mcreator.bonk.entity.BeanyMilkEntity;
import net.mcreator.bonk.entity.AmbushMilkEntity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class GigaMilkProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(BonkModMobEffects.REC_BUFF, 1080000, 1));
			}
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			MilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			UpgradedMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			BeanyMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			SplitterMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			YeeterMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			RichMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			AmbushMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
			MinerMilkEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 5);
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 60, Explosion.BlockInteraction.BREAK);
	}
}
