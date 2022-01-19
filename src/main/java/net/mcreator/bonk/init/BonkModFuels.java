
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class BonkModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == BonkModBlocks.MULTIBLOCK.asItem())
			event.setBurnTime(1000000000);
	}
}
