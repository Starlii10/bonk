
package net.mcreator.bonk.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.mcreator.bonk.init.BonkModTabs;

public class PizzaItem extends Item {
	public PizzaItem() {
		super(new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(20).saturationMod(4.8f)

						.build()));
		setRegistryName("pizza");
	}
}
