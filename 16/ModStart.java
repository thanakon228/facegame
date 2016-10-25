package uncelface;

import uncelface.client.Packet_Umbrella;
import uncelface.command.resetFace;
import uncelface.packet.Packet_Opengui;
import uncelface.packet.Packet_SyncPlayerData;
import uncelface.player.ServerPlayer;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = "uncelface", name = "uncelface", version = "uncelface")
@NetworkMod(clientSideRequired = true,
serverSideRequired = true,
channels = {
		Packet_Umbrella.packetName,
		Packet_Opengui.packetName,
		Packet_SyncPlayerData.packetName })


public class ModStart {
	@SidedProxy(serverSide = "uncelface.ServerProxy", clientSide = "uncelface.client.ClientProxy")
	public static ServerProxy sproxy;
	@Mod.Instance("uncelface")
	public static ModStart instance;
	private static int id = 0;
	public static final int guiPlayerInvID = id++;
	public static final int guiFaceID = id++;

	public ModStart() {
	}

	@Mod.EventHandler
	public void Start(FMLInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new ServerPlayer());
		NetworkRegistry.instance().registerGuiHandler(this, new ServerProxy());
		sproxy.reg();
	}

	@Mod.EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager manager = (ServerCommandManager) command;
		manager.registerCommand(new resetFace());
	}
}
