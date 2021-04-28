package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class IcyWaterMobplayerCollidesBlockProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public IcyWaterMobplayerCollidesBlockProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 90);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency entity for procedure IcyWaterMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.CACTUS, (float) 2);
	}
}
