
package net.mcreator.cavesandcliffsupdateaddon.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.cavesandcliffsupdateaddon.item.DriedGlowingKelpItem;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class GlowingKelpBlockFuelFuel extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public GlowingKelpBlockFuelFuel(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 52);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DriedGlowingKelpItem.block, (int) (1)).getItem())
			event.setBurnTime(1000);
	}
}
