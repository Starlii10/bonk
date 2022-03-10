
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.GUIsMenu;
import net.wisedragoon.bonk.network.GUIsButtonMessage;
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

public class GUIsScreen extends AbstractContainerScreen<GUIsMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GUIsScreen(GUIsMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/gu_is.png");

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
		this.font.draw(poseStack, "GUIs", 192, 6, -12829636);
		this.font.draw(poseStack, "Note: Does not work if isdamachecked is true", 3, 60, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 165, this.topPos + 33, 72, 20, new TextComponent("Multimenu"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new GUIsButtonMessage(0, x, y, z));
				GUIsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 246, this.topPos + 51, 140, 20, new TextComponent("AskToSetSpawnDimension"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new GUIsButtonMessage(1, x, y, z));
				GUIsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 156, this.topPos + 78, 98, 20, new TextComponent("NameChangerGUI"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new GUIsButtonMessage(2, x, y, z));
				GUIsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 147, this.topPos + 159, 108, 20, new TextComponent("Back to Debugger"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new GUIsButtonMessage(3, x, y, z));
				GUIsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
