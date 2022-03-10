
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.VariablesMenu;
import net.wisedragoon.bonk.network.VariablesButtonMessage;
import net.wisedragoon.bonk.network.BonkModVariables;
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

public class VariablesScreen extends AbstractContainerScreen<VariablesMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public VariablesScreen(VariablesMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/variables.png");

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
		this.font.draw(poseStack, "Variables", 174, 5, -12829636);
		this.font.draw(poseStack, "spawndimension: " + (BonkModVariables.MapVariables.get(world).spawndimension) + "", 111, 24, -12829636);
		this.font.draw(poseStack, "isdamachecked: " + (BonkModVariables.MapVariables.get(world).isdamachecked) + "", 111, 42, -12829636);
		this.font.draw(poseStack, "NOTE: This does not show blockstate or itemstack variables.", 39, 168, -12829636);
		this.font.draw(poseStack, "Use other GUIs to display those.", 114, 180, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 147, this.topPos + 141, 108, 20, new TextComponent("Back to Debugger"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new VariablesButtonMessage(0, x, y, z));
				VariablesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
