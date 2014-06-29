package com.piechesse.spiritumixta.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item swordSacrifice;
	public static Item spirit;
	public static Item fracturedSpirit;

	public static void init() {
		swordSacrifice = new SwordSacrifice();
		register(swordSacrifice);
		spirit = new ItemSpirit();
		register(spirit);
		fracturedSpirit = new ItemSpiritFractured();
		register(fracturedSpirit);
	}
	
	public static void register(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		
	}

}
