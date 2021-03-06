package com.gmail.andrewandy.ascendancy.serverplugin.items.spell;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.Projectile;

import java.util.Optional;
import java.util.Set;

public interface ISpellEngine {

    void registerSpell(@NotNull Spell spell);

    void unregisterSpell(@NotNull Spell spell);

    boolean isRegistered(@NotNull Spell spell);

    @NotNull Optional<@NotNull Spell> getSpellFromProjectile(final Projectile projectile);

    default boolean isProjectileSpell(@NotNull Projectile projectile) {
        return getSpellFromProjectile(projectile).isPresent();
    }

    @NotNull Set<@NotNull Spell> getRegisteredSpells();

    @NotNull Set<@NotNull SpellCondition> getSpellConditions();

    @NotNull Set<SpellCondition.@NotNull Handler> getHandlers(@NotNull SpellCondition condition);

    void registerSpellCondition(@NotNull SpellCondition condition);

    void removeSpellCondition(@NotNull SpellCondition condition);

    void registerSpellConditionHandler(@NotNull SpellCondition condition, @NotNull SpellCondition.Handler handler);

    void removeSpellConditionHandler(@NotNull SpellCondition condition, @NotNull SpellCondition.Handler consumer);

    void clearSpellConditions();

    void clearSpellConditionHandlers(@NotNull SpellCondition condition);

    @NotNull Optional<Projectile> castSpell(@NotNull Spell spell, @NotNull Player caster);

}
