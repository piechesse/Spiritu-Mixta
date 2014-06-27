package com.piechesse.spiritumixta.item;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.piechesse.spiritumixta.SpirituMixta;

public class SwordSacrifice extends SMItem {
	private Random r = new Random();

	public SwordSacrifice() {
		super("swordSacrifice");
		setUnlocalizedName("swordSacrifice");
		setMaxStackSize(1);
		setFull3D();
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (player.worldObj.isRemote) {
			return itemStack;
		}
		if (player.isSneaking()) {
			if (!player.capabilities.isCreativeMode) {
				
				//player.setHealth(player.getHealth()
				//		+ player.getAbsorptionAmount() - 20f);
				if (player.getAbsorptionAmount() > 20f){
					player.setAbsorptionAmount(player.getAbsorptionAmount()-20f);
				}else{
					player.setHealth(player.getHealth() - (20f-player.getAbsorptionAmount()));
					player.setAbsorptionAmount(0f);
				}
			}
			player.dropItem(Items.baked_potato, 1);
			if (player.getHealth() < 0.1f) {
				// player.onDeath(DamageSource.generic);
				if (r.nextInt(100) == 0) {
					player.addChatMessage(new ChatComponentText(
							"You bring great honor to your famiry!"));
				} else {
					player.addChatMessage(new ChatComponentText(
							"You bring great honor to your family!"));
				}
			} else {
				if (r.nextInt(100) == 0) {
					player.addChatMessage(new ChatComponentText(
							"You bring great confusion to your famiry!"));
				} else {
					player.addChatMessage(new ChatComponentText(
							"You bring great confusion to your family!"));
				}
			}
			
		}
		return itemStack;
	}
}
