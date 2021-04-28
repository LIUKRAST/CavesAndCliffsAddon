package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.cavesandcliffsupdateaddon.block.IcyStoneBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.IcyGrassBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class IcyGrassUpdateTickProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public IcyGrassUpdateTickProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure IcyGrassUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure IcyGrassUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure IcyGrassUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure IcyGrassUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.1)) {
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), IcyStoneBlock.block.getDefaultState(), 3);
				}
			}
		}
		if ((Math.random() < 0.001)) {
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == IcyStoneBlock.block.getDefaultState()
					.getBlock())) {
				if ((!(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)).isSolid()))) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), IcyGrassBlock.block.getDefaultState(), 3);
				}
			}
		}
		if ((Math.random() < 0.001)) {
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == IcyStoneBlock.block.getDefaultState()
					.getBlock())) {
				if ((!(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)).isSolid()))) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), IcyGrassBlock.block.getDefaultState(), 3);
				}
			}
		}
		if ((Math.random() < 0.001)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == IcyStoneBlock.block.getDefaultState()
					.getBlock())) {
				if ((!(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))).isSolid()))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), IcyGrassBlock.block.getDefaultState(), 3);
				}
			}
		}
		if ((Math.random() < 0.001)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == IcyStoneBlock.block.getDefaultState()
					.getBlock())) {
				if ((!(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))).isSolid()))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), IcyGrassBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
