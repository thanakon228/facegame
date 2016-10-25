 package uncelface.command;
 
 import uncelface.ModStart;
import uncelface.player.StoreData;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
 
 public class resetFace
   extends CommandBase
 {
   public resetFace() {}
   
   public String getCommandName()
   {
     return "reface";
   }
   
 
   public String getCommandUsage(ICommandSender icommandsender)
   {
     return "";
   }
   
 
   public void processCommand(ICommandSender icommandsender, String[] astring)
   {
     EntityPlayer playertarget = getPlayer(icommandsender, astring[0]);
     StoreData px = StoreData.get(playertarget);
     playertarget.openGui(ModStart.instance, ModStart.guiFaceID, playertarget.worldObj, (int)playertarget.posX, (int)playertarget.posY, (int)playertarget.posZ);
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\command\resetFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */