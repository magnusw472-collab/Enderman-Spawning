# No Endermen — Fabric mod for 1.21.11

Removes Endermen the instant they load into the world, from any source:
natural spawning, mob spawners, spawn eggs, or /summon. No commands, no
config - it just runs passively.

## How it works

Endermen are technically classified as "monster" (hostile) type mobs for
spawn-cap purposes, not "passive" - so a passive-mob-cap setting would
never have affected them. This mod instead hooks
`ServerEntityEvents.ENTITY_LOAD`, which fires the instant any entity
becomes real in the world, regardless of why. If that entity is an
Enderman, it's immediately discarded.

Trade-off: this is a "let it spawn, then instantly remove it" approach
rather than truly preventing the spawn attempt (Fabric API for 1.21.11
doesn't expose a documented "cancel spawn" event for this). In practice
the difference is imperceptible - the entity never gets a chance to act,
move, or be meaningfully seen before it's gone.

## Setup

Same process as the other two mods:

1. Create a **new, separate GitHub repository**.
2. Unzip this project, drag its contents (`build.gradle`, `settings.gradle`,
   `gradle.properties`, `README.md`, `src`, `.github`) directly into the
   upload box - not the outer folder itself.
3. Confirm they land at the repo's root, not nested in a subfolder.
4. Check Actions - should build clean using the same proven Gradle/Fabric
   versions as the other two mods.
5. Download `no-endermen-jar` from Artifacts, unzip once to get
   `no-endermen-1.0.0.jar`.
6. Drop it into `mods/` alongside your Last Stand and Elytra Remover jars
   - all coexist fine.
7. Restart the server.
