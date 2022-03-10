
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wisedragoon.bonk.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BonkModTabs {
	public static CreativeModeTab TAB_BONK_TAB;

	public static void load() {
		TAB_BONK_TAB = new CreativeModeTab("tabbonk_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BonkModBlocks.MULTIBLOCK);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
