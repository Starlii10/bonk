
package net.mcreator.bonk.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

import net.mcreator.bonk.init.BonkModFluids;

public class MilkyounerdItem extends BucketItem {
	public MilkyounerdItem() {
		super(() -> BonkModFluids.MILKYOUNERD,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
		setRegistryName("milkyounerd_bucket");
	}
}
