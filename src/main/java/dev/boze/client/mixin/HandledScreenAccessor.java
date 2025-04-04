package dev.boze.client.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface HandledScreenAccessor {
    @Accessor
    int getBackgroundWidth();

    @Accessor
    int getBackgroundHeight();

    @Accessor("x")
    int getX();

    @Accessor("y")
    int getY();
}
