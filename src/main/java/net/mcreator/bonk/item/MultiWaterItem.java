
package net.mcreator.bonk.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.bonk.init.BonkModTabs;
import net.mcreator.bonk.init.BonkModFluids;

public class MultiWaterItem extends BucketItem {
	public MultiWaterItem() {
		super(() -> BonkModFluids.MULTI_WATER,
				new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(BonkModTabs.TAB_BONK_TAB));
		setRegistryName("multi_water_bucket");
	}
}
