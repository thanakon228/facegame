package uncelface.packet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Hashtable;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandlerBase implements IPacketHandler {

    private Map<String, AbstractPacket> map = new Hashtable<String, AbstractPacket>();


    public PacketHandlerBase() {


    	map.put(Packet_SyncPlayerData.packetName, new Packet_SyncPlayerData());
//    	map.put(Openguipacket.packetName, new Openguipacket());
//    	map.put(Umbrellapacket.packetName, new Umbrellapacket());
//    	map.put(UpgradeNewPacket.packetName, new UpgradeNewPacket());
//    	map.put(Statuspacket.packetName, new Statuspacket());
//    	
//    	
//    	//pet packet
//    	map.put(packgui.packetName, new packgui());
//    	map.put(packetdata.packetName, new packetdata());


    }

    @Override
    public void onPacketData(INetworkManager manager,
                             Packet250CustomPayload packet, Player player) {
        map.get(packet.channel).process(packet.data!=null?new DataInputStream(new ByteArrayInputStream(packet.data)):null,(EntityPlayer) player);

    }

}
