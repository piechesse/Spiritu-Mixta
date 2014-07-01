package com.piechesse.spiritumixta.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.piechesse.spiritumixta.Reference;
import com.piechesse.spiritumixta.SpirituMixta;
import com.piechesse.spiritumixta.handler.SacrificeHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SwordSacrifice extends SMItem {
	private Random r = new Random();

	public SwordSacrifice() {
		super("swordSacrifice");
		setMaxStackSize(1);
		setFull3D();
	}

	private IIcon sword;
	private IIcon activated;
	private IIcon full;
	private IIcon[] spirit;

	private final int[] MAX_POWER = new int[] { 1000, 2000, 7500, 10000, 15000 };
	private final float[] DAMAGE = new float[] { 2f, 4f, 8f, 10f, 12f };

	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if (itemStack.stackTagCompound == null)
			itemStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tag = itemStack.stackTagCompound;
		tag.setInteger("tier", 0);
		tag.setInteger("power", 0);
		tag.setBoolean("activated", false);
	}

	public void addInformation(ItemStack itemStack, EntityPlayer player,
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
		if (player.worldObj.isRemote) {
			return itemStack;
		}
		if (itemStack.stackTagCompound == null) {
			itemStack.setTagCompound(new NBTTagCompound());
			NBTTagCompound tag = itemStack.stackTagCompound;
			tag.setInteger("tier", 0);
			tag.setInteger("power", 0);
			tag.setBoolean("activated", true);
		}
		NBTTagCompound tag = itemStack.stackTagCompound;
		if (player.isSneaking()) {
			tag.setBoolean("activated", !tag.getBoolean("activated"));
			return itemStack;
		}
		if (tag.getBoolean("activated")) {
			selfSacrifice(itemStack, player);
			return itemStack;
		}
		return itemStack;
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase entity1,
			EntityLivingBase entity2) {
		if (itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = new NBTTagCompound();
		}
		NBTTagCompound tag = itemStack.stackTagCompound;
		if (tag.getBoolean("activated")) {
			if (tag.getInteger("power") >= entity1.getHealth() * 50) {
				SacrificeHandler.sacrifice(itemStack, entity1);
				tag.setInteger(
						"power",
						(int) (tag.getInteger("power") - (entity1.getHealth() * 50)));
				entity1.setHealth(0f);
				tag.setBoolean("activated", false);
			}
		} else {
			float health = entity1.getHealth();
			float damage = DAMAGE[tag.getInteger("tier")];
			if (entity1.getHealth() <= damage)
				damage = entity1.getHealth();
			entity1.setHealth(entity1.getHealth() - damage);
			int power = (int) (tag.getInteger("power") + (damage * 25));
			if (tag.getInteger("power") + power < MAX_POWER[tag
					.getInteger("tier")])
				tag.setInteger("power", power);
			else
				tag.setInteger("power", MAX_POWER[tag.getInteger("tier")]);
		}
		return true;
	}

	public void selfSacrifice(ItemStack itemStack, EntityPlayer player) {

		if (!player.capabilities.isCreativeMode) {

			if (player.getAbsorptionAmount() > 20f) {
				player.setAbsorptionAmount(player.getAbsorptionAmount() - 20f);
			} else {
				player.setHealth(player.getHealth()
						- (20f - player.getAbsorptionAmount()));
				player.setAbsorptionAmount(0f);
			}
			if (itemStack.stackTagCompound.getInteger("power") >= 1000) {
				player.worldObj.spawnEntityInWorld(new EntityItem(
						player.worldObj, player.posX, player.posY + 1f,
						player.posZ, new ItemStack(ModItems.fracturedSpirit, 1,
								13)));
			}
		} else {
			player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj,
					player.posX, player.posY + 1f, player.posZ, new ItemStack(
							ModItems.fracturedSpirit, 1, 13)));
		}

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
		this.spirit = new IIcon[24];
		this.sword = register.registerIcon(Reference.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/swordSacrifice");
		this.activated = register.registerIcon(Reference.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/activated");
		this.full = register.registerIcon(Reference.MODID + ":"
				+ getUnlocalizedName().substring(5) + "/full");
		for (int i = 0; i < 24; i++) {
			this.spirit[i] = register.registerIcon(Reference.MODID + ":"
					+ getUnlocalizedName().substring(5) + "/spirit" + i);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int pass) {

		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		float index = Math.min(23 * stack.stackTagCompound.getInteger("power")
				/ MAX_POWER[stack.stackTagCompound.getInteger("tier")], 23);
		if (pass == 0)
			return sword;
		else if (pass == 1)
			return spirit[(int) index];
		else if (pass == 2)
			return stack.stackTagCompound.getBoolean("activated") ? activated
					: spirit[0];
		else if (pass == 3)
			return stack.stackTagCompound.getInteger("power") >= MAX_POWER[stack.stackTagCompound
					.getInteger("tier")] ? full : spirit[0];
		else
			return spirit[0];
	}
}
