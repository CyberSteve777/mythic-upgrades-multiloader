package net.trique.mythicupgrades.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.trique.mythicupgrades.Constants;
import net.trique.mythicupgrades.registry.MUDamageTypes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MUDamageTypeTagProvider extends DamageTypeTagsProvider {
    public MUDamageTypeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DamageTypeTags.BYPASSES_ARMOR).add(
                MUDamageTypes.DEFLECTING_DAMAGE_TYPE,
                MUDamageTypes.PERCENTAGE_DAMAGE_TYPE
        );
        tag(DamageTypeTags.BYPASSES_COOLDOWN).add(
                MUDamageTypes.DEFLECTING_DAMAGE_TYPE
        );
        tag(DamageTypeTags.BYPASSES_EFFECTS).add(
                MUDamageTypes.DEFLECTING_DAMAGE_TYPE,
                MUDamageTypes.PERCENTAGE_DAMAGE_TYPE
        );
    }
}
