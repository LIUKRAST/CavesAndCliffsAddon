
package net.mcreator.cavesandcliffsupdateaddon.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.cavesandcliffsupdateaddon.block.GlowingKelpBlock2Block;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class DriedGlowingKelpBlockFuelFuel extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public DriedGlowingKelpBlockFuelFuel(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 51);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(GlowingKelpBlock2Block.block, (int) (1)).getItem())
			event.setBurnTime(9000);
	}
}
