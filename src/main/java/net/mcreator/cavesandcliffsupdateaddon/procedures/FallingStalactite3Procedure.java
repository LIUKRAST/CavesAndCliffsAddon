package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteBodyNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteBodyFABlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteBaseNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class FallingStalactite3Procedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public FallingStalactite3Procedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure FallingStalactite3!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure FallingStalactite3!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure FallingStalactite3!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure FallingStalactite3!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid()))) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == StalactiteBodyNOBlock.block.getDefaultState()
					.getBlock()))) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == StalactiteBaseNOBlock.block
						.getDefaultState().getBlock()))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalactiteBodyFABlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
