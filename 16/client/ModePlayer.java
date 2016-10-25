 package uncelface.client;
 
 import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import uncelface.monster.AssetManager;
 
 public class ModePlayer extends ModelPlayerBase
 {
   ModelRenderer Wing01;
   ModelRenderer Wing02;
   ModelRenderer Shield;
   ModelRenderer Shape1;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   private float Helm_rotateAngleZ;
   private float Helm_rotateAngleY;
   private float Helm_rotateAngleX;
   private float Chest_rotateAngleZ;
   private float Chest_rotateAngleY;
   private float Chest_rotateAngleX;
   private float RightArm_rotateAngleZ;
   private float RightArm_rotateAngleY;
   private float RightArm_rotateAngleX;
   private float LeftArm_rotateAngleZ;
   private float LeftArm_rotateAngleY;
   private float LeftArm_rotateAngleX;
   private float LeftLeg_rotateAngleZ;
   private float LeftLeg_rotateAngleY;
   private float LeftLeg_rotateAngleX;
   private float RightLeg_rotateAngleZ;
   private float RightLeg_rotateAngleY;
   private float RightLeg_rotateAngleX;
   private float LeftWing_rotateAngleZ;
   private float LeftWing_rotateAngleY;
   private float LeftWing_rotateAngleX;
   private float RightWing_rotateAngleZ;
   private float RightWing_rotateAngleY;
   private float RightWing_rotateAngleX;
   private float AutoLeftWing_rotateAngleZ;
   private float AutoLeftWing_rotateAngleY;
   private float AutoLeftWing_rotateAngleX;
   private float AutoRightWing_rotateAngleZ;
   private float AutoRightWing_rotateAngleY;
   private float AutoRightWing_rotateAngleX;
   public static float modelXRotOffset = 180.0F;
   public static float modelYPosOffset = -1.5F;
   
   public static final ResourceLocation TEXTUREs = new ResourceLocation("fantasyland", "models/dragonset/dragonset.png");
   public static ResourceLocation TEXTUREs2 = new ResourceLocation("fantasyland", "models/dragonset/headplayer.png");
   public static ResourceLocation skintexture = new ResourceLocation("fantasyland", "models/bskin.png");
   public static final ResourceLocation anglewingtexture = new ResourceLocation("fantasyland", "models/wing/anglewing.png");
   public static final ResourceLocation guardarmortextre = new ResourceLocation("fantasyland", "models/dragonset/guardset.png");
   public static final ResourceLocation flamearmortextre = new ResourceLocation("fantasyland", "models/dragonset/flameset.png");
   public static final ResourceLocation armyblocktexture = new ResourceLocation("fantasyland", "models/defend/armyblock.png");
   public static final ResourceLocation aquablocktexture = new ResourceLocation("fantasyland", "models/defend/aquablock.png");
   public static final ResourceLocation flameblocktexture = new ResourceLocation("fantasyland", "models/defend/flameblock.png");
   public static final ResourceLocation orbblocktexture = new ResourceLocation("fantasyland", "models/defend/orbblock.png");
   
   public WavefrontObject modelhead = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonhelm2.obj");
   public ArrayList<GroupObject> partmodelhead = modelhead.groupObjects;
   
//   public WavefrontObject modelhelm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonhelm.obj");
//   public ArrayList<GroupObject> partmodelhelm = modelhelm.groupObjects;
//   
//   public WavefrontObject modelguardhelm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardhelm.obj");
//   public ArrayList<GroupObject> partmodelguardhelm = modelguardhelm.groupObjects;
//   
//   public WavefrontObject modelflamehelm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameHelm.obj");
//   public ArrayList<GroupObject> partmodelflamehelm = modelflamehelm.groupObjects;
//   
//   public WavefrontObject modelarmor = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonchest.obj");
//   public ArrayList<GroupObject> partmodelarmor = modelarmor.groupObjects;
//   
//   public WavefrontObject modellarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonLarm.obj");
//   public ArrayList<GroupObject> partmodellarm = modellarm.groupObjects;
//   
//   public WavefrontObject modelrarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonRarm.obj");
//   public ArrayList<GroupObject> partmodelrarm = modelrarm.groupObjects;
//   
//   public WavefrontObject modellleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonLleg.obj");
//   public ArrayList<GroupObject> partmodellleg = modellleg.groupObjects;
//   
//   public WavefrontObject modelrleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/dragonRleg.obj");
//   public ArrayList<GroupObject> partmodelrleg = modelrleg.groupObjects;
   
   public WavefrontObject modelhair1 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair1.obj");
   public ArrayList<GroupObject> parthair1 = modelhair1.groupObjects;
   public WavefrontObject modelhair2 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair2.obj");
   public ArrayList<GroupObject> parthair2 = modelhair2.groupObjects;
   public WavefrontObject modelhair3 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair3.obj");
   public ArrayList<GroupObject> parthair3 = modelhair3.groupObjects;
   public WavefrontObject modelhair4 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair4.obj");
   public ArrayList<GroupObject> parthair4 = modelhair4.groupObjects;
   public WavefrontObject modelhair5 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair5.obj");
   public ArrayList<GroupObject> parthair5 = modelhair5.groupObjects;
   public WavefrontObject modelhair6 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair6.obj");
   public ArrayList<GroupObject> parthair6 = modelhair6.groupObjects;
   public WavefrontObject modelhair7 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair7.obj");
   public ArrayList<GroupObject> parthair7 = modelhair7.groupObjects;
   public WavefrontObject modelhair8 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair8.obj");
   public ArrayList<GroupObject> parthair8 = modelhair8.groupObjects;
   public WavefrontObject modelhair9 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair9.obj");
   public ArrayList<GroupObject> parthair9 = modelhair9.groupObjects;
   public WavefrontObject modelhair10 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/hair10.obj");
   public ArrayList<GroupObject> parthair10 = modelhair10.groupObjects;
   
   public WavefrontObject modelghair1 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair1.obj");
   public ArrayList<GroupObject> partghair1 = modelghair1.groupObjects;
   public WavefrontObject modelghair2 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair2.obj");
   public ArrayList<GroupObject> partghair2 = modelghair2.groupObjects;
   public WavefrontObject modelghair3 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair3.obj");
   public ArrayList<GroupObject> partghair3 = modelghair3.groupObjects;
   public WavefrontObject modelghair4 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair4.obj");
   public ArrayList<GroupObject> partghair4 = modelghair4.groupObjects;
   public WavefrontObject modelghair5 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair5.obj");
   public ArrayList<GroupObject> partghair5 = modelghair5.groupObjects;
   public WavefrontObject modelghair6 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair6.obj");
   public ArrayList<GroupObject> partghair6 = modelghair6.groupObjects;
   public WavefrontObject modelghair7 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair7.obj");
   public ArrayList<GroupObject> partghair7 = modelghair7.groupObjects;
   public WavefrontObject modelghair8 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair8.obj");
   public ArrayList<GroupObject> partghair8 = modelghair8.groupObjects;
   public WavefrontObject modelghair9 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair9.obj");
   public ArrayList<GroupObject> partghair9 = modelghair9.groupObjects;
   public WavefrontObject modelghair10 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/hair/ghair10.obj");
   public ArrayList<GroupObject> partghair10 = modelghair10.groupObjects;
   
//   public WavefrontObject modelleftanglewing = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/wing/leftanglewing.obj");
//   public ArrayList<GroupObject> partmodelleftanglewing = modelleftanglewing.groupObjects;
//   
//   public WavefrontObject modelrightanglewing = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/wing/rightanglewing.obj");
//   public ArrayList<GroupObject> partmodelrightanglewing = modelrightanglewing.groupObjects;
//   
//   public WavefrontObject modelguardarmor = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardchest.obj");
//   public ArrayList<GroupObject> partmodelguardarmor = modelguardarmor.groupObjects;
//   
//   public WavefrontObject modelguardLarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardLarm.obj");
//   public ArrayList<GroupObject> partmodelguardLarm = modelguardLarm.groupObjects;
//   
//   public WavefrontObject modelguardRarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardRarm.obj");
//   public ArrayList<GroupObject> partmodelguardRarm = modelguardRarm.groupObjects;
//   
//   public WavefrontObject modelguardLleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardLleg.obj");
//   public ArrayList<GroupObject> partmodelguardLleg = modelguardLleg.groupObjects;
//   
//   public WavefrontObject modelguardRleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/guardRleg.obj");
//   public ArrayList<GroupObject> partmodelguardRleg = modelguardRleg.groupObjects;
//   
//   public WavefrontObject modelflamearmor = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameChest.obj");
//   public ArrayList<GroupObject> partmodelflamearmor = modelflamearmor.groupObjects;
//   
//   public WavefrontObject modelflameLarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameLarm.obj");
//   public ArrayList<GroupObject> partmodelflameLarm = modelflameLarm.groupObjects;
//   
//   public WavefrontObject modelflameRarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameRarm.obj");
//   public ArrayList<GroupObject> partmodelflameRarm = modelflameRarm.groupObjects;
//   
//   public WavefrontObject modelflameLleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameLleg.obj");
//   public ArrayList<GroupObject> partmodelflameLleg = modelflameLleg.groupObjects;
//   
//   public WavefrontObject modelflameRleg = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameRleg.obj");
//   public ArrayList<GroupObject> partmodelflameRleg = modelflameRleg.groupObjects;
//   
//   public WavefrontObject modelflamecape = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/dragonset/flameCape.obj");
//   public ArrayList<GroupObject> partmodelflamecape = modelflamecape.groupObjects;
//   
//   public WavefrontObject modelarmyblock = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/defend/armyblock.obj");
//   public ArrayList<GroupObject> partmodelarmyblock = modelarmyblock.groupObjects;
//   
//   public WavefrontObject modelaquablock = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/defend/aquablock.obj");
//   public ArrayList<GroupObject> partmodelaquablock = modelaquablock.groupObjects;
//    
//    public WavefrontObject modelflameblock = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/defend/flameblock.obj");
//    public ArrayList<GroupObject> partmodelflameblock = modelflameblock.groupObjects;
//    
//    public WavefrontObject modelorbblock = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/defend/orbblock.obj");
//    public ArrayList<GroupObject> partmodelorbblock = modelorbblock.groupObjects;
//    public static final ResourceLocation hwtex = new ResourceLocation("fantasyland", "models/halloweenpet/halloweensuit.png");
//    public WavefrontObject modelhwarmorbody = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/halloweenpet/halloweensuitbody.obj");
//    public ArrayList<GroupObject> parthwarmorbody = modelhwarmorbody.groupObjects;
//    public WavefrontObject modelhwarmorbody2 = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/halloweenpet/halloweensuitbody2.obj");
//    public ArrayList<GroupObject> parthwarmorbody2 = modelhwarmorbody2.groupObjects;
//    public WavefrontObject modelhwarmorhead = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/halloweenpet/halloweensuithead.obj");
//    public ArrayList<GroupObject> parthwarmorhead = modelhwarmorhead.groupObjects;
//    public WavefrontObject modelhwarmorrarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/halloweenpet/halloweensuitrarm.obj");
//    public ArrayList<GroupObject> parthwarmorrarm = modelhwarmorrarm.groupObjects;
//    public WavefrontObject modelhwarmorlarm = (WavefrontObject)AssetManager.getObjModel("fantasyland:models/halloweenpet/halloweensuitlarm.obj");
//    public ArrayList<GroupObject> parthwarmorlarm = modelhwarmorlarm.groupObjects;
//    private ResourceLocation texture;
//    
    public ModePlayer(ModelPlayerAPI var1)
    {
      super(var1);
      
      leftarm = new ModelRenderer(modelPlayer, 40, 16);
      leftarm.mirror = true;
      leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
      leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
      leftarm.setTextureSize(64, 32);
      rightleg = new ModelRenderer(modelPlayer, 0, 16);
      rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      leftleg = new ModelRenderer(modelPlayer, 0, 16);
      leftleg.mirror = true;
      leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
      leftleg.setTextureSize(64, 32);
      head = new ModelRenderer(modelPlayer, 0, 0);
      head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      head.setRotationPoint(0.0F, 0.0F, 0.0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      body = new ModelRenderer(modelPlayer, 16, 16);
      body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
      body.setRotationPoint(0.0F, 0.0F, 0.0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      rightarm = new ModelRenderer(modelPlayer, 40, 16);
      rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
      rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
    }
    
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      EntityPlayer player = (EntityPlayer)entity;
      
      if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
      {
        if (player.getDataWatcher().getWatchableObjectInt(27) != 0)
        {
          TEXTUREs2 = new ResourceLocation("fantasyland", "models/dragonset/headplayer2_" + player.getDataWatcher().getWatchableObjectInt(30) + ".png");
        }
        else
        {
          TEXTUREs2 = new ResourceLocation("fantasyland", "models/dragonset/headplayer_" + player.getDataWatcher().getWatchableObjectInt(30) + ".png");
        }
        
        skintexture = new ResourceLocation("fantasyland", "models/bskin.png");
      }
      else
      {
        if (player.getDataWatcher().getWatchableObjectInt(27) != 0)
        {
          TEXTUREs2 = new ResourceLocation("fantasyland", "models/dragonset/headplayerg2_" + player.getDataWatcher().getWatchableObjectInt(30) + ".png");
        }
        else
        {
          TEXTUREs2 = new ResourceLocation("fantasyland", "models/dragonset/headplayerg_" + player.getDataWatcher().getWatchableObjectInt(30) + ".png");
        }
        
        skintexture = new ResourceLocation("fantasyland", "models/gskin.png");
      }
      
      GL11.glPushMatrix();
      GL11.glScalef(0.9F, 0.9F, 0.9F);
      GL11.glTranslatef(-0.01F, 0.2F, -0.1F);
      
      GL11.glPushMatrix();
      Minecraft.getMinecraft().renderEngine.bindTexture(skintexture);
      leftarm.render(f5);
      rightleg.render(f5);
      leftleg.render(f5);
      body.render(f5);
      rightarm.render(f5);
      GL11.glPopMatrix();
      
  
      for (GroupObject part : partmodelhead)
      {
        GL11.glPushMatrix();
        GL11.glScalef(0.7F, 0.7F, 0.7F);
        GL11.glTranslatef(-0.02F, -2.04F, -0.0F);
        
        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTUREs2);
        rotate(modelXRotOffset, 1.0F, 0.0F, 0.0F);
        translate(0.0F, modelYPosOffset, 0.0F);
        if (Helm_rotateAngleZ != 0.0F) {
          GL11.glRotatef(Helm_rotateAngleZ * 57.295776F, 0.0F, 0.0F, 1.0F);
        }
        if (Helm_rotateAngleY != 0.0F) {
          GL11.glRotatef(-Helm_rotateAngleY * 57.295776F, 0.0F, 1.0F, 0.0F);
        }
        if (Helm_rotateAngleX != 0.0F) {
          GL11.glRotatef(Helm_rotateAngleX * 25.295776F, 1.0F, 0.0F, 0.0F);
        }
        part.render();
        
        if (player.getDataWatcher().getWatchableObjectInt(27) == 1)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair1)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.9F, 1.0F, 0.9F);
              GL11.glTranslatef(0.0F, -0.2F, 0.0F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair1_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair1)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 1.0F, 1.0F);
              GL11.glTranslatef(-0.04F, -0.15F, 0.05F);
              GL11.glRotated(-10.0D, 1.0D, 0.0D, 0.0D);
             Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair1_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 2)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair2)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.9F, 1.05F, 0.9F);
              GL11.glTranslatef(0.0F, -0.25F, 0.0F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair2_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject parthair : partghair2)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 1.0F, 0.8F);
              GL11.glTranslatef(0.0F, -0.25F, 0.0F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair2_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 3)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair3)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.9F, 1.05F, 0.9F);
              GL11.glTranslatef(0.0F, -0.25F, 0.0F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair3_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject parthair : partghair3)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.75F, 0.8F, 0.7F);
              GL11.glRotated(-15.0D, 1.0D, 0.0D, 0.0D);
              GL11.glTranslatef(0.0F, 0.15F, -0.15F);
             Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair3_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 4)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair4)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.8F, 1.15F, 0.9F);
              GL11.glTranslatef(0.0F, -0.25F, 0.01F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair4_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair4)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 1.05F, 0.8F);
              GL11.glTranslatef(0.03F, -0.35F, -0.09F);
              GL11.glRotated(5.0D, 1.0D, 0.0D, 0.0D);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair4_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 5)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair5)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.75F, 0.8F, 0.9F);
              GL11.glTranslatef(0.0F, -0.35F, -0.2F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair5_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair5)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 0.9F, 0.9F);
              GL11.glTranslatef(0.04F, -0.3F, -0.13F);
              GL11.glRotated(5.0D, 1.0D, 0.0D, 0.0D);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair5_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 6)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair6)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 0.85F, 0.85F);
              GL11.glTranslatef(0.1F, -0.35F, -0.1F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair6_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair6)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.8F, 0.9F, 0.8F);
              GL11.glTranslatef(0.06F, -0.32F, -0.08F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair6_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 7)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair7)
            {
              GL11.glPushMatrix();
              GL11.glScalef(1.0F, 1.0F, 1.0F);
              GL11.glTranslatef(0.0F, -0.45F, -0.05F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair7_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair7)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.8F, 1.0F, 0.8F);
              GL11.glTranslatef(0.06F, 0.15F, -0.08F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair7_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 8)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair8)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 0.85F, 0.85F);
              GL11.glTranslatef(0.0F, -0.65F, -0.05F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair8_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair8)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.8F, 0.8F, 0.8F);
              GL11.glTranslatef(0.06F, 0.3F, 0.1F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair8_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 9)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair9)
            {
              GL11.glPushMatrix();
              GL11.glScalef(0.85F, 0.85F, 0.85F);
              GL11.glTranslatef(0.0F, -0.65F, -0.05F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair9_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair9)
            {
              GL11.glPushMatrix();
              GL11.glScalef(1.1F, 1.1F, 1.1F);
              GL11.glTranslatef(0.0F, -0.05F, 0.0F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair9_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        else if (player.getDataWatcher().getWatchableObjectInt(27) == 10)
        {
          if (player.getDataWatcher().getWatchableObjectInt(31) == 0)
          {
            for (GroupObject parthair : parthair10)
            {
              GL11.glPushMatrix();
              GL11.glScalef(1.5F, 1.6F, 1.5F);
              GL11.glTranslatef(0.0F, -0.45F, -0.1F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/hair10_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              parthair.render();
              GL11.glPopMatrix();
            }
            
          }
          else {
            for (GroupObject partghair : partghair10)
            {
              GL11.glPushMatrix();
              GL11.glScalef(1.3F, 1.2F, 1.1F);
              GL11.glTranslatef(0.02F, -0.07F, -0.02F);
              Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("fantasyland", "models/hair/ghair10_" + player.getDataWatcher().getWatchableObjectInt(29) + ".png"));
              partghair.render();
              GL11.glPopMatrix();
            }
          }
        }
        
        GL11.glPopMatrix();
        GL11.glPopMatrix();

      GL11.glPopMatrix();
      }
      
    }
    
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
      rightarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F);
      
      leftarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
      
      rightarm.rotateAngleZ = 0.0F;
      leftarm.rotateAngleZ = 0.0F;
      rightleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 1.4F * par2);
      leftleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 1.4F * par2);
      rightleg.rotateAngleY = 0.0F;
      leftleg.rotateAngleY = 0.0F;
      
      modelPlayer.bipedHead.rotateAngleY = (par4 / 57.295776F);
      modelPlayer.bipedHead.rotateAngleX = (par5 / 57.295776F);
      
      
      if (!modelPlayer.isRiding)
      {
        modelPlayer.bipedRightArm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F);
        modelPlayer.bipedLeftArm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
      }
      modelPlayer.bipedRightArm.rotateAngleZ = 0.0F;
      modelPlayer.bipedLeftArm.rotateAngleZ = 0.0F;
      modelPlayer.bipedRightLeg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 1.4F * par2);
      modelPlayer.bipedLeftLeg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 1.4F * par2);
      modelPlayer.bipedRightLeg.rotateAngleY = 0.0F;
      modelPlayer.bipedLeftLeg.rotateAngleY = 0.0F;
      
      if (modelPlayer.isRiding)
      {
        rightarm.rotateAngleX = -1.0F;
        leftarm.rotateAngleX = -1.0F;
        rightleg.rotateAngleX = -1.2566371F;
        leftleg.rotateAngleX = -1.2566371F;
        rightleg.rotateAngleY = 0.31415927F;
        leftleg.rotateAngleY = -0.31415927F;
        
        modelPlayer.bipedRightArm.rotateAngleX = -1.0F;
        modelPlayer.bipedLeftArm.rotateAngleX = -1.0F;
        modelPlayer.bipedRightLeg.rotateAngleX = -1.2566371F;
        modelPlayer.bipedLeftLeg.rotateAngleX = -1.2566371F;
        modelPlayer.bipedRightLeg.rotateAngleY = 0.31415927F;
        modelPlayer.bipedLeftLeg.rotateAngleY = -0.31415927F;
      }
      
      if (modelPlayer.heldItemLeft != 0)
      {
        leftarm.rotateAngleX = (leftarm.rotateAngleX * 0.5F - 0.31415927F * modelPlayer.heldItemLeft);
        modelPlayer.bipedLeftArm.rotateAngleX = (modelPlayer.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F * modelPlayer.heldItemLeft);
      }
      
      if (modelPlayer.heldItemRight != 0)
      {
        rightarm.rotateAngleX = (rightarm.rotateAngleX * 0.5F - 0.31415927F * modelPlayer.heldItemRight);
        modelPlayer.bipedRightArm.rotateAngleX = (modelPlayer.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F * modelPlayer.heldItemRight);
      }
      
      rightarm.rotateAngleY = 0.0F;
      leftarm.rotateAngleY = 0.0F;
      modelPlayer.bipedRightArm.rotateAngleY = 0.0F;
      modelPlayer.bipedLeftArm.rotateAngleY = 0.0F;
      
  
  
      if (modelPlayer.onGround > -9990.0F)
      {
        float f6 = modelPlayer.onGround;
        body.rotateAngleY = (MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927F * 2.0F) * 0.2F);
        rightarm.rotationPointZ = (MathHelper.sin(body.rotateAngleY) * 5.0F);
        rightarm.rotationPointX = (-MathHelper.cos(body.rotateAngleY) * 5.0F);
        leftarm.rotationPointZ = (-MathHelper.sin(body.rotateAngleY) * 5.0F);
        leftarm.rotationPointX = (MathHelper.cos(body.rotateAngleY) * 5.0F);
        rightarm.rotateAngleY += body.rotateAngleY;
        leftarm.rotateAngleY += body.rotateAngleY;
        leftarm.rotateAngleX += body.rotateAngleY;
        f6 = 1.0F - modelPlayer.onGround;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        float f7 = MathHelper.sin(f6 * 3.1415927F);
        float f8 = MathHelper.sin(modelPlayer.onGround * 3.1415927F) * -(head.rotateAngleX - 0.7F) * 0.75F;
        rightarm.rotateAngleX = ((float)(rightarm.rotateAngleX - (f7 * 1.2D + f8)));
        rightarm.rotateAngleY += body.rotateAngleY * 2.0F;
        rightarm.rotateAngleZ = (MathHelper.sin(modelPlayer.onGround * 3.1415927F) * -0.4F);
        
  
        f6 = modelPlayer.onGround;
        
        f6 = 1.0F - modelPlayer.onGround;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * 3.1415927F);
        f6 = modelPlayer.onGround;
        modelPlayer.bipedBody.rotateAngleY = (MathHelper.sin(MathHelper.sqrt_float(f6) * 3.1415927F * 2.0F) * 0.2F);
        modelPlayer.bipedRightArm.rotationPointZ = (MathHelper.sin(modelPlayer.bipedBody.rotateAngleY) * 5.0F);
        modelPlayer.bipedRightArm.rotationPointX = (-MathHelper.cos(modelPlayer.bipedBody.rotateAngleY) * 5.0F);
        modelPlayer.bipedLeftArm.rotationPointZ = (-MathHelper.sin(modelPlayer.bipedBody.rotateAngleY) * 5.0F);
        modelPlayer.bipedLeftArm.rotationPointX = (MathHelper.cos(modelPlayer.bipedBody.rotateAngleY) * 5.0F);
        modelPlayer.bipedRightArm.rotateAngleY += modelPlayer.bipedBody.rotateAngleY;
        modelPlayer.bipedLeftArm.rotateAngleY += modelPlayer.bipedBody.rotateAngleY;
        modelPlayer.bipedLeftArm.rotateAngleX += modelPlayer.bipedBody.rotateAngleY;
        f6 = 1.0F - modelPlayer.onGround;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * 3.1415927F);
        float f9 = MathHelper.sin(modelPlayer.onGround * 3.1415927F) * -(modelPlayer.bipedHead.rotateAngleX - 0.7F) * 0.75F;
        modelPlayer.bipedRightArm.rotateAngleX = ((float)(modelPlayer.bipedRightArm.rotateAngleX - (f7 * 1.2D + f9)));
        modelPlayer.bipedRightArm.rotateAngleY += modelPlayer.bipedBody.rotateAngleY * 2.0F;
        modelPlayer.bipedRightArm.rotateAngleZ = (MathHelper.sin(modelPlayer.onGround * 3.1415927F) * -0.4F);
      }
      
      if (modelPlayer.isSneak)
      {
        body.rotateAngleX = 0.5F;
        rightarm.rotateAngleX += 0.4F;
        leftarm.rotateAngleX += 0.4F;
        rightleg.rotationPointZ = 4.0F;
        leftleg.rotationPointZ = 4.0F;
        rightleg.rotationPointY = 9.0F;
        leftleg.rotationPointY = 9.0F;
        head.rotationPointY = 1.0F;
        modelPlayer.bipedBody.rotateAngleX = 0.5F;
        modelPlayer.bipedRightArm.rotateAngleX += 0.4F;
        modelPlayer.bipedLeftArm.rotateAngleX += 0.4F;
        modelPlayer.bipedRightLeg.rotationPointZ = 4.0F;
        modelPlayer.bipedLeftLeg.rotationPointZ = 4.0F;
        modelPlayer.bipedRightLeg.rotationPointY = 9.0F;
        modelPlayer.bipedLeftLeg.rotationPointY = 9.0F;
        modelPlayer.bipedHead.rotationPointY = 1.0F;
  
  
  
  
      }
      else
      {
  
  
  
        body.rotateAngleX = 0.0F;
        rightleg.rotationPointZ = 0.1F;
        leftleg.rotationPointZ = 0.1F;
        rightleg.rotationPointY = 12.0F;
        leftleg.rotationPointY = 12.0F;
        head.rotationPointY = 0.0F;
        modelPlayer.bipedBody.rotateAngleX = 0.0F;
        modelPlayer.bipedRightLeg.rotationPointZ = 0.1F;
        modelPlayer.bipedLeftLeg.rotationPointZ = 0.1F;
        modelPlayer.bipedRightLeg.rotationPointY = 12.0F;
        modelPlayer.bipedLeftLeg.rotationPointY = 12.0F;
        modelPlayer.bipedHead.rotationPointY = 0.0F;
        
  
  
  
  
        LeftWing_rotateAngleY = (MathHelper.cos(par3 * 0.1662F + 3.141593F) * 6.0F * 0.4F * 0.3F - 0.5235988F + 1.6F);
        RightWing_rotateAngleY = (-(MathHelper.cos(par3 * 0.1662F + 3.141593F) * 6.0F * 0.4F * 0.3F - 0.5235988F + 0.9F));
      }
      rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
      leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
      modelPlayer.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      modelPlayer.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
      modelPlayer.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
      
      if (modelPlayer.aimedBow)
      {
        float f6 = 0.0F;
        float f7 = 0.0F;
        rightarm.rotateAngleZ = 0.0F;
        leftarm.rotateAngleZ = 0.0F;
        rightarm.rotateAngleY = (-(0.1F - f6 * 0.6F) + head.rotateAngleY);
        leftarm.rotateAngleY = (0.1F - f6 * 0.6F + head.rotateAngleY + 0.4F);
        rightarm.rotateAngleX = (-1.5707964F + head.rotateAngleX);
        leftarm.rotateAngleX = (-1.5707964F + head.rotateAngleX);
        rightarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        leftarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        
        f6 = 0.0F;
        f7 = 0.0F;
        
        modelPlayer.bipedRightArm.rotateAngleZ = 0.0F;
        modelPlayer.bipedLeftArm.rotateAngleZ = 0.0F;
        modelPlayer.bipedRightArm.rotateAngleY = (-(0.1F - f6 * 0.6F) + modelPlayer.bipedHead.rotateAngleY);
        modelPlayer.bipedLeftArm.rotateAngleY = (0.1F - f6 * 0.6F + modelPlayer.bipedHead.rotateAngleY + 0.4F);
        modelPlayer.bipedRightArm.rotateAngleX = (-1.5707964F + modelPlayer.bipedHead.rotateAngleX);
        modelPlayer.bipedLeftArm.rotateAngleX = (-1.5707964F + modelPlayer.bipedHead.rotateAngleX);
        modelPlayer.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        modelPlayer.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
        modelPlayer.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        modelPlayer.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        modelPlayer.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        modelPlayer.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
      }
      AutoLeftWing_rotateAngleY = (MathHelper.cos(par3 * 0.1662F + 3.141593F) * 6.0F * 0.4F * 0.3F - 0.5235988F + 0.2F);
      AutoRightWing_rotateAngleY = (-(MathHelper.cos(par3 * 0.1662F + 3.141593F) * 6.0F * 0.4F * 0.3F - 0.5235988F + 0.2F));
      Chest_rotateAngleX = modelPlayer.bipedBody.rotateAngleX;
      Chest_rotateAngleY = modelPlayer.bipedBody.rotateAngleY;
      Chest_rotateAngleZ = modelPlayer.bipedBody.rotateAngleZ;
      
      Helm_rotateAngleX = modelPlayer.bipedHead.rotateAngleX;
      Helm_rotateAngleY = modelPlayer.bipedHead.rotateAngleY;
      Helm_rotateAngleZ = modelPlayer.bipedHead.rotateAngleZ;
      
      RightArm_rotateAngleX = modelPlayer.bipedRightArm.rotateAngleX;
      RightArm_rotateAngleY = modelPlayer.bipedRightArm.rotateAngleY;
      RightArm_rotateAngleZ = modelPlayer.bipedRightArm.rotateAngleZ;
      
      
      LeftLeg_rotateAngleX = modelPlayer.bipedLeftLeg.rotateAngleX;
      LeftLeg_rotateAngleY = modelPlayer.bipedLeftLeg.rotateAngleY;
      LeftLeg_rotateAngleZ = modelPlayer.bipedLeftLeg.rotateAngleZ;
      
      RightLeg_rotateAngleX = modelPlayer.bipedRightLeg.rotateAngleX;
      RightLeg_rotateAngleY = modelPlayer.bipedRightLeg.rotateAngleY;
      RightLeg_rotateAngleZ = modelPlayer.bipedRightLeg.rotateAngleZ;
    }
    
    public void rotate(float rotX, float rotY, float rotZ)
    {
      GL11.glRotatef(rotX, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(rotY, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(rotZ, 0.0F, 0.0F, 1.0F);
    }
    
    public void rotate(float rotation, float angleX, float angleY, float angleZ)
    {
      GL11.glRotatef(rotation, angleX, angleY, angleZ);
    }
    
    public void translate(float posX, float posY, float posZ)
    {
      GL11.glTranslatef(posX, posY, posZ);
    }
    
    public void scale(float scaleX, float scaleY, float scaleZ)
    {
      GL11.glScalef(scaleX, scaleY, scaleZ);
    }
  }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\client\ModePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */