package net.mcreator.bonk.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.bonk.init.BonkModGameRules;
import net.mcreator.bonk.init.BonkModEntities;
import net.mcreator.bonk.entity.BeanEntity;

public class BeansCommandExecutedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BonkModGameRules.BONKGAMEPLAYCOMMNADS)) {
			for (int index0 = 0; index0 < (int) (100); index0++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new BeanEntity(BonkModEntities.BEAN, _level);
					entityToSpawn.moveTo(x, y, z, 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED,
								null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Bonk Gameplay Commands is disabled. Please enable them to use this command."),
						(false));
		}
	}
}
