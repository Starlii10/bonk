
package net.wisedragoon.bonk.item;

import net.wisedragoon.bonk.procedures.BeanSwordToolInInventoryTickProcedure;
import net.wisedragoon.bonk.init.BonkModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class BeanSwordItem extends SwordItem {
	public BeanSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 100;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 98f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, 2f, new Item.Properties().tab(BonkModTabs.TAB_BONK_TAB));
		setRegistryName("bean_sword");
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		BeanSwordToolInInventoryTickProcedure.execute(itemstack);
	}
}
