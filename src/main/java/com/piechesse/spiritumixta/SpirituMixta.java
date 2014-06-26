package com.piechesse.spiritumixta;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Piechesse on 6/23/2014.
 */
@Mod(modid = "spiritumixta", version = "1.7.2-1.0", name = "Spiritu Mixta")
public class SpirituMixta {
	
	 public static CreativeTabs tabBloodMagic = new CreativeTabs("tabSpirituMixta")
	    {
	    	@Override
	        public ItemStack getIconItemStack()
	        {
	            return new ItemStack(Items.arrow, 1, 0);
	        }

			@Override
			public Item getTabIconItem() 
			{
				return Items.arrow;
			}
	    };
	
	@Instance("spiritumixta")
	public static SpirituMixta spirituMixta;

	@SubscribeEvent
	public void preInitialization(FMLPreInitializationEvent event) {
	}

	@SubscribeEvent
	public void initialization(FMLInitializationEvent event) {

	}

	@SubscribeEvent
	public void postInitialization(FMLPostInitializationEvent event) {

	}
}
