package com.piechesse.spiritumixta.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.piechesse.spiritumixta.item.ModItems;

public class SacrificeHandler {
	public static void sacrifice(ItemStack itemStack, EntityLivingBase entity) {
		World world = entity.worldObj;
		ItemStack stack = null;
		if (entity instanceof EntityDragon) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 0);
		} else if (entity instanceof EntityGhast) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 1);
		} else if (entity instanceof EntityVillager) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 2);
		} else if (entity instanceof EntitySquid) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 3);
		} else if (entity instanceof EntityCreeper) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 4);
		} else if (entity instanceof EntitySkeleton) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 5);
		} else if (entity instanceof EntityBat) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 6);
		} else if (entity instanceof EntitySlime) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 7);
		} else if (entity instanceof EntityIronGolem) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 8);
		} else if (entity instanceof EntityBlaze) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 9);
		} else if (entity instanceof EntityPig) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 10);
		} else if (entity instanceof EntityEnderman) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 11);
		} else if (entity instanceof EntitySpider) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 12);
		} else if (entity instanceof EntityPlayer) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 13);
		} else if (entity instanceof EntityWither) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 14);
		} else if (entity instanceof EntityChicken) {
			stack = new ItemStack(ModItems.fracturedSpirit, 1, 15);
		}
		if (stack != null) {
			world.spawnEntityInWorld(new EntityItem(world, entity.posX,
					entity.posY + 1f, entity.posZ, stack));
		}
	}
}