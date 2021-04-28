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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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