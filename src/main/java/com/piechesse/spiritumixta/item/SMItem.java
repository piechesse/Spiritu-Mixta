package com.piechesse.spiritumixta.item;

import net.minecraft.item.Item;

import com.piechesse.spiritumixta.Reference;
import com.piechesse.spiritumixta.SpirituMixta;

public class SMItem extends Item {
	public SMItem(String name) {
		super();
		setUnlocalizedName(name);
		setMaxStackSize(64);
		setCreativeTab(SpirituMixta.tabSpirituMixta);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
