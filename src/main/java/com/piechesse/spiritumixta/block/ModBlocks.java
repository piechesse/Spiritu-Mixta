package com.piechesse.spiritumixta.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static Block secularFabricator;
	public static Block spiritStone;

	public static void init() {
		secularFabricator = new SMBlock(Material.rock, "secularFabricator");
		register(secularFabricator);
		spiritStone = new SMBlock(Material.rock, "spiritStone");
		register(spiritStone);
	}

	public static void register(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));

	}
}
