package com.piechesse.knickknacks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.piechesse.knickknacks.items.baubles.BeltMovement;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Knickknacks.MODID, version = Knickknacks.VERSION, name = Knickknacks.NAME)
public class Knickknacks {

	public static final Item beltMovement = new BeltMovement();
	public static final String MODID = "knickknacks";
	public static final String VERSION = "1.7.2-1.0";
	public static final String NAME = "Knick Knacks";
	public static CreativeTabs tabKnickkacks = new CreativeTabs(
			"tabKnickKnacks") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.melon_seeds, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return Items.melon_seeds;
		}
	};

	@EventHandler
	public void preInitialization(FMLPreInitializationEvent event) {

		GameRegistry.registerItem(beltMovement, beltMovement
				.getUnlocalizedName().substring(5));
	}

	@EventHandler
	public void initialization(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {

	}

}
