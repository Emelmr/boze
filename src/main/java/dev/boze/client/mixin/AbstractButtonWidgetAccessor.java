package dev.boze.client.mixin;

import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClickableWidget.class)
public interface AbstractButtonWidgetAccessor {
    @Accessor("message")
    void setText(Text var1);
}
