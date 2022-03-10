package net.wisedragoon.bonk.client.renderer;

import net.wisedragoon.bonk.entity.XPEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class XPRenderer extends HumanoidMobRenderer<XPEntity, HumanoidModel<XPEntity>> {
	public XPRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<XPEntity, HumanoidModel<XPEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("bonk:textures/bonkskin.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(XPEntity entity) {
		return new ResourceLocation("bonk:textures/bonkskin.png");
	}
}
