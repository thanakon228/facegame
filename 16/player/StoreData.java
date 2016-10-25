 package uncelface.player;
 
 import uncelface.ServerProxy;
import uncelface.guiface.FaceInv;
import uncelface.packet.Packet_SyncPlayerData;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
 
 public class StoreData implements IExtendedEntityProperties
 {
   public static final String Name = "StorePlayerData";
   private final EntityPlayer player;
   public final FaceInv FaceIN = new FaceInv();
   
   public int Hair = 0;
   public int HairColor = 0;
   public int Face = 0;
   public int Sex = 0;
   
   public boolean op = false;
   
   public StoreData(EntityPlayer player)
   {
     this.player = player;
     this.player.getDataWatcher().addObject(27, Integer.valueOf(Hair));
     this.player.getDataWatcher().addObject(29, Integer.valueOf(HairColor));
     this.player.getDataWatcher().addObject(30, Integer.valueOf(Face));
     this.player.getDataWatcher().addObject(31, Integer.valueOf(Sex));
   }
   
   public static final void register(EntityPlayer player)
   {
     player.registerExtendedProperties("StorePlayerData", new StoreData(player));
   }
   
   public static final StoreData get(EntityPlayer player)
   {
     return (StoreData)player.getExtendedProperties("StorePlayerData");
   }
   
 
   public final void saveNBTData(NBTTagCompound compound)
   {
     NBTTagCompound properties = new NBTTagCompound();
     FaceIN.writeToNBT(properties);
     
     properties.setInteger("Hair", Hair);
     properties.setInteger("HairColor", HairColor);
     properties.setInteger("Face", Face);
     properties.setInteger("Sex", Sex);
     
     properties.setBoolean("op", op);
     compound.setTag("StorePlayerData", properties);
   }
   
 
   public final void loadNBTData(NBTTagCompound compound)
   {
     NBTTagCompound properties = (NBTTagCompound)compound.getTag("StorePlayerData");
     FaceIN.readFromNBT(properties);
     
     Hair = properties.getInteger("Hair");
     HairColor = properties.getInteger("HairColor");
     Face = properties.getInteger("Face");
     Sex = properties.getInteger("Sex");
     
     op = properties.getBoolean("op");
     
     player.getDataWatcher().updateObject(27, Integer.valueOf(Hair));
     player.getDataWatcher().updateObject(29, Integer.valueOf(HairColor));
     player.getDataWatcher().updateObject(30, Integer.valueOf(Face));
     player.getDataWatcher().updateObject(31, Integer.valueOf(Sex));
   }
   
 
 
   public void init(Entity entity, World world) {}
   
 
   private static final String getSaveKey(EntityPlayer player)
   {
     return player.getCommandSenderName() + ":" + "StorePlayerData";
   }
   
   public static final void saveProxyData(EntityPlayer player)
   {
     NBTTagCompound savedData = new NBTTagCompound();
     get(player).saveNBTData(savedData);
     ServerProxy.storeEntityData(getSaveKey(player), savedData);
   }
   
   public static final void loadProxyData(EntityPlayer player)
   {
     StoreData playerData = get(player);
     NBTTagCompound savedData = ServerProxy.getEntityData(getSaveKey(player));
     if (savedData != null) playerData.loadNBTData(savedData);
//     fantasyland.ModStart.networkChannel.sendTo(new Packet_SyncPlayerData(player), (EntityPlayerMP)player);
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\player\StoreData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */