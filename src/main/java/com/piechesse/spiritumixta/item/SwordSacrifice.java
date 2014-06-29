package com.piechesse.spiritumixta.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.piechesse.spiritumixta.SpirituMixta;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SwordSacrifice extends SMItem {
	private Random r = new Random();

	public SwordSacrifice() {
		super("swordSacrifice");
		setUnlocalizedName("swordSacrifice");
		setMaxStackSize(1);
		setFull3D();
	}

	private IIcon sword;
	private IIcon activated;
	private IIcon full;
	private IIcon[] spirit;

	private final int[] MAX_POWER = new int[] { 1000, 10000, 100000, 1000000 };

	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (itemStack.stackTagCompound == null)
			itemStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tag = itemStack.stackTagCompound;
		tag.setInteger("tier", 0);
		tag.setInteger("power", 0);
		tag.setBoolean("activated", false);
	}

	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer,
			List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = new NBTTagCompound();
		}
		list.add("Tier: " + itemStack.stackTagCompound.getInteger("tier"));
		list.add("Power: " + itemStack.stackTagCompound.getInteger("power"));
		if (itemStack.stackTagCompound.getBoolean("activated"))
			list.add("Activated!");

	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (itemStack.stackTagCompound == null) {
			itemStack.setTagCompound(new NBTTagCompound());
			NBTTagCompound tag = itemStack.stackTagCompound;
			tag.setInteger("tier", 0);
			tag.setInteger("power", 0);
			tag.setBoolean("activated", true);
		}
		NBTTagCompound tag = itemStack.stackTagCompound;
		if (player.isSneaking()) {
			if (!tag.getBoolean("activated"))
				tag.setBoolean("activated", true);
			else
				tag.setBoolean("activated", false);
		}
		if (tag.getInteger("power") < MAX_POWER[tag.getInteger("tier")]) {
			tag.setInteger("power", tag.getInteger("power") + 20);
		} else {
			tag.setInteger("power", MAX_POWER[tag.getInteger("tier")]);
		}
		if (player.worldObj.isRemote) {
			return itemStack;
		}
		return itemStack;
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entity1,
			EntityLivingBase entity2) {
		entity1.setHealth(-1);
		if (itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = new NBTTagCompound();
		}
		itemStack.stackTagCompound.setInteger("power",
				itemStack.stackTagCompound.getInteger("power") + 100);

		return true;
	}

	public void sacrifice(ItemStack itemStack, EntityPlayer player) {

		if (player.isSneaking()) {
			if (!player.capabilities.isCreativeMode) {

				// player.setHealth(player.getHealth()
				// + player.getAbsorptionAmount() - 20f);
				if (player.getAbsorptionAmount() > 20f) {
					player.setAbsorptionAmount(player.getAbsorptionAmount() - 20f);
				} else {
					player.setHealth(player.getHealth()
							- (20f - player.getAbsorptionAmount()));
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

		} else {
			player.setAbsorptionAmount(player.getAbsorptionAmount() + 2);
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderPasses(int metadata) {
		return 4;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.spirit = new IIcon[6];
		this.sword = register.registerIcon(SpirituMixta.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/swordSacrifice");
		this.activated = register.registerIcon(SpirituMixta.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/activated");
		this.full = register.registerIcon(SpirituMixta.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/full");
		for (int i = 0; i < 6; i++) {
			this.spirit[i] = register.registerIcon(SpirituMixta.MODID + ":"
					+ getUnlocalizedName().substring(5) + "/spirit" + i);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {

		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		float index = Math.max(4 * stack.stackTagCompound.getInteger("power")
				/ MAX_POWER[stack.stackTagCompound.getInteger("tier")], 5);
		if (pass == 0)
			return sword;
		else if (pass == 1)
			return stack.stackTagCompound.getBoolean("activated") ? activated
					: spirit[0];
		else if (pass == 2)
			return stack.stackTagCompound.getInteger("power") >= MAX_POWER[stack.stackTagCompound
					.getInteger("tier")] ? full : spirit[0];
		else if (pass == 3)
			return spirit[(int) index];
		else
			return spirit[0];

	}
}
