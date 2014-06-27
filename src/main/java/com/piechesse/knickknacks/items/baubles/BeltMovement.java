package com.piechesse.knickknacks.items.baubles;

import com.piechesse.knickknacks.Knickknacks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class BeltMovement extends Item implements IBauble 
{

	public BeltMovement() {
		setUnlocalizedName("movementBelt");
		setTextureName(Knickknacks.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Knickknacks.tabKnickkacks);
		setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 1f;
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = 1f;
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.stepHeight = .5f;
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
