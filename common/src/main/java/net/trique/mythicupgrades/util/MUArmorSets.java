package net.trique.mythicupgrades.util;

import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.effect_armor_set.*;

public class MUArmorSets {
    public static AquamarineArmorSet AQUAMARINE_SET = new AquamarineArmorSet();
    public static PeridotArmorSet PERIDOT_SET = new PeridotArmorSet();
    public static TopazArmorSet TOPAZ_SET = new TopazArmorSet();
    public static RubyArmorSet RUBY_SET = new RubyArmorSet();
    public static SapphireArmorSet SAPPHIRE_SET = new SapphireArmorSet();
    public static JadeArmorSet JADE_SET = new JadeArmorSet();
    public static AmetrineArmorSet AMETRINE_SET = new AmetrineArmorSet();


    public static void init() {
        Constants.LOGGER.info("Initializing Effect Armor Sets");
    }
}
