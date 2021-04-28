package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.cavesandcliffsupdateaddon.block.InfestedMushroomBlockBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;
import java.util.HashMap;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class InfestedColonnumProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public InfestedColonnumProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 213);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure InfestedColonnum!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure InfestedColonnum!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure InfestedColonnum!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure InfestedColonnum!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.MUSHROOM_STEM.getDefaultState(), 3);
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y + 1));
				$_dependencies.put("z", z);
				InfestedColonnumProcedure.executeProcedure($_dependencies);
			}
			if ((Math.random() < 0.3)) {
				if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), InfestedMushroomBlockBlock.block.getDefaultState(), 3);
				}
			}
			if ((Math.random() < 0.3)) {
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), InfestedMushroomBlockBlock.block.getDefaultState(), 3);
				}
			}
			if ((Math.random() < 0.3)) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), InfestedMushroomBlockBlock.block.getDefaultState(), 3);
				}
			}
			if ((Math.random() < 0.3)) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), InfestedMushroomBlockBlock.block.getDefaultState(), 3);
				}
			}
		} else {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), InfestedMushroomBlockBlock.block.getDefaultState(), 3);
			}
		}
	}
}
