
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.OtherModsMenu;
import net.wisedragoon.bonk.network.OtherModsButtonMessage;
import net.wisedragoon.bonk.BonkMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class OtherModsScreen extends AbstractContainerScreen<OtherModsMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OtherModsScreen(OtherModsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 200;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/other_mods.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("bonk:textures/rainbow-bucket.png"));
		this.blit(ms, this.leftPos + 28, this.topPos + 24, 0, 0, 32, 32, 32, 32);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Other Mods", 172, 9, -12829636);
		this.font.draw(poseStack, "More Color", 10, 9, -12829636);
		this.font.draw(poseStack, "Adds a lot of colorful stairs, slabs, and new recipes to make", 64, 24, -12829636);
		this.font.draw(poseStack, "building just a little bit brighter.", 64, 39, -12829636);
		this.font.draw(poseStack, "GitHub: https://github.com/WiseDragoon5374/more-color", 28, 61, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 145, this.topPos + 151, 108, 20, new TextComponent("Back to Debugger"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new OtherModsButtonMessage(0, x, y, z));
				OtherModsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
