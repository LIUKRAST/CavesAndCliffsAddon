
package net.mcreator.cavesandcliffsupdateaddon.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.cavesandcliffsupdateaddon.item.SugilitePickaxeItem;
import net.mcreator.cavesandcliffsupdateaddon.item.JadePickaxeItem;
import net.mcreator.cavesandcliffsupdateaddon.item.CopperpickaxeItem;
import net.mcreator.cavesandcliffsupdateaddon.item.AmethystPickaxeItem;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class VeinEnchantment extends CavesAndCliffsUpdateAddonModElements.ModElement {
	@ObjectHolder("caves_and_cliffs_update_addon:vein")
	public static final Enchantment enchantment = null;
	public VeinEnchantment(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 176);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("vein"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		protected boolean canApplyTogether(Enchantment ench) {
			if (ench == Enchantments.UNBREAKING)
				return true;
			if (ench == Enchantments.EFFICIENCY)
				return true;
			if (ench == Enchantments.MENDING)
				return true;
			return false;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(CopperpickaxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(AmethystPickaxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(JadePickaxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(SugilitePickaxeItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.WOODEN_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_PICKAXE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_PICKAXE, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
