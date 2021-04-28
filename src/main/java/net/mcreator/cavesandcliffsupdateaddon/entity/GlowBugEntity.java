
package net.mcreator.cavesandcliffsupdateaddon.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.block.BlockState;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDGlowCaveItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class GlowBugEntity extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public static EntityType entity = null;
	public GlowBugEntity(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 113);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1f, 1.8f)).build("glow_bug")
						.setRegistryName("glow_bug");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16753306, -16760715, new Item.Properties().group(CACADDGlowCaveItemGroup.tab))
				.setRegistryName("glow_bug_spawn_egg"));
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
				return new MobRenderer(renderManager, new ModelGlowBug(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("caves_and_cliffs_update_addon:textures/glowbug.png");
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
		ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("caves_and_cliffs_update_addon:textures/glowbug.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelGlowBug extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Head;
		private final ModelRenderer body2;
		private final ModelRenderer body_r1;
		private final ModelRenderer rightWingTip;
		private final ModelRenderer rightWingTip_r1;
		private final ModelRenderer leftWingTip;
		private final ModelRenderer rightWingTip_r2;
		private final ModelRenderer Legs;
		private final ModelRenderer head_r1;
		private final ModelRenderer head_r2;
		private final ModelRenderer head_r3;
		private final ModelRenderer Sting;
		private final ModelRenderer body_r2;
		public ModelGlowBug() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(0, 22).addBox(-4.0F, 3.0F, -3.0F, 8.0F, 9.0F, 12.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.setTextureOffset(28, 22).addBox(-3.0F, 2.0F, -8.0F, 6.0F, 7.0F, 5.0F, 0.0F, false);
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(0.0F, 0.0F, 0.0F);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(2.0F, 11.0F, -1.0F);
			body2.addChild(body_r1);
			setRotationAngle(body_r1, -0.9599F, 0.0F, 0.0F);
			body_r1.setTextureOffset(0, 0).addBox(-7.0F, -20.0F, -3.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);
			rightWingTip = new ModelRenderer(this);
			rightWingTip.setRotationPoint(11.0F, 1.0F, 2.5F);
			setRotationAngle(rightWingTip, -0.1309F, -0.2182F, 1.8326F);
			rightWingTip_r1 = new ModelRenderer(this);
			rightWingTip_r1.setRotationPoint(-34.5F, 10.0F, -16.5F);
			rightWingTip.addChild(rightWingTip_r1);
			setRotationAngle(rightWingTip_r1, -0.2618F, -2.3998F, 0.3054F);
			rightWingTip_r1.setTextureOffset(30, 0).addBox(-18.3265F, -7.1137F, -34.4003F, 12.0F, 6.0F, 0.0F, 0.0F, false);
			leftWingTip = new ModelRenderer(this);
			leftWingTip.setRotationPoint(-12.0F, 1.0F, 1.5F);
			setRotationAngle(leftWingTip, 0.0F, 0.0F, 0.8727F);
			rightWingTip_r2 = new ModelRenderer(this);
			rightWingTip_r2.setRotationPoint(-10.5F, 10.0F, -16.5F);
			leftWingTip.addChild(rightWingTip_r2);
			setRotationAngle(rightWingTip_r2, -0.2182F, -2.618F, 0.3054F);
			rightWingTip_r2.setTextureOffset(40, 40).addBox(-4.5332F, -19.1961F, -20.9889F, 12.0F, 6.0F, 0.0F, 0.0F, false);
			Legs = new ModelRenderer(this);
			Legs.setRotationPoint(0.0F, 24.0F, 0.0F);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(-7.0F, 11.0F, 16.0F);
			Legs.addChild(head_r1);
			setRotationAngle(head_r1, 0.2618F, 0.0F, 0.0F);
			head_r1.setTextureOffset(2, 5).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r1.setTextureOffset(4, 4).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r2 = new ModelRenderer(this);
			head_r2.setRotationPoint(-7.0F, 11.0F, 12.0F);
			Legs.addChild(head_r2);
			setRotationAngle(head_r2, 0.2618F, 0.0F, 0.0F);
			head_r2.setTextureOffset(6, 0).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r2.setTextureOffset(4, 0).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r3 = new ModelRenderer(this);
			head_r3.setRotationPoint(1.0F, 11.0F, 8.0F);
			Legs.addChild(head_r3);
			setRotationAngle(head_r3, 0.2618F, 0.0F, 0.0F);
			head_r3.setTextureOffset(0, 5).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r3.setTextureOffset(6, 4).addBox(-5.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			Sting = new ModelRenderer(this);
			Sting.setRotationPoint(0.0F, 24.0F, 0.0F);
			body_r2 = new ModelRenderer(this);
			body_r2.setRotationPoint(-3.0F, -17.0F, 11.0F);
			Sting.addChild(body_r2);
			setRotationAngle(body_r2, -0.9599F, 0.0F, 0.0F);
			body_r2.setTextureOffset(0, 0).addBox(3.0F, -12.0F, -3.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			body2.render(matrixStack, buffer, packedLight, packedOverlay);
			rightWingTip.render(matrixStack, buffer, packedLight, packedOverlay);
			leftWingTip.render(matrixStack, buffer, packedLight, packedOverlay);
			Legs.render(matrixStack, buffer, packedLight, packedOverlay);
			Sting.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
