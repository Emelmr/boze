package dev.boze.client.settings.impl;

import dev.boze.client.settings.BooleanSetting;
import dev.boze.client.settings.MinMaxSetting;
import dev.boze.client.settings.Setting;
import dev.boze.client.settings.SettingBlock;
import dev.boze.client.settings.generic.SettingsGroup;
import net.minecraft.client.particle.*;

public class ParticleSettings implements SettingsGroup {
    public final BooleanSetting field2216 = new BooleanSetting(
            "Custom",
            false,
            "Don't render custom particles\nUse '.set norender particles add <particle>' to add particles to the list\nUse '.set norender particles del <particle>' to remove particles from the list\nUse '.set norender particles list' to list all particles in the list"
    );
    private final MinMaxSetting field2212 = new MinMaxSetting("PopParticles", 0.5, 0.0, 1.0, 0.01, "Reduce pop particles");
    private final BooleanSetting field2213 = new BooleanSetting("Potions", true, "Don't potion/status effect particles");
    private final BooleanSetting field2214 = new BooleanSetting("Explosions", true, "Don't render explosions");
    private final BooleanSetting field2215 = new BooleanSetting("ElderGuardian", false, "Don't render elder guardian particles");
    private final SettingBlock field2217 = new SettingBlock(
            "Particles", "Particles rendering settings", this.field2212, this.field2213, this.field2214, this.field2215, this.field2216
    );

    @Override
    public Setting<?>[] get() {
        return this.field2217.method472();
    }

    public boolean method1299(Particle particle) {
        if (this.field2215.getValue() && particle instanceof ElderGuardianAppearanceParticle) {
            return true;
        } else if (this.field2214.getValue() && particle instanceof ExplosionLargeParticle) {
            return true;
        } else {
            return this.field2213.getValue() && particle instanceof SpellParticle || particle instanceof TotemParticle
                    && (this.field2212.getValue() == 1.0 || this.field2212.getValue() != 0.0 && Math.random() < this.field2212.getValue());
        }
    }
}
