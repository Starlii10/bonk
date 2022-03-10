
package net.wisedragoon.bonk.item;

import net.wisedragoon.bonk.procedures.IcyBoatSpawnerRightClickedOnBlockProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionResult;

public class IcyBoatSpawnerItem extends Item {
	public IcyBoatSpawnerItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).rarity(Rarity.COMMON));
		setRegistryName("icy_boat_spawner");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0.2F;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		IcyBoatSpawnerRightClickedOnBlockProcedure.execute(context.getLevel(), context.getPlayer());
		return retval;
	}
}
