
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.NameChangerGUIMenu;
import net.wisedragoon.bonk.network.NameChangerGUIButtonMessage;
import net.wisedragoon.bonk.BonkMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class NameChangerGUIScreen extends AbstractContainerScreen<NameChangerGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox DisplayName;

	public NameChangerGUIScreen(NameChangerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 264;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/name_changer_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		DisplayName.render(ms, mouseX, mouseY, partialTicks);
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
		if (DisplayName.isFocused())
			return DisplayName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		DisplayName.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Change your display name!", 68, 12, -12829636);
		this.font.draw(poseStack, "Note: Item uses the item in your main hand.", 20, 24, -12829636);
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
		DisplayName = new EditBox(this.font, this.leftPos + 74, this.topPos + 56, 120, 20, new TextComponent("Default Name")) {
			{
				setSuggestion("Default Name");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Default Name");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Default Name");
				else
					setSuggestion(null);
			}
		};
		NameChangerGUIMenu.guistate.put("text:DisplayName", DisplayName);
		DisplayName.setMaxLength(32767);
		this.addWidget(this.DisplayName);
		this.addRenderableWidget(new Button(this.leftPos + 75, this.topPos + 88, 119, 20, new TextComponent("Change Player Name"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 81, this.topPos + 112, 108, 20, new TextComponent("Change Item Name"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new NameChangerGUIButtonMessage(1, x, y, z));
				NameChangerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 105, this.topPos + 136, 56, 20, new TextComponent("Cancel"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new NameChangerGUIButtonMessage(2, x, y, z));
				NameChangerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
