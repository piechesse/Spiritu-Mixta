package com.piechesse.spiritumixta.block;

import com.piechesse.spiritumixta.SpirituMixta;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SMBlock extends Block {

	protected SMBlock(Material material, String string) {
		super(material);
		setBlockName(string);
		setBlockTextureName(SpirituMixta.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(SpirituMixta.tabSpirituMixta);
	}
}
