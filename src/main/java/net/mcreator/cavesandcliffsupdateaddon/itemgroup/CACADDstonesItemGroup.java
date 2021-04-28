
package net.mcreator.cavesandcliffsupdateaddon.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cavesandcliffsupdateaddon.block.IceStoneBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class CACADDstonesItemGroup extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public CACADDstonesItemGroup(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcacad_dstones") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IceStoneBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
