
package net.wisedragoon.bonk.network;

import net.wisedragoon.bonk.world.inventory.DebuggerGUIMenu;
import net.wisedragoon.bonk.procedures.OpenVariablesProcedure;
import net.wisedragoon.bonk.procedures.OpenOtherModsProcedure;
import net.wisedragoon.bonk.procedures.OpenHelpProcedure;
import net.wisedragoon.bonk.procedures.OpenGUIsProcedure;
import net.wisedragoon.bonk.procedures.OpenComingSoonProcedure;
import net.wisedragoon.bonk.procedures.OpenAboutProcedure;
import net.wisedragoon.bonk.procedures.CrashCommandExecutedProcedure;
import net.wisedragoon.bonk.procedures.CloseGUIProcedure;
import net.wisedragoon.bonk.BonkMod;

import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DebuggerGUIButtonMessage {
	private final int buttonID, x, y, z;

	public DebuggerGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public DebuggerGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(DebuggerGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(DebuggerGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = DebuggerGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenVariablesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenGUIsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenHelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenComingSoonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenComingSoonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenAboutProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenComingSoonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			CloseGUIProcedure.execute(entity);
		}
		if (buttonID == 8) {

			CrashCommandExecutedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			OpenOtherModsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BonkMod.addNetworkMessage(DebuggerGUIButtonMessage.class, DebuggerGUIButtonMessage::buffer, DebuggerGUIButtonMessage::new,
				DebuggerGUIButtonMessage::handler);
	}
}
