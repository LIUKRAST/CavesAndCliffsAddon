package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteSpikeBodyBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteSpikeBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteBodyBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalagmiteBaseBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteSpkeBodyNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteSpikeNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteBodyNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.block.StalactiteBaseNOBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class DripstoneBlockAddedProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public DripstoneBlockAddedProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 202);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure DripstoneBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure DripstoneBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure DripstoneBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure DripstoneBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Direction.DOWN == (new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					if (property != null)
						return _bs.get(property);
					return Direction.getFacingFromAxisDirection(
							_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
							Direction.AxisDirection.POSITIVE);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalactiteSpikeNOBlock.block.getDefaultState(), 3);
			if ((StalactiteSpikeNOBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), StalactiteSpkeBodyNOBlock.block.getDefaultState(), 3);
			}
			if ((StalactiteSpkeBodyNOBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))
					.getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), StalactiteBodyNOBlock.block.getDefaultState(), 3);
			}
			if ((StalactiteBodyNOBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z)))
					.getBlock())) {
				if ((!(StalactiteBaseNOBlock.block.getDefaultState()
						.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock()))) {
					if ((!(StalactiteBodyNOBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock()))) {
						world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), StalactiteBaseNOBlock.block.getDefaultState(), 3);
					}
				}
			}
		} else {
			if ((Direction.UP == (new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) x, (int) y, (int) z))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalagmiteSpikeBlock.block.getDefaultState(), 3);
				if ((StalagmiteSpikeBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), StalagmiteSpikeBodyBlock.block.getDefaultState(), 3);
				}
				if ((StalagmiteSpikeBodyBlock.block.getDefaultState()
						.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), StalagmiteBodyBlock.block.getDefaultState(), 3);
				}
				if ((StalagmiteBodyBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z)))
						.getBlock())) {
					if ((!(StalagmiteBaseBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock()))) {
						if ((!(StalagmiteBodyBlock.block.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock()))) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 3), (int) z), StalagmiteBaseBlock.block.getDefaultState(), 3);
						}
					}
				}
			} else {
				if ((StalagmiteSpikeBlock.block.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalagmiteSpikeBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), StalagmiteSpikeBodyBlock.block.getDefaultState(), 3);
					if ((StalagmiteSpikeBodyBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) (y - 2), (int) z), StalagmiteBodyBlock.block.getDefaultState(), 3);
					}
					if ((StalagmiteBodyBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock())) {
						if ((!(StalagmiteBaseBlock.block.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock()))) {
							if ((!(StalagmiteBodyBlock.block.getDefaultState()
									.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 4), (int) z))).getBlock()))) {
								world.setBlockState(new BlockPos((int) x, (int) (y - 3), (int) z), StalagmiteBaseBlock.block.getDefaultState(), 3);
							}
						}
					}
				} else {
					if ((StalactiteSpikeNOBlock.block.getDefaultState()
							.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalactiteSpikeNOBlock.block.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), StalactiteSpkeBodyNOBlock.block.getDefaultState(), 3);
						if ((StalactiteSpkeBodyNOBlock.block.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock())) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 2), (int) z), StalactiteBodyNOBlock.block.getDefaultState(), 3);
						}
						if ((StalactiteBodyNOBlock.block.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock())) {
							if ((!(StalactiteBaseNOBlock.block.getDefaultState()
									.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock()))) {
								if ((!(StalactiteBodyNOBlock.block.getDefaultState()
										.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock()))) {
									world.setBlockState(new BlockPos((int) x, (int) (y + 3), (int) z), StalactiteBaseNOBlock.block.getDefaultState(),
											3);
								}
							}
						}
					} else {
						if ((!(Blocks.SNOW.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
								.getBlock()))) {
							if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid())) {
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalagmiteSpikeBlock.block.getDefaultState(), 3);
							} else {
								if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)).isSolid())) {
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StalactiteSpikeNOBlock.block.getDefaultState(), 3);
								} else {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
												new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
									}
								}
							}
						} else {
							if (world instanceof World) {
								Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
										new BlockPos((int) x, (int) y, (int) z));
								world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
							}
						}
					}
				}
			}
		}
	}
}
