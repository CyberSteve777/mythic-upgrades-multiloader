package net.trique.mythicupgrades;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Constants {

	public static final String MOD_ID = "mythicupgrades";
	public static final String MOD_NAME = "Mythic Upgrades";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final Random RANDOM = new Random();

	public static String getTranslationKey(String key) {
		return Constants.MOD_ID + "." + key;
	}
	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID,path);
	}

}