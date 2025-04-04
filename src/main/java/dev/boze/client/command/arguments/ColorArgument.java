package dev.boze.client.command.arguments;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.boze.client.systems.modules.client.Colors;
import net.minecraft.command.CommandSource;
import net.minecraft.text.Text;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ColorArgument implements ArgumentType<String> {
    private static final DynamicCommandExceptionType field1854 = new DynamicCommandExceptionType(ColorArgument::lambda$static$0);

    private ColorArgument() {
    }

    public static ColorArgument method984() {
        return new ColorArgument();
    }

    public static String method985(CommandContext<?> context, String name) {
        return context.getArgument(name, String.class);
    }

    private static Message lambda$static$0(Object var0) {
        return Text.literal("Color with name " + var0 + " doesn't exist");
    }

    @Override
    public String parse(StringReader reader) throws CommandSyntaxException {
        String var5 = reader.readString();
        String var6 = null;

        for (String var8 : Colors.INSTANCE.field2343.keySet()) {
            if (var8.equalsIgnoreCase(var5)) {
                var6 = var8;
                break;
            }
        }

        if (var6 == null) {
            throw field1854.create(var5);
        } else {
            return var6;
        }
    }

    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return CommandSource.suggestMatching(Colors.INSTANCE.field2343.keySet(), builder);
    }

    // $VF: synthetic method
    // $VF: bridge method
    //public Object parse(StringReader stringReader) throws CommandSyntaxException {
    //   return this.method986(stringReader);
    //}

    public Collection<String> getExamples() {
        return Colors.INSTANCE.field2343.keySet().stream().limit(3L).collect(Collectors.toList());
    }
}
