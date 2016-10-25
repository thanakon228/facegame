package uncelface.packet;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Random;




import uncelface.player.StoreData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;











public class Packet_SyncPlayerData
extends AbstractPacket
{
	public static NBTTagCompound data;
	public static Random rand = new Random();
	public static int entityID;

			 public static final String packetName = "chanel_sync";

	public Packet_SyncPlayerData(EntityPlayer player)
	{
		data = new NBTTagCompound();
		StoreData.get(player).saveNBTData(data);
		}

	
	
	public Packet_SyncPlayerData() {
	}

	

	
	@Override
	public String getChannel() {
		// TODO Auto-generated method stub
		return packetName;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		writeNBTTagCompound(data, out);
	}

	@Override
	public void process(DataInputStream in, EntityPlayer player) {
		try {
			data = readNBTTagCompound(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StoreData.get(player).loadNBTData(data);
	}
}

/*
 * Location:
 * C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland
 * \packet\Packet_SyncPlayerData.class Java compiler version: 6 (50.0) JD-Core
 * Version: 0.7.1
 */