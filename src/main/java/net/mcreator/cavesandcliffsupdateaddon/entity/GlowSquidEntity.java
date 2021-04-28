
package net.mcreator.cavesandcliffsupdateaddon.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDGlowCaveItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class GlowSquidEntity extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public static EntityType entity = null;
	public GlowSquidEntity(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 45);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("glow_squid")
						.setRegistryName("glow_squid");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16763956, -13369396, new Item.Properties().group(CACADDGlowCaveItemGroup.tab))
				.setRegistryName("glow_squid_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelGlowSquid(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("caves_and_cliffs_update_addon:textures/glowsquid.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		ammma = ammma.createMutableAttribute(ForgeMod.SWIM_SPEED.get(), 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends SquidEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttributeValue(Attributes.MOVEMENT_SPEED))));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.8, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	// Made with Blockbench 3.7.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelGlowSquid extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer tentacle1;
		private final ModelRenderer tentacle2;
		private final ModelRenderer tentacle3;
		private final ModelRenderer tentacle4;
		private final ModelRenderer tentacle5;
		private final ModelRenderer tentacle6;
		private final ModelRenderer tentacle7;
		private final ModelRenderer tentacle8;
		public ModelGlowSquid() {
			textureWidth = 128;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 16.0F, 12.0F, 0.0F, false);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(-5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle1, 0.0F, -1.5708F, 0.0F);
			tentacle1.setTextureOffset(8, 48).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle2, 0.0F, -0.7854F, 0.0F);
			tentacle2.setTextureOffset(24, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(0.0F, 31.0F, 5.0F);
			tentacle3.setTextureOffset(0, 48).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle4, 0.0F, 0.7854F, 0.0F);
			tentacle4.setTextureOffset(16, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle5, 0.0F, 1.5708F, 0.0F);
			tentacle5.setTextureOffset(40, 40).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
			tentacle6 = new ModelRenderer(this);
			tentacle6.setRotationPoint(3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle6, 0.0F, 2.3562F, 0.0F);
			tentacle6.setTextureOffset(8, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
			tentacle7 = new ModelRenderer(this);
			tentacle7.setRotationPoint(0.0F, 31.0F, -5.0F);
			setRotationAngle(tentacle7, 0.0F, 3.1416F, 0.0F);
			tentacle7.setTextureOffset(32, 32).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 17.0F, 2.0F, 0.0F, false);
			tentacle8 = new ModelRenderer(this);
			tentacle8.setRotationPoint(-3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle8, 0.0F, 3.927F, 0.0F);
			tentacle8.setTextureOffset(0, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle1.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle2.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle3.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle4.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle5.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle6.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle7.render(matrixStack, buffer, packedLight, packedOverlay);
			tentacle8.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
