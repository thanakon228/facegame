  package uncelface.client;
  
  import uncelface.ServerProxy;
import api.player.model.ModelPlayerAPI;
import cpw.mods.fml.common.Loader;
import net.minecraft.client.Minecraft;
  
  
  
  public class ClientProxy
    extends ServerProxy
  {
    private final Minecraft mc = Minecraft.getMinecraft();
    
    public ClientProxy() {}
    
    public void reg() {
      if (Loader.isModLoaded("RenderPlayerAPI"))
      {
        ModelPlayerAPI.register("ModelPlayerB", ModePlayer.class);
      }
    }
  }


