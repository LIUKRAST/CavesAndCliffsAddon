package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.cavesandcliffsupdateaddon.block.RedprismarineBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GreenPrismarineBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowingVineEndBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowingKelpTopV2Block;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowingKelpBlockBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowingKelpBlock2Block;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowingBushBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowFlowerBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.GlowCaveSpawnBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.BluePrismarineBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;
import java.util.HashMap;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class GlowCaveSpawnBlockAddedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public GlowCaveSpawnBlockAddedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 218);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure GlowCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure GlowCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure GlowCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure GlowCaveSpawnBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.STONE.getDefaultState(), 3);
		if ((Math.random() < 0.3)) {
			if ((Math.random() < 0.5)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), GlowingKelpBlockBlock.block.getDefaultState(), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), GlowingKelpBlock2Block.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GlowingKelpBlockBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GlowingKelpBlock2Block.block.getDefaultState()
						.getBlock()))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
				if ((Math.random() < 0.1)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), GlowFlowerBlock.block.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), GlowingKelpTopV2Block.block.getDefaultState(), 3);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y + 1));
					$_dependencies.put("z", z);
					UnderwaterGrowProcedure.executeProcedure($_dependencies);
				}
			}
			if ((Math.random() < 0.1)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y + 1));
					$_dependencies.put("z", z);
					LilypadProcedure.executeProcedure($_dependencies);
				}
			}
		}
		if ((Math.random() < 0.1)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.PRISMARINE.getDefaultState(), 3);
			if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if ((Math.random() < 0.25)) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.PRISMARINE.getDefaultState(), 3);
				} else {
					if ((Math.random() < 0.3)) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), GreenPrismarineBlock.block.getDefaultState(), 3);
					} else {
						if ((Math.random() < 0.9)) {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), BluePrismarineBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), RedprismarineBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if ((Math.random() < 0.25)) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.PRISMARINE.getDefaultState(), 3);
				} else {
					if ((Math.random() < 0.3)) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), GreenPrismarineBlock.block.getDefaultState(), 3);
					} else {
						if ((Math.random() < 0.9)) {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), BluePrismarineBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), RedprismarineBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if ((Math.random() < 0.25)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.PRISMARINE.getDefaultState(), 3);
				} else {
					if ((Math.random() < 0.3)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), GreenPrismarineBlock.block.getDefaultState(), 3);
					} else {
						if ((Math.random() < 0.9)) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), BluePrismarineBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), RedprismarineBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if ((Math.random() < 0.25)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.PRISMARINE.getDefaultState(), 3);
				} else {
					if ((Math.random() < 0.3)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), GreenPrismarineBlock.block.getDefaultState(), 3);
					} else {
						if ((Math.random() < 0.9)) {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), BluePrismarineBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), RedprismarineBlock.block.getDefaultState(), 3);
						}
					}
				}
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock()))) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), GlowingVineEndBlock.block.getDefaultState(), 3);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y - 1));
					$_dependencies.put("z", z);
					GlowVineGrowProcedure.executeProcedure($_dependencies);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), GlowingBushBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), GlowCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), GlowCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), GlowCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), GlowCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
	}
}
