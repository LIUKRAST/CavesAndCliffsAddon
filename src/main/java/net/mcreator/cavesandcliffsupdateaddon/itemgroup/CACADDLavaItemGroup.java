
package net.mcreator.cavesandcliffsupdateaddon.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cavesandcliffsupdateaddon.block.LavaGrassBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class CACADDLavaItemGroup extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public CACADDLavaItemGroup(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 96);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcacadd_lava") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LavaGrassBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
