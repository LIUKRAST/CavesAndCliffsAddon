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

import net.mcreator.cavesandcliffsupdateaddon.block.IcyStoneBlock;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class IcyCaveStructureUpdateTickProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public IcyCaveStructureUpdateTickProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 203);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure IcyCaveStructureUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure IcyCaveStructureUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure IcyCaveStructureUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure IcyCaveStructureUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"fill ~-15 ~-15 ~-15 ~15 ~15 ~15 caves_and_cliffs_update_addon:icy_cave_spawn replace stone");
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), IcyStoneBlock.block.getDefaultState(), 3);
	}
}
