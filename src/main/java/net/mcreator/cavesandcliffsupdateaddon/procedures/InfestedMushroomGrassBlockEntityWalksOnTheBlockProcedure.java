package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cavesandcliffsupdateaddon.item.SugiliteArmorItem;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class InfestedMushroomGrassBlockEntityWalksOnTheBlockProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public InfestedMushroomGrassBlockEntityWalksOnTheBlockProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CavesAndCliffsUpdateAddonMod.LOGGER
						.warn("Failed to load dependency entity for procedure InfestedMushroomGrassBlockEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(((entity instanceof LivingEntity)
				? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
				: ItemStack.EMPTY).getItem() == new ItemStack(SugiliteArmorItem.boots, (int) (1)).getItem()))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 120, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 120, (int) 1, (false), (false)));
		}
	}
}
