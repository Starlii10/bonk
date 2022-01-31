package net.mcreator.bonk.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.bonk.entity.LaserGunEntity;
import net.mcreator.bonk.BonkMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShootAsUFOProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		Player entity = event.getPlayer();
		if (event.getHand() != entity.getUsedItemHand())
			return;
		execute(event, entity);
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (("" + entity.getVehicle()).equals("null")) {
			BonkMod.LOGGER.info(
					"Bonk Mod: Null detected in procedure \"ShootAsUFO\" in net.minecraft.world.entity.Entity.getVehicle(), cancelled procedure to prevent crash");
		} else {
			if (EntityTypeTags.getAllTags().getTagOrEmpty(new ResourceLocation("bonk:tagufo")).contains((entity.getVehicle()).getType())) {
				if ((entity.getVehicle())instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
					LaserGunEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 1, 5, 1);
				}
			}
		}
	}
}
