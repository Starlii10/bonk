
package net.wisedragoon.bonk.network;

import net.wisedragoon.bonk.world.inventory.GUIsMenu;
import net.wisedragoon.bonk.procedures.SpawnDimensionSetToOWProcedure;
import net.wisedragoon.bonk.procedures.OpenNameChangerGUIProcedure;
import net.wisedragoon.bonk.procedures.OpenMultimenuProcedure;
import net.wisedragoon.bonk.procedures.BackToDebuggerProcedure;
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
public class GUIsButtonMessage {
	private final int buttonID, x, y, z;

	public GUIsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GUIsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GUIsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GUIsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = GUIsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenMultimenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SpawnDimensionSetToOWProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenNameChangerGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BackToDebuggerProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BonkMod.addNetworkMessage(GUIsButtonMessage.class, GUIsButtonMessage::buffer, GUIsButtonMessage::new, GUIsButtonMessage::handler);
	}
}
