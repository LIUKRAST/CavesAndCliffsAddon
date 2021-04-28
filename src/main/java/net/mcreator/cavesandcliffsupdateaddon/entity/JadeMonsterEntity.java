
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
import net.minecraft.entity.monster.MonsterEntity;
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
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.cavesandcliffsupdateaddon.itemgroup.CACADDJadeItemGroup;
import net.mcreator.cavesandcliffsupdateaddon.CavesAndCliffsUpdateAddonModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@CavesAndCliffsUpdateAddonModElements.ModElement.Tag
public class JadeMonsterEntity extends CavesAndCliffsUpdateAddonModElements.ModElement {
	public static EntityType entity = null;
	public JadeMonsterEntity(CavesAndCliffsUpdateAddonModElements instance) {
		super(instance, 136);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("jade_monster")
						.setRegistryName("jade_monster");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13369549, -16738048, new Item.Properties().group(CACADDJadeItemGroup.tab))
				.setRegistryName("jade_monster_spawn_egg"));
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
				return new MobRenderer(renderManager, new ModelJadeThing(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("caves_and_cliffs_update_addon:textures/jadething.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 100);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.CACTUS)
				return false;
			return super.attackEntityFrom(source, amount);
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelJadeThing extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer body_r1;
		private final ModelRenderer head;
		private final ModelRenderer arm0;
		private final ModelRenderer Arm1;
		private final ModelRenderer leg0;
		private final ModelRenderer leg1;
		public ModelJadeThing() {
			textureWidth = 128;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -2.0F, -7.0F);
			body.setTextureOffset(0, 0).addBox(-12.0F, -9.0F, -6.0F, 24.0F, 16.0F, 12.0F, 0.0F, false);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(3.0F, 24.0F, 22.0F);
			body.addChild(body_r1);
			setRotationAngle(body_r1, 0.6545F, 0.0F, 0.0F);
			body_r1.setTextureOffset(52, 28).addBox(-10.5F, -27.0F, -6.0F, 15.0F, 8.0F, 3.0F, 1.5F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -10.0F, -12.0F);
			head.setTextureOffset(20, 63).addBox(-4.0F, -9.0F, -3.5F, 8.0F, 12.0F, 8.0F, 0.0F, false);
			arm0 = new ModelRenderer(this);
			arm0.setRotationPoint(-7.0F, -6.0F, -5.0F);
			arm0.setTextureOffset(58, 58).addBox(-9.0F, -6.0F, -5.0F, 4.0F, 36.0F, 6.0F, 0.0F, false);
			arm0.setTextureOffset(0, 28).addBox(-13.0F, -14.0F, -8.0F, 4.0F, 19.0F, 12.0F, 0.0F, false);
			Arm1 = new ModelRenderer(this);
			Arm1.setRotationPoint(11.0F, -11.0F, -5.0F);
			Arm1.setTextureOffset(32, 32).addBox(5.0F, -9.0F, -8.0F, 4.0F, 19.0F, 12.0F, 0.0F, false);
			Arm1.setTextureOffset(0, 59).addBox(1.0F, -1.0F, -5.0F, 4.0F, 36.0F, 6.0F, 0.0F, false);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
			leg0.setTextureOffset(72, 39).addBox(-2.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-5.0F, 11.0F, 6.0F);
			leg1.setTextureOffset(72, 0).addBox(-2.5F, -3.0F, -9.0F, 6.0F, 16.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			arm0.render(matrixStack, buffer, packedLight, packedOverlay);
			Arm1.render(matrixStack, buffer, packedLight, packedOverlay);
			leg0.render(matrixStack, buffer, packedLight, packedOverlay);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
