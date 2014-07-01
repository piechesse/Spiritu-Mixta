package com.piechesse.spiritumixta;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.piechesse.spiritumixta.handler.ConfigurationHandler;
import com.piechesse.spiritumixta.item.ModItems;
import com.piechesse.spiritumixta.proxy.IProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME)
public class SpirituMixta {

	public static CreativeTabs tabSpirituMixta = new CreativeTabs(
			"tabSpirituMixta") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(ModItems.fracturedSpirit, 1, 1);
		}

		@Override
		public Item getTabIconItem() {
			return ModItems.fracturedSpirit;
		}
	};

	@Instance("spiritumixta")
	public static SpirituMixta spirituMixta;
	
	//@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static IProxy proxy;

	@EventHandler
	public void preInitialization(FMLPreInitializationEvent event) {
		ModItems.init();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void initialization(FMLInitializationEvent event) {
		GameRegistry.addRecipe(new ItemStack(ModItems.swordSacrifice), "  g",
				"ig ", "si ", 'g', Blocks.glass, 'i', Items.iron_ingot, 's',
				Items.stick);
	}

	@EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {

	}
}
