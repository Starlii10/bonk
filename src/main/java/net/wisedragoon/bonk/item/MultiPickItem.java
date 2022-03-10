
package net.wisedragoon.bonk.item;

import net.wisedragoon.bonk.procedures.MultiPickLivingEntityIsHitWithToolProcedure;
import net.wisedragoon.bonk.init.BonkModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class MultiPickItem extends PickaxeItem {
	public MultiPickItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 128000f;
			}

			public float getAttackDamageBonus() {
				return 127998f;
			}

			public int getLevel() {
				return 128000;
			}

			public int getEnchantmentValue() {
				return 128000;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.OAK_PLANKS), new ItemStack(Blocks.SPRUCE_PLANKS), new ItemStack(Blocks.BIRCH_PLANKS),
						new ItemStack(Blocks.JUNGLE_PLANKS), new ItemStack(Blocks.ACACIA_PLANKS), new ItemStack(Blocks.DARK_OAK_PLANKS),
						new ItemStack(Blocks.CRIMSON_PLANKS), new ItemStack(Blocks.WARPED_PLANKS), new ItemStack(Blocks.COBBLESTONE),
						new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.GOLD_BLOCK),
						new ItemStack(Items.GOLD_INGOT), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Items.DIAMOND),
						new ItemStack(Blocks.NETHERITE_BLOCK), new ItemStack(Items.NETHERITE_INGOT), new ItemStack(Items.NETHERITE_SCRAP),
						new ItemStack(BonkModItems.MULTI));
			}
		}, 1, 96f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant());
		setRegistryName("multi_pick");
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Level world = entity.level;

		MultiPickLivingEntityIsHitWithToolProcedure.execute(world, x, y, z, entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Has properties of every tool, and is outlandishly OP."));
		list.add(new TextComponent("Don't try to hit something without Anti-Die, or... Well"));
		list.add(new TextComponent("it's complicated."));
	}
}
