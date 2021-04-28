package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.cavesandcliffsupdateaddon.block.RedstoneCrystalBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.LavaStoneStairsBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.LavaStoneSlabBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.LavaStone1Block;
import net.mcreator.cavesandcliffsupdateaddon.block.LavaGrassBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.LavaCaveSpawnBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;
import java.util.HashMap;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class LavaCaveSpawnBlockAddedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public LavaCaveSpawnBlockAddedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 207);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure LavaCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure LavaCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure LavaCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure LavaCaveSpawnBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LavaStone1Block.block.getDefaultState(), 3);
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), RedstoneCrystalBlock.block.getDefaultState(), 3);
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", (y + 1));
					$_dependencies.put("z", z);
					ErColProcedure.executeProcedure($_dependencies);
				}
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == LavaStoneSlabBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == LavaStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_stairs[facing=east,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == LavaStoneSlabBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == LavaStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_stairs[facing=west,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == LavaStoneSlabBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == LavaStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_stairs[facing=south,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == LavaStoneSlabBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == LavaStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_stairs[facing=north,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:lava_stone_slab[half=top]");
							}
						}
					}
				}
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LavaGrassBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.NETHERRACK.getDefaultState()
						.getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), LavaCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.NETHERRACK.getDefaultState()
						.getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), LavaCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.NETHERRACK.getDefaultState()
						.getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), LavaCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.NETHERRACK.getDefaultState()
						.getBlock()))) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), LavaCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
	}
}
