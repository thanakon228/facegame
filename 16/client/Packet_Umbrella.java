 package uncelface.client;
 import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Random;

import uncelface.packet.AbstractPacket;
import uncelface.player.StoreData;
 import net.minecraft.entity.player.EntityPlayer;
 
 
 
 
 
 
 
 
 
 public class Packet_Umbrella
   extends AbstractPacket
 {
   public static int GuiID;
   public static Random rand = new Random();
	 public static final String packetName = "chanel_um";

   public Packet_Umbrella(int guiID)
   {
     GuiID = guiID;
   }
   
   public Packet_Umbrella() {
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
	
	       StoreData px = StoreData.get(player);

	
	 if (Packet_Umbrella.GuiID == 2)
	        {
	          int Hair = player.getDataWatcher().getWatchableObjectInt(27);
	          if (Hair < 10)
	          {
	            Hair = (Hair + 1);
	            player.getDataWatcher().updateObject(27, Integer.valueOf(Hair));

	          }
	          else
	          {
	            Hair = 0;
	            player.getDataWatcher().updateObject(27, Integer.valueOf(Hair));
	          }
	        }
	        else if (Packet_Umbrella.GuiID == 3)
	        {
	          int HairColor =  player.getDataWatcher().getWatchableObjectInt(29);
	          if (HairColor < 4)
	          {
	            HairColor = (HairColor + 1);
	            player.getDataWatcher().updateObject(29, Integer.valueOf(HairColor));
	          }
	          else
	          {
	            HairColor = 0;
	            player.getDataWatcher().updateObject(29, Integer.valueOf(HairColor));
	          }
	        }
	        else if (Packet_Umbrella.GuiID == 4)
	        {
	          if (px.Face < 8)
	          {
	            px.Face += 1;
	            player.getDataWatcher().updateObject(30, Integer.valueOf(px.Face));
	          }
	          else
	          {
	            px.Face = 0;
	            player.getDataWatcher().updateObject(30, Integer.valueOf(px.Face));
	          }
	        }
	        else if (Packet_Umbrella.GuiID == 5)
	        {
	          if (px.Sex == 0)
	          {
	            px.Sex = 1;
	            player.getDataWatcher().updateObject(31, Integer.valueOf(px.Sex));
	          }
	          else
	          {
	            px.Sex = 0;
	            player.getDataWatcher().updateObject(31, Integer.valueOf(px.Sex));
	          }
	        }
	        
	      }
} 


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\client\Packet_Umbrella.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */