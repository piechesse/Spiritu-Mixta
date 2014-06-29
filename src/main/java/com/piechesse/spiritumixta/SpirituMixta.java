package com.piechesse.spiritumixta;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.piechesse.spiritumixta.item.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "spiritumixta", version = "1.7.2-1.0", name = "Spiritu Mixta")
public class SpirituMixta {
	public static final String MODID = "spiritumixta";
	public static final String VERSION = "1.7.2-1.0";
	public static final String NAME = "Spiritu Mixta";
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

	@EventHandler
	public void preInitialization(FMLPreInitializationEvent event) {
		ModItems.init();
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
