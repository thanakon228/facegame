 package uncelface;
 
 import cpw.mods.fml.common.network.IGuiHandler;

import java.util.HashMap;
import java.util.Map;

import uncelface.guiface.FaceData;
import uncelface.guiface.FaceGui;
import uncelface.player.StoreData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
 
 public class ServerProxy
   implements IGuiHandler
 {
   private static final Map<String, NBTTagCompound> eted = new HashMap();
   
   public ServerProxy() {}
   
   public static void storeEntityData(String name, NBTTagCompound compound) { eted.put(name, compound); }
   
 
   public static NBTTagCompound getEntityData(String name)
   {
     return (NBTTagCompound)eted.remove(name);
   }
   
 
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
     if (ID == ModStart.guiFaceID)
     {
       return new FaceData(player, player.inventory, StoreData.get(player).FaceIN);
     }
     
 
     return null;
   }
   
 
 
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
     if (ID == ModStart.guiFaceID)
     {
       return new FaceGui(player,  player.inventory, StoreData.get(player).FaceIN);
     }
     
 
     return null;
   }
   
   public void reg() {}
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\ServerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */