 package uncelface.player;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
 import net.minecraftforge.event.entity.EntityEvent;
 import net.minecraftforge.event.entity.EntityJoinWorldEvent;
 import net.minecraftforge.event.entity.living.LivingDeathEvent;
 
 public class ServerPlayer
 {
   public World world;
   
   public ServerPlayer() {}
   
   java.util.Random rand = new java.util.Random();
   
   @ForgeSubscribe
   public void CreatePlayer(net.minecraftforge.event.entity.EntityEvent.EntityConstructing event) {
     if ((event.entity instanceof EntityPlayer))
     {
       if (StoreData.get((EntityPlayer)event.entity) == null)
         StoreData.register((EntityPlayer)event.entity);
     }
   }
   
   @ForgeSubscribe
   public void JoinWorld(EntityJoinWorldEvent event) {
     StoreData px;
     if ((!event.entity.worldObj.isRemote) && ((event.entity instanceof EntityPlayer)))
     {
       StoreData.loadProxyData((EntityPlayer)event.entity);
       EntityPlayer player = (net.minecraft.entity.player.EntityPlayerMP)event.entity;
       px = StoreData.get(player);
     }
   }
   
   @ForgeSubscribe
   public void Death(LivingDeathEvent event)
   {
     if ((!event.entity.worldObj.isRemote) && ((event.entity instanceof EntityPlayer)))
     {
       StoreData.saveProxyData((EntityPlayer)event.entity);
     }
   }
   
   @ForgeSubscribe
   public void UpdateTick(net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent event) {
     StoreData px;
     if ((!event.entity.worldObj.isRemote) && ((event.entity instanceof EntityPlayer)))
     {
       EntityPlayer player = (EntityPlayer)event.entity;
       px = StoreData.get(player);
     }
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\player\ServerPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */