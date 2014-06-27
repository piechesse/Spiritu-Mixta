package com.piechesse.spiritumixta;

import com.piechesse.spiritumixta.item.ModItems;
import com.piechesse.spiritumixta.item.SwordSacrifice;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Piechesse on 6/23/2014.
 */
@Mod(modid = "spiritumixta", version = "1.7.2-1.0", name = "Spiritu Mixta")
public class SpirituMixta {
	public static final String MODID = "spiritumixta";
	public static final String VERSION = "1.7.2-1.0";
	public static final String NAME = "Spiritu Mixta";
	public static CreativeTabs tabSpirituMixta = new CreativeTabs(
			"tabSpirituMixta") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.arrow, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return Items.arrow;
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

	}

	@EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {

	}
}
