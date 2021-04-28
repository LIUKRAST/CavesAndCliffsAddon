package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.cavesandcliffsupdateaddon.enchantment.VeinOffEnchantment;
import net.mcreator.cavesandcliffsupdateaddon.enchantment.VeinEnchantment;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class TestOnKeyPressedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public TestOnKeyPressedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 194);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency entity for procedure TestOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((EnchantmentHelper.getEnchantmentLevel(VeinEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			{
				Map<Enchantment, Integer> _enchantments = EnchantmentHelper
						.getEnchantments(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
				if (_enchantments.containsKey(VeinEnchantment.enchantment)) {
					_enchantments.remove(VeinEnchantment.enchantment);
					EnchantmentHelper.setEnchantments(_enchantments,
							((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
				}
			}
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
					.addEnchantment(VeinOffEnchantment.enchantment, (int) 1);
		} else {
			if (((EnchantmentHelper.getEnchantmentLevel(VeinOffEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper
							.getEnchantments(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
					if (_enchantments.containsKey(VeinOffEnchantment.enchantment)) {
						_enchantments.remove(VeinOffEnchantment.enchantment);
						EnchantmentHelper.setEnchantments(_enchantments,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
					}
				}
				(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
						.addEnchantment(VeinEnchantment.enchantment, (int) 1);
			}
		}
	}
}
