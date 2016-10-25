 package uncelface.guiface;
 
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.InventoryPlayer;
 import net.minecraft.inventory.Container;
 import net.minecraft.item.ItemStack;
 
 public class FaceData
   extends Container
 {
   public FaceData(EntityPlayer player, InventoryPlayer inventoryPlayer, FaceInv inventoryCustom)
   {
     addSlotToContainer(new SlotFace(inventoryCustom, 0, 0, 0, player));
   }
   
   public ItemStack transferStackInSlot(EntityPlayer player, int par2) { return null; }
   
   public boolean canInteractWith(EntityPlayer player) {
     return true;
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\guiface\FaceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */