
package net.wisedragoon.bonk.client.gui;

import net.wisedragoon.bonk.world.inventory.MultimenuMenu;
import net.wisedragoon.bonk.network.MultimenuButtonMessage;
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

public class MultimenuScreen extends AbstractContainerScreen<MultimenuMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Summon;

	public MultimenuScreen(MultimenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 317;
		this.imageHeight = 219;
	}

	private static final ResourceLocation texture = new ResourceLocation("bonk:textures/multimenu.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		Summon.render(ms, mouseX, mouseY, partialTicks);
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
		if (Summon.isFocused())
			return Summon.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Summon.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "What custom entity would you like to summon?", 49, 27, -12829636);
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
		Summon = new EditBox(this.font, this.leftPos + 101, this.topPos + 46, 120, 20, new TextComponent("entity")) {
			{
				setSuggestion("entity");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("entity");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("entity");
				else
					setSuggestion(null);
			}
		};
		MultimenuMenu.guistate.put("text:Summon", Summon);
		Summon.setMaxLength(32767);
		this.addWidget(this.Summon);
		this.addRenderableWidget(new Button(this.leftPos + 115, this.topPos + 74, 93, 20, new TextComponent("Summon Entity"), e -> {
			if (true) {
				BonkMod.PACKET_HANDLER.sendToServer(new MultimenuButtonMessage(0, x, y, z));
				MultimenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
