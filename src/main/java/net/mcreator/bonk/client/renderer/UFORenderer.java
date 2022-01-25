package net.mcreator.bonk.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.bonk.entity.UFOEntity;
import net.mcreator.bonk.client.model.Modelcustom_model;

public class UFORenderer extends MobRenderer<UFOEntity, Modelcustom_model<UFOEntity>> {
	public UFORenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(UFOEntity entity) {
		return new ResourceLocation("bonk:textures/base.png");
	}
}
