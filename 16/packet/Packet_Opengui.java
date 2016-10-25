package uncelface.packet;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Random;




import uncelface.ModStart;
import net.minecraft.entity.player.EntityPlayer;







public class Packet_Opengui
extends AbstractPacket
{
	public static int GuiID;
	public static Random rand = new Random();

		 public static final String packetName = "chanel_opengui";

	public Packet_Opengui(int guiID)
	{
		GuiID = guiID;
		}

	
	public Packet_Opengui() {
		this(0);
		}

	
	@Override
	public String getChannel() {
		// TODO Auto-generated method stub
		return packetName;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(GuiID);

	}

	@Override
	public void process(DataInputStream in, EntityPlayer player) {
		try {
			GuiID = in.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.openGui(ModStart.instance, Packet_Opengui.GuiID,
				player.worldObj, (int) player.posX, (int) player.posY,
				(int) player.posZ);

	}
}

/*
 * Location:
 * C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland
 * \packet\Packet_Opengui.class Java compiler version: 6 (50.0) JD-Core Version:
 * 0.7.1
 */