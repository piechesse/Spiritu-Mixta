package com.piechesse.spiritumixta.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import com.piechesse.spiritumixta.Reference;
import com.piechesse.spiritumixta.SpirituMixta;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpirit extends SMItem {
	public static final String[] names = new String[] { "Black", "Blue",
			"Brown", "Cyan", "Green", "Grey", "LightBlue", "Lime", "Magenta",
			"Orange", "Pink", "Purple", "Red", "Silver", "White", "Yellow" };
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemSpirit() {
		super("spirit");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(SpirituMixta.tabSpirituMixta);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		int j = MathHelper.clamp_int(i, 0, 15);
		return this.icons[j];
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 15);
		return super.getUnlocalizedName() + names[i];
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 16; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		this.icons = new IIcon[names.length];

		for (int i = 0; i < names.length; ++i) {
			this.icons[i] = register.registerIcon(Reference.MODID + ":"
					+ getUnlocalizedName().substring(5) + "/spirit" + names[i]);
		}
	}
}
