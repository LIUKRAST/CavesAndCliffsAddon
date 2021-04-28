package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class EruptingColumnClientDisplayRandomTickProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public EruptingColumnClientDisplayRandomTickProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 107);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure EruptingColumnClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure EruptingColumnClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure EruptingColumnClientDisplayRandomTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure EruptingColumnClientDisplayRandomTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double PosY = 0;
		PosY = (double) (y + 1);
		for (int index0 = 0; index0 < (int) (10); index0++) {
			if (((world.isRemote()) == (true))) {
				if ((Math.random() < 0.3)) {
					world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, (x + 0.5), (y + 0.5), (z + 0.5), 0, 0, 0);
					world.addParticle(ParticleTypes.LAVA, (x + 0.5), (y + 0.5), (z + 0.5), 0, 0, 0);
				}
			}
			PosY = (double) ((PosY) + 1);
		}
	}
}
