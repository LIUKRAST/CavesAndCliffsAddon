
package net.mcreator.cavesandcliffsupdateaddon.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDInfestedMushroomItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class SugiliteHoeItem extends CavesAndCliffsUpdateAddonModElements.ModElement {
	@ObjectHolder("caves_and_cliffs_update_addon:sugilite_hoe")
	public static final Item block = null;
	public SugiliteHoeItem(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 148);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 9768;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 0, -3f, new Item.Properties().group(CACADDInfestedMushroomItemGroup.tab)) {
		}.setRegistryName("sugilite_hoe"));
	}
}
