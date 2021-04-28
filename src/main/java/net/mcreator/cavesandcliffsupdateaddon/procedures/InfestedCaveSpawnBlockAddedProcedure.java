package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.cavesandcliffsupdateaddon.block.InfestedMushroomGrassBlockBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.InfestedMushroomBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.InfestedGrassBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.InfestedGrass2Block;
import net.mcreator.cavesandcliffsupdateaddon.block.InfestedCaveSpawnBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;
import java.util.HashMap;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class InfestedCaveSpawnBlockAddedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public InfestedCaveSpawnBlockAddedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 212);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure InfestedCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure InfestedCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure InfestedCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure InfestedCaveSpawnBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.STONE.getDefaultState(), 3);
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.MUSHROOM_STEM.getDefaultState(), 3);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y + 1));
					$_dependencies.put("z", z);
					InfestedColonnumProcedure.executeProcedure($_dependencies);
				}
			}
			if ((Math.random() < 0.01)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), InfestedMushroomBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.01)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), InfestedGrassBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.01)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), InfestedGrass2Block.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), InfestedMushroomGrassBlockBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), InfestedCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), InfestedCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), InfestedCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), InfestedCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
	}
}
