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

import net.mcreator.cavesandcliffsupdateaddon.block.IcyStoneStairsBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.IcyStoneSlabsBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.IcyStoneBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.IcyGrassBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.IcyCaveSpawnBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.DripstoneBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class IcyCaveSpawnBlockAddedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public IcyCaveSpawnBlockAddedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 201);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure IcyCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure IcyCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure IcyCaveSpawnBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure IcyCaveSpawnBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), IcyStoneBlock.block.getDefaultState(), 3);
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), DripstoneBlock.block.getDefaultState(), 3);
				if (((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.5)) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), DripstoneBlock.block.getDefaultState(), 3);
						if (((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
								.getBlock())) {
							if ((Math.random() < 0.5)) {
								world.setBlockState(new BlockPos((int) x, (int) (y - 3), (int) z), DripstoneBlock.block.getDefaultState(), 3);
								if ((Math.random() < 0.5)) {
									if (((world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock() == Blocks.CAVE_AIR
											.getDefaultState().getBlock())) {
										world.setBlockState(new BlockPos((int) x, (int) (y - 4), (int) z), DripstoneBlock.block.getDefaultState(), 3);
									}
								}
							}
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == IcyStoneSlabsBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == IcyStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_stairs[facing=east,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == IcyStoneSlabsBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == IcyStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_stairs[facing=west,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == IcyStoneSlabsBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == IcyStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_stairs[facing=south,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_slab[half=top]");
							}
						}
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == IcyStoneSlabsBlock.block
						.getDefaultState().getBlock()))) {
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == IcyStoneStairsBlock.block
							.getDefaultState().getBlock()))) {
						if ((Math.random() < 0.5)) {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_stairs[facing=north,half=top]");
							}
						} else {
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager().handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y - 1), z), Vector2f.ZERO, (ServerWorld) world, 4,
												"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"setblock ~ ~ ~ caves_and_cliffs_update_addon:icy_stone_slab[half=top]");
							}
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if ((Math.random() < 0.1)) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), DripstoneBlock.block.getDefaultState(), 3);
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.5)) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), DripstoneBlock.block.getDefaultState(), 3);
						if (((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
								.getBlock())) {
							if ((Math.random() < 0.5)) {
								world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), DripstoneBlock.block.getDefaultState(), 3);
								if ((Math.random() < 0.5)) {
									if (((world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock() == Blocks.CAVE_AIR
											.getDefaultState().getBlock())) {
										world.setBlockState(new BlockPos((int) x, (int) (y + 4), (int) z), DripstoneBlock.block.getDefaultState(), 3);
									}
								}
							}
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), IcyGrassBlock.block.getDefaultState(), 3);
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 2)))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=2]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 2)))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=2]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) z))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=2]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 1), (int) z))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=2]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=4]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=4]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=4]");
					}
				}
			}
			if ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)).isSolid())) {
				if ((!((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.SNOW.getDefaultState()
						.getBlock()))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, (y + 1), z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"setblock ~ ~ ~ snow[layers=4]");
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), IcyCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), IcyCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), IcyCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), IcyCaveSpawnBlock.block.getDefaultState(), 3);
			}
		}
	}
}
