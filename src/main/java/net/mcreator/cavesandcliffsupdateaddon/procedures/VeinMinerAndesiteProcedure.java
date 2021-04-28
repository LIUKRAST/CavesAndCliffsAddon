package net.mcreator.cavesandcliffsupdateaddon.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonMod;

import java.util.Map;
import java.util.HashMap;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class VeinMinerAndesiteProcedure extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public VeinMinerAndesiteProcedure(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 191);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency entity for procedure VeinMinerAndesite!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency x for procedure VeinMinerAndesite!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency y for procedure VeinMinerAndesite!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency z for procedure VeinMinerAndesite!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CavesAndCliffsUpdateAddonMod.LOGGER.warn("Failed to load dependency world for procedure VeinMinerAndesite!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x + 1), (int) y, (int) z), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (x + 1));
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) (x - 1), (int) y, (int) z), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", (x - 1));
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y + 1), (int) z), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y + 1));
				$_dependencies.put("z", z);
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) (y - 1), (int) z), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", (y - 1));
				$_dependencies.put("z", z);
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z + 1)), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", (z + 1));
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) (z - 1)), false);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", (z - 1));
				VeinMinerAndesiteProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
