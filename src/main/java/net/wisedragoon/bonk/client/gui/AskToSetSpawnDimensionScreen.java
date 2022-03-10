
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.AskToSetSpawnDimensionMenu;
import net.wisedragoon.bonk.network.BonkModVariables;
import net.wisedragoon.bonk.network.AskToSetSpawnDimensionButtonMessage;
import net.wisedragoon.bonk.BonkMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AskToSetSpawnDimensionScreen extends AbstractContainerScreen<AskToSetSpawnDimensionMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox dontaskmeagain;

	public AskToSetSpawnDimensionScreen(AskToSetSpawnDimensionMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 337;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/ask_to_set_spawn_dimension.png");

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
		this.font.draw(poseStack, "Would you like to set this dimension as your spawn dimension?", 10, 11, -12829636);
		this.font.draw(poseStack, "(Your current spawn dimension is " + (BonkModVariables.MapVariables.get(world).spawndimension) + ".)", 26, 25,
				-12829636);
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
		dontaskmeagain = new Checkbox(this.leftPos + 100, this.topPos + 112, 150, 20, new TextComponent("Don't ask me again"), false);
		AskToSetSpawnDimensionMenu.guistate.put("checkbox:dontaskmeagain", dontaskmeagain);
		this.addRenderableWidget(dontaskmeagain);
		this.addRenderableWidget(new Button(this.leftPos + 100, this.topPos + 69, 40, 20, new TextComponent("Yes"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new AskToSetSpawnDimensionButtonMessage(0, x, y, z));
				AskToSetSpawnDimensionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 183, this.topPos + 69, 35, 20, new TextComponent("No"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new AskToSetSpawnDimensionButtonMessage(1, x, y, z));
				AskToSetSpawnDimensionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
