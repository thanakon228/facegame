package uncelface.guiface;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class FaceInv implements IInventory
{
	private final String name = "";

	private final String tagName = "FaceInv";

	public static final int SlotNum = 1;

	ItemStack[] inventory = new ItemStack[SlotNum];

	public FaceInv() 
	{
		
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				onInventoryChanged();
			} else {
				setInventorySlotContents(slot, null);
			}
		}

		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public String getInvName() {
		return name;
	}

	@Override
	public boolean isInvNameLocalized() {
		return name.length() > 0;

	}

	@Override
	public void onInventoryChanged() {
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				inventory[i] = null;
		}
		
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return stack.getItem() instanceof ItemArmor;
	}

	public void writeToNBT(NBTTagCompound compound)
	{
	NBTTagList items = new NBTTagList();

	for (int i = 0; i < getSizeInventory(); ++i)
	{
	if (getStackInSlot(i) != null)
	{
	NBTTagCompound item = new NBTTagCompound();
	item.setByte("Slot", (byte) i);
	getStackInSlot(i).writeToNBT(item);
	items.appendTag(item);
	}
	}
	compound.setTag(tagName, items);
	}

	public void readFromNBT(NBTTagCompound compound)
	{
	NBTTagList items = compound.getTagList(tagName);
	for (int i = 0; i < items.tagCount(); ++i) {
	NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
	byte slot = item.getByte("Slot");
	if (slot >= 0 && slot < getSizeInventory()) {
	inventory[slot] = ItemStack.loadItemStackFromNBT(item);
	}
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

}
