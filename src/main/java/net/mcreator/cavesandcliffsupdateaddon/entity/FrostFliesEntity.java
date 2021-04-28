
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDIcyItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class FrostFliesEntity extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public static EntityType entity = null;
	public FrostFliesEntity(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 138);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("frost_flies")
						.setRegistryName("frost_flies");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16711681, -3342337, new Item.Properties().group(CACADDIcyItemGroup.tab))
				.setRegistryName("frost_flies_spawn_egg"));
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
				return new MobRenderer(renderManager, new ModelFrostFlies(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("caves_and_cliffs_update_addon:textures/frostflies.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 30);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
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
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelFrostFlies extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Head;
		private final ModelRenderer rightWingTip;
		private final ModelRenderer rightWingTip_r1;
		private final ModelRenderer rightWingTip3;
		private final ModelRenderer rightWingTip_r2;
		private final ModelRenderer Legs;
		private final ModelRenderer head_r1;
		private final ModelRenderer head_r2;
		private final ModelRenderer head_r3;
		private final ModelRenderer Body3;
		private final ModelRenderer Body4;
		public ModelFrostFlies() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			Body.setTextureOffset(30, 30).addBox(-4.0F, 3.0F, -3.0F, 8.0F, 6.0F, 12.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.setTextureOffset(30, 0).addBox(-3.0F, 4.0F, -8.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);
			Head.setTextureOffset(0, 4).addBox(3.0F, 4.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(-4.0F, 4.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			rightWingTip = new ModelRenderer(this);
			rightWingTip.setRotationPoint(12.0F, 4.0F, 5.5F);
			setRotationAngle(rightWingTip, -0.2618F, -0.1309F, 2.3126F);
			rightWingTip_r1 = new ModelRenderer(this);
			rightWingTip_r1.setRotationPoint(-34.5F, 10.0F, -16.5F);
			rightWingTip.addChild(rightWingTip_r1);
			setRotationAngle(rightWingTip_r1, -1.8762F, -2.9671F, -0.0436F);
			rightWingTip_r1.setTextureOffset(29, 28).addBox(-36.3266F, 24.6545F, 5.2284F, 10.0F, 2.0F, 0.0F, 0.0F, false);
			rightWingTip_r1.setTextureOffset(29, 24).addBox(-36.6314F, 20.7193F, 5.2034F, 17.0F, 4.0F, 0.0F, 0.0F, false);
			rightWingTip3 = new ModelRenderer(this);
			rightWingTip3.setRotationPoint(-31.0F, -5.0F, 17.75F);
			setRotationAngle(rightWingTip3, -0.2618F, -0.5672F, -2.5744F);
			rightWingTip_r2 = new ModelRenderer(this);
			rightWingTip_r2.setRotationPoint(-60.5F, 6.0F, -19.5F);
			rightWingTip3.addChild(rightWingTip_r2);
			setRotationAngle(rightWingTip_r2, -1.9199F, -2.7489F, 0.3054F);
			rightWingTip_r2.setTextureOffset(30, 10).addBox(-26.291F, 37.695F, 3.3201F, 10.0F, 2.0F, 0.0F, 0.0F, false);
			rightWingTip_r2.setTextureOffset(29, 20).addBox(-33.291F, 33.695F, 3.3201F, 17.0F, 4.0F, 0.0F, 0.0F, false);
			Legs = new ModelRenderer(this);
			Legs.setRotationPoint(0.0F, 21.0F, 0.0F);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(-7.0F, 11.0F, 16.0F);
			Legs.addChild(head_r1);
			setRotationAngle(head_r1, 0.2618F, 0.0F, 0.0F);
			head_r1.setTextureOffset(2, 7).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r1.setTextureOffset(6, 6).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r2 = new ModelRenderer(this);
			head_r2.setRotationPoint(-7.0F, 11.0F, 12.0F);
			Legs.addChild(head_r2);
			setRotationAngle(head_r2, 0.2618F, 0.0F, 0.0F);
			head_r2.setTextureOffset(4, 7).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r2.setTextureOffset(6, 0).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r3 = new ModelRenderer(this);
			head_r3.setRotationPoint(1.0F, 11.0F, 8.0F);
			Legs.addChild(head_r3);
			setRotationAngle(head_r3, 0.2618F, 0.0F, 0.0F);
			head_r3.setTextureOffset(0, 7).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			head_r3.setTextureOffset(8, 8).addBox(-5.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
			Body3 = new ModelRenderer(this);
			Body3.setRotationPoint(0.0F, 0.0F, 11.0F);
			setRotationAngle(Body3, -0.2618F, 0.0F, 0.0F);
			Body3.setTextureOffset(0, 20).addBox(-4.0F, 3.0F, -3.0F, 8.0F, 6.0F, 13.0F, -1.0F, false);
			Body4 = new ModelRenderer(this);
			Body4.setRotationPoint(0.0F, 8.0F, 27.0F);
			setRotationAngle(Body4, -1.1345F, 0.0F, 0.0F);
			Body4.setTextureOffset(0, 0).addBox(-4.0F, 5.78F, -6.5031F, 8.0F, 6.0F, 14.0F, -2.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			rightWingTip.render(matrixStack, buffer, packedLight, packedOverlay);
			rightWingTip3.render(matrixStack, buffer, packedLight, packedOverlay);
			Legs.render(matrixStack, buffer, packedLight, packedOverlay);
			Body3.render(matrixStack, buffer, packedLight, packedOverlay);
			Body4.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
