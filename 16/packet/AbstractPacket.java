package uncelface.packet;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public abstract class AbstractPacket {

	public final Packet generatePacket() {

        DataOutputStream outputStream = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            outputStream = new DataOutputStream(bos);

            write(outputStream);

            return new Packet250CustomPayload(getChannel(), bos.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
           closeStream(outputStream);
        }
        return null;
    }
	  public static void closeStream(Closeable c){
	        try{
	            if(c != null){
	                c.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  
			/**
			 * Adapted to a public version from Minecraft's Packet class method
			 */
			public static void writeNBTTagCompound(NBTTagCompound compound, DataOutput out) throws IOException {
				if (compound == null) {
					out.writeShort(-1);
				} else {
					byte[] abyte = CompressedStreamTools.compress(compound);
					out.writeShort((short)abyte.length);
					out.write(abyte);
				}
			}

			/**
			 * Adapted from Minecraft's Packet class method
			 */
			public static NBTTagCompound readNBTTagCompound(DataInputStream in) throws IOException {
				short short1 = in.readShort();
				if (short1 < 0) {
					return null;
				} else {
					byte[] abyte = new byte[short1];
					in.readFully(abyte);
					return CompressedStreamTools.decompress(abyte);
				}
			}
	public abstract String getChannel();
	public abstract void write(DataOutput out) throws IOException;
	public abstract void process(DataInputStream in, EntityPlayer player);
}