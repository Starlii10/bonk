
package net.wisedragoon.bonk.item;

import net.wisedragoon.bonk.init.BonkModTabs;
import net.wisedragoon.bonk.init.BonkModSounds;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class RecRoomFirstImpressionsItem extends RecordItem {
	public RecRoomFirstImpressionsItem() {
		super(0, BonkModSounds.REGISTRY.get(new ResourceLocation("bonk:recroom")),
				new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB).stacksTo(1).rarity(Rarity.RARE));
		setRegistryName("rec_room_first_impressions");
	}
}
