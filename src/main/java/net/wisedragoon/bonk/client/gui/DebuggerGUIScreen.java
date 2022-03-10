
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.DebuggerGUIMenu;
import net.wisedragoon.bonk.network.DebuggerGUIButtonMessage;
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

public class DebuggerGUIScreen extends AbstractContainerScreen<DebuggerGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public DebuggerGUIScreen(DebuggerGUIMenu container, Inventory inventory, Component text) {
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

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/debugger_gui.png");

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
		this.font.draw(poseStack, "Debug Options", 172, 6, -12829636);
		this.font.draw(poseStack, "Bonk version 1.0", 311, 186, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 59, this.topPos + 51, 72, 20, new TextComponent("Variables"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(0, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 145, this.topPos + 51, 46, 20, new TextComponent("GUIs"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(1, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 221, this.topPos + 51, 46, 20, new TextComponent("Help"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(2, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 284, this.topPos + 51, 67, 20, new TextComponent("Entities"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(3, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 41, this.topPos + 78, 88, 20, new TextComponent("Advancements"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(4, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 334, this.topPos + 159, 51, 20, new TextComponent("About"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(5, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 145, this.topPos + 78, 51, 20, new TextComponent("Items"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(6, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 181, this.topPos + 150, 51, 20, new TextComponent("Close"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(7, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 217, this.topPos + 78, 51, 20, new TextComponent("Crash"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(8, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 284, this.topPos + 78, 66, 20, new TextComponent("Other Mods"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new DebuggerGUIButtonMessage(9, x, y, z));
				DebuggerGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
	}
}
