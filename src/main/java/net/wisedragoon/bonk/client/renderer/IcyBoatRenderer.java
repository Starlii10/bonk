package net.wisedragoon.bonk.client.renderer;

import net.wisedragoon.bonk.entity.IcyBoatEntity;
import net.wisedragoon.bonk.client.model.Modelicy_boat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class IcyBoatRenderer extends MobRenderer<IcyBoatEntity, Modelicy_boat<IcyBoatEntity>> {
	public IcyBoatRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelicy_boat(context.bakeLayer(Modelicy_boat.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IcyBoatEntity entity) {
		return new ResourceLocation("bonk:textures/icyboatbase.png");
	}
}
