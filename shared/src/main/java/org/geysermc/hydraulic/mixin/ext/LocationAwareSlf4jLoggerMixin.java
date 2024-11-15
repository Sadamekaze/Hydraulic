package org.geysermc.hydraulic.mixin.ext;

import org.slf4j.helpers.FormattingTuple;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(targets = "io.netty.util.internal.logging.LocationAwareSlf4JLogger", remap = false)
public class LocationAwareSlf4jLoggerMixin {
    @Redirect(
        method = "log(ILorg/slf4j/helpers/FormattingTuple;)V",
        at = @At(
            value = "INVOKE",
            target = "Lorg/slf4j/helpers/FormattingTuple;getArgArray()[Ljava/lang/Object;"
        )
    )
    private Object[] getArgArray(FormattingTuple instance) {
        return null;
    }
}
