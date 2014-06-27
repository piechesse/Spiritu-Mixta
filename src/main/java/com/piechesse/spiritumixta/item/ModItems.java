package com.piechesse.spiritumixta.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item swordSacrifice = new SwordSacrifice();

	public static void init() {
		GameRegistry.registerItem(swordSacrifice, swordSacrifice.getUnlocalizedName().substring(5));
	}

}
