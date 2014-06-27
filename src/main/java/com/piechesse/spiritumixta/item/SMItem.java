package com.piechesse.spiritumixta.item;

import com.piechesse.spiritumixta.SpirituMixta;

import net.minecraft.item.Item;

public class SMItem extends Item {
	public SMItem(String name) {
		super();
		setUnlocalizedName(name);
		setMaxStackSize(64);
		setCreativeTab(SpirituMixta.tabSpirituMixta);
		setTextureName(SpirituMixta.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
