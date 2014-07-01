package com.piechesse.spiritumixta.handler;

import java.io.File;
import java.io.FileNotFoundException;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	public static void init(File file) {
		Configuration config = new Configuration(file);
		try {
			config.load();
		} catch (Exception e) {
			
		} finally {
			config.save();
		}
	}
}
