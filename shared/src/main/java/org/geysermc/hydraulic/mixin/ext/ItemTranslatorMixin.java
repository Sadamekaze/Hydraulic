package org.geysermc.hydraulic.mixin.ext;

import org.geysermc.geyser.translator.item.ItemTranslator;
import org.spongepowered.asm.mixin.Mixin;

// TODO: Rework for 1.20.5
@Mixin(value = ItemTranslator.class, remap = false)
public class ItemTranslatorMixin {
    //      Since translateDisplayProperties is no longer a method and the NBT library has changed
//    @ModifyReturnValue(
//            method = "translateDisplayProperties(Lorg/geysermc/geyser/session/GeyserSession;Lcom/github/steveice10/opennbt/tag/builtin/CompoundTag;Lorg/geysermc/geyser/registry/type/ItemMapping;C)Lcom/github/steveice10/opennbt/tag/builtin/CompoundTag;",
//            at = @At("RETURN")
//    )
//    private static CompoundTag translateDisplayProperties(
//        CompoundTag original,
//        @Local(argsOnly = true) CompoundTag tag,
//        @Local(argsOnly = true) ItemMapping mapping
//    ) {
//        CompoundTag newNbt = tag;
//        if (newNbt == null) {
//            newNbt = new CompoundTag("nbt");
//            CompoundTag display = new CompoundTag("display");
//            display.put(new ListTag("Lore"));
//            newNbt.put(display);
//        }
//
//        CompoundTag compoundTag = newNbt.get("display");
//        if (compoundTag == null) {
//            compoundTag = new CompoundTag("display");
//        }
//        ListTag listTag = compoundTag.get("Lore");
//
//        if (listTag == null) {
//            listTag = new ListTag("Lore");
//        }
//
//        String identifier = mapping.getJavaItem().javaIdentifier();
//
//        // Get the mod name from the identifier
//        String modId = identifier.substring(0, identifier.indexOf(":"));
//        List<ModInfo> mods = HydraulicImpl.instance().getPackManager().getNamespacesToMods().get(modId);
//        String modName = !mods.isEmpty() ? mods.get(0).name() : "Minecraft";
//
//        listTag.add(new StringTag("", "§r§9§o" + modName));
//        compoundTag.put(listTag);
//        newNbt.put(compoundTag);
//
//        return newNbt;
//    }
}
