
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> BONKDEBUGCOMMANDS = GameRules.register("bonkDebugCommands", GameRules.Category.MISC,
			GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BONKGAMEPLAYCOMMNADS = GameRules.register("bonkGameplayCommnads",
			GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
