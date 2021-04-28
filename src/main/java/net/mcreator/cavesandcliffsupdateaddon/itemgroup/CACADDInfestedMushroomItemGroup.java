
package net.mcreator.cavesandcliffsupdateaddon.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cavesandcliffsupdateaddon.block.InfestedMushroomGrassBlockBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class CACADDInfestedMushroomItemGroup extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public CACADDInfestedMushroomItemGroup(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 133);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcacadd_infested_mushroom") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(InfestedMushroomGrassBlockBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
