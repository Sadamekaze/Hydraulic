package org.geysermc.hydraulic.mixin.ext;

import java.util.List;

import javax.annotation.Nullable;

import org.cloudburstmc.protocol.bedrock.data.inventory.ItemData;
import org.geysermc.geyser.item.type.Item;
import org.geysermc.geyser.registry.type.ItemMapping;
import org.geysermc.geyser.session.GeyserSession;
import org.geysermc.geyser.translator.item.ItemTranslator;
import org.geysermc.hydraulic.HydraulicImpl;
import org.geysermc.hydraulic.platform.mod.ModInfo;
import org.geysermc.mcprotocollib.protocol.data.game.item.component.DataComponentType;
import org.geysermc.mcprotocollib.protocol.data.game.item.component.DataComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.kyori.adventure.text.Component;

@Mixin(value = ItemTranslator.class, remap = false)
public class ItemTranslatorMixin {
    @Inject(
        method = "translateToBedrock",
        at = @At("RETURN")
    )
    public static void translateToBedrock(
        GeyserSession session,
        Item javaItem,
        ItemMapping bedrockItem,
        int count,
        @Nullable DataComponents components,
        CallbackInfoReturnable<ItemData.Builder> cir
    ) {
        if (components != null) {
            List<ModInfo> mods = HydraulicImpl.instance().getPackManager().getNamespacesToMods().get(javaItem.javaIdentifier().split(":")[0]);
            String modName = !mods.isEmpty() ? mods.get(0).name() : "Minecraft";

            components.getOrDefault(DataComponentType.LORE, List.<Component>of()).add(
                Component.text("§r§9§o" + modName)
            );
        }
    }
}