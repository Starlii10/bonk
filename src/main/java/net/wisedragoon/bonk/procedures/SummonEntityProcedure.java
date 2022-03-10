package net.wisedragoon.bonk.procedures;

import net.wisedragoon.bonk.init.BonkModEntities;
import net.wisedragoon.bonk.entity.XPEntity;
import net.wisedragoon.bonk.entity.UltimateBeanEntity;
import net.wisedragoon.bonk.entity.NyooommmEntity;
import net.wisedragoon.bonk.entity.BonkerEntity;
import net.wisedragoon.bonk.entity.BonkerBuddyEntity;
import net.wisedragoon.bonk.entity.BeanEntity;
import net.wisedragoon.bonk.entity.AntiBeanEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SummonEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Bean")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BeanEntity(BonkModEntities.BEAN, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Nyoom")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new NyooommmEntity(BonkModEntities.NYOOOMMM, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("XP")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new XPEntity(BonkModEntities.XP, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Bonker")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BonkerEntity(BonkModEntities.BONKER, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Bonker Buddy")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new BonkerBuddyEntity(BonkModEntities.BONKER_BUDDY, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Anti-Bean")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new AntiBeanEntity(BonkModEntities.ANTI_BEAN, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((guistate.containsKey("text:Summon") ? ((EditBox) guistate.get("text:Summon")).getValue() : "").equals("Ultimate Bean")) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new UltimateBeanEntity(BonkModEntities.ULTIMATE_BEAN, _level);
				entityToSpawn.moveTo(x, (y + 1), z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
							null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
