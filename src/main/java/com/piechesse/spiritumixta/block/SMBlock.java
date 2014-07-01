package com.piechesse.spiritumixta.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.piechesse.spiritumixta.Reference;
import com.piechesse.spiritumixta.SpirituMixta;

public class SMBlock extends Block {

	protected SMBlock(Material material, String string) {
		super(material);
		setBlockName(string);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(SpirituMixta.tabSpirituMixta);
	}
}
