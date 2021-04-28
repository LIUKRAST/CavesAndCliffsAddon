package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteSpikeBodyBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteBodyBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteBaseBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class StalagmiteProcedureProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public StalagmiteProcedureProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 84);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure StalagmiteProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure StalagmiteProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure StalagmiteProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure StalagmiteProcedure!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid()))) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == StalagmiteSpikeBodyBlock.block.getDefaultState()
					.getBlock()))) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == StalagmiteBodyBlock.block.getDefaultState()
						.getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == StalagmiteBaseBlock.block
							.getDefaultState().getBlock()))) {
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					}
				}
			}
		}
	}
}
