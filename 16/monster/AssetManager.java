 package uncelface.monster;
 
 import java.util.HashMap;
 import java.util.Map;

 import net.minecraft.client.model.ModelBase;
import net.minecraft.util.Icon;
 import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.client.model.AdvancedModelLoader;
 import net.minecraftforge.client.model.IModelCustom;
 
 
 
 public class AssetManager
 {
   public static Map<String, ResourceLocation> textures = new HashMap();
   public static Map<String, Icon> icons = new HashMap();
   public static Map<String, Icon[]> iconGroups = new HashMap();
   public static Map<String, String> sounds = new HashMap();
   public static Map<String, ModelBase> models = new HashMap();
   public static Map<String, IModelCustom> objModels = new HashMap();
   
   public AssetManager() {}
   
   public static void addTexture(String name) { name = name.toLowerCase();
     textures.put(name, new ResourceLocation(name));
   }
   
   public static void addModel(String name, ModelBase model)
   {
     name = name.toLowerCase();
     models.put(name, model);
   }
   
   public static void addObjModel(String name)
   {
     name = name.toLowerCase();
     objModels.put(name, AdvancedModelLoader.loadModel(name));
   }
   
   public static IModelCustom getObjModel(String name)
   {
     name = name.toLowerCase();
     if (!objModels.containsKey(name)) {
       addObjModel(name);
     }
     return (IModelCustom)objModels.get(name);
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\monster\AssetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */