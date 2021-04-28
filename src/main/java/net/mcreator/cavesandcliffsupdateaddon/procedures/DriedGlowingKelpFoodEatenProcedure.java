package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class DriedGlowingKelpFoodEatenProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public DriedGlowingKelpFoodEatenProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency entity for procedure DriedGlowingKelpFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 480, (int) 1));
	}
}
