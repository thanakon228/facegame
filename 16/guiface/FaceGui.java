 package uncelface.guiface;
 
 import cpw.mods.fml.relauncher.Side;

 import java.util.List;

 import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import uncelface.ModStart;
import uncelface.client.Packet_Umbrella;
import uncelface.player.StoreData;
 
 @cpw.mods.fml.relauncher.SideOnly(Side.CLIENT)
 public class FaceGui extends GuiContainer
 {
   EntityPlayer Player = null;
   
   private float xSize_lo;
   
   private float ySize_lo;
   private static final ResourceLocation iconLocation = new ResourceLocation("fantasyland:textures/gui/FaceGui.png");
   private final FaceInv inventory;
   
   public FaceGui(EntityPlayer player, InventoryPlayer inventoryPlayer, FaceInv inventoryCustom)
   {
     super(new FaceData(player, inventoryPlayer, inventoryCustom));
     inventory = inventoryCustom;
     Player = player;
   }
   
   public void drawScreen(int mouseX, int mouseY, float f)
   {
     super.drawScreen(mouseX, mouseY, f);
     xSize_lo = mouseX;
     ySize_lo = mouseY;
     
     buttonList.clear();
     buttonList.add(new GuiButton(0, guiLeft + 120, guiTop + 15, 46, 15, "เปลี่ยนทรงผม"));
     buttonList.add(new GuiButton(1, guiLeft + 120, guiTop + 35, 46, 15, "เปลี่ยนสีผม"));
     buttonList.add(new GuiButton(2, guiLeft + 120, guiTop + 55, 46, 15, "เปลี่ยนหน้า"));
     buttonList.add(new GuiButton(3, guiLeft + 120, guiTop + 75, 46, 15, "เปลี่ยนเพศ"));
   }
   
 
 
   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {}
   
 
   protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
   {
     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
     mc.getTextureManager().bindTexture(iconLocation);
     drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize + 80, ySize + 38);
     drawPlayerModel(guiLeft + 87 - 30, guiTop + 190, 85, guiLeft + 51 - xSize_lo, guiTop + 25 - ySize_lo, mc.thePlayer);
   }
   
   public static void drawPlayerModel(int x, int y, int scale, float yaw, float pitch, EntityLivingBase entity) {
     GL11.glEnable(2903);
     GL11.glPushMatrix();
     GL11.glTranslatef(x, y, 50.0F);
     GL11.glScalef(-scale, scale, scale);
     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
     float f2 = entity.renderYawOffset;
     float f3 = entity.rotationYaw;
     float f4 = entity.rotationPitch;
     float f5 = entity.prevRotationYawHead;
     float f6 = entity.rotationYawHead;
     GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
     RenderHelper.enableStandardItemLighting();
     GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
     GL11.glRotatef(-(float)Math.atan(pitch / 40.0F) * 20.0F, 1.0F, 0.0F, 0.0F);
     entity.renderYawOffset = ((float)Math.atan(yaw / 40.0F) * 20.0F);
     entity.rotationYaw = ((float)Math.atan(yaw / 40.0F) * 40.0F);
     entity.rotationPitch = (-(float)Math.atan(pitch / 40.0F) * 20.0F);
     entity.rotationYawHead = entity.rotationYaw;
     entity.prevRotationYawHead = entity.rotationYaw;
     GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
     RenderManager.instance.playerViewY = 180.0F;
     RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
     entity.renderYawOffset = f2;
     entity.rotationYaw = f3;
     entity.rotationPitch = f4;
     entity.prevRotationYawHead = f5;
     entity.rotationYawHead = f6;
     GL11.glPopMatrix();
     RenderHelper.disableStandardItemLighting();
     GL11.glDisable(32826);
     OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
     GL11.glDisable(3553);
     OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }
   
 
   protected void actionPerformed(GuiButton button)
   {
     EntityPlayer player = Player;
     StoreData px = StoreData.get(player);
     
//     if (button.id == 0)
//     {
//       ModStart.networkChannel.sendToServer(new Packet_Umbrella(2));
//     }
//     else if (button.id == 1)
//     {
//       ModStart.networkChannel.sendToServer(new Packet_Umbrella(3));
//     }
//     else if (button.id == 2)
//     {
//       ModStart.networkChannel.sendToServer(new Packet_Umbrella(4));
//     }
//     else if (button.id == 3)
//     {
//       ModStart.networkChannel.sendToServer(new Packet_Umbrella(5));
//     }
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\guiface\FaceGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */