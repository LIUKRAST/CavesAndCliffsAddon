
package net.mcreator.cavesandcliffsupdateaddon.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDLavaItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class RedstoneCrystalShardItem extends CavesAndCliffsUpdateAddonModElements.ModElement {
	@ObjectHolder("caves_and_cliffs_update_addon:redstone_crystal_shard")
	public static final Item block = null;
	public RedstoneCrystalShardItem(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CACADDLavaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("redstone_crystal_shard");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
