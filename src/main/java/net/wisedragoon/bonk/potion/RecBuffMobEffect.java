
package net.wisedragoon.bonk.potion;

import net.wisedragoon.bonk.procedures.RecBuffOnEffectActiveTickProcedure;
import net.wisedragoon.bonk.procedures.RecBuffEffectStartedappliedProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RecBuffMobEffect extends MobEffect {
	public RecBuffMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26368);
		setRegistryName("rec_buff");
	}

	@Override
	public String getDescriptionId() {
		return "effect.bonk.rec_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		RecBuffEffectStartedappliedProcedure.execute(world, x, y, z, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		RecBuffOnEffectActiveTickProcedure.execute(world, x, y, z, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
