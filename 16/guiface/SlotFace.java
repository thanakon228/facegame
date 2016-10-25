 package uncelface.guiface;
 
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 
 public class SlotFace extends Slot
 {
   public int field_75225_a;
   public EntityPlayer player;
   
   SlotFace(FaceInv par2IInventory, int par3, int par4, int par5, EntityPlayer player)
   {
     super(par2IInventory, par3, par4, par5);
     this.player = player;
     field_75225_a = par3;
   }
   
 
   public boolean canTakeStack(EntityPlayer par1EntityPlayer) { return super.canTakeStack(par1EntityPlayer); }
   
   public int getSlotStackLimit() { return 1; }
   
   public boolean isItemValid(ItemStack par1ItemStack)
   {
     return false;
   }
 }


/* Location:              C:\Users\Thanakon\Downloads\Compressed\PS_client.deobf.jar!\fantasyland\guiface\SlotFace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */