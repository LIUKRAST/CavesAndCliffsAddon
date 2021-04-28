// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelRedstoneColo extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer head;
	private final ModelRenderer head_r2_r1;
	private final ModelRenderer head_r1_r1;
	private final ModelRenderer arm1;
	private final ModelRenderer cube8_r1;
	private final ModelRenderer arm2;
	private final ModelRenderer Cube10_r1;
	private final ModelRenderer Cube9_r1;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer Crystals;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer body_r4;
	private final ModelRenderer body_r5;

	public ModelRedstoneColo() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.setTextureOffset(0, 34).addBox(-9.0F, -4.0F, -6.0F, 18.0F, 14.0F, 11.0F, 1.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 16.0F, 7.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(-9.0F, -39.0F, -6.0F, 18.0F, 18.0F, 16.0F, 1.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -23.0F, -14.0F);
		head.setTextureOffset(68, 0).addBox(-4.0F, -5.0F, -8.5F, 8.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-4.0F, 7.75F, -8.0F, 8.0F, 2.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(0, 7).addBox(-1.0F, -3.0F, -10.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		head_r2_r1 = new ModelRenderer(this);
		head_r2_r1.setRotationPoint(0.0F, 35.0F, 12.0F);
		head.addChild(head_r2_r1);
		setRotationAngle(head_r2_r1, 0.4363F, 0.0F, 0.0F);
		head_r2_r1.setTextureOffset(6, 2).addBox(3.0F, -34.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head_r2_r1.setTextureOffset(8, 8).addBox(3.0F, -34.0F, -6.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head_r2_r1.setTextureOffset(0, 2).addBox(3.0F, -34.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head_r2_r1.setTextureOffset(8, 5).addBox(-4.0F, -34.0F, -6.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head_r2_r1.setTextureOffset(0, 4).addBox(-4.0F, -34.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head_r2_r1.setTextureOffset(6, 11).addBox(-4.0F, -34.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		head_r1_r1 = new ModelRenderer(this);
		head_r1_r1.setRotationPoint(0.0F, 35.5F, 13.0F);
		head.addChild(head_r1_r1);
		setRotationAngle(head_r1_r1, 0.4363F, 0.0F, 0.0F);
		head_r1_r1.setTextureOffset(68, 18).addBox(-4.0F, -34.0F, -7.5F, 8.0F, 1.0F, 8.0F, 0.0F, false);

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(-8.0F, -24.0F, -6.0F);
		arm1.setTextureOffset(66, 86).addBox(-7.0F, -2.5F, -4.0F, 4.0F, 15.0F, 6.0F, 1.0F, false);

		cube8_r1 = new ModelRenderer(this);
		cube8_r1.setRotationPoint(8.0F, 48.0F, -15.0F);
		arm1.addChild(cube8_r1);
		setRotationAngle(cube8_r1, -0.3491F, 0.0F, 0.0F);
		cube8_r1.setTextureOffset(0, 59).addBox(-15.0F, -37.75F, -1.75F, 4.0F, 30.0F, 6.0F, 1.0F, false);

		arm2 = new ModelRenderer(this);
		arm2.setRotationPoint(7.0F, -27.0F, -6.0F);
		arm2.setTextureOffset(20, 84).addBox(4.0F, 0.5F, -4.0F, 4.0F, 15.0F, 6.0F, 1.0F, false);

		Cube10_r1 = new ModelRenderer(this);
		Cube10_r1.setRotationPoint(19.0F, 50.75F, -15.25F);
		arm2.addChild(Cube10_r1);
		setRotationAngle(Cube10_r1, -0.3491F, 0.0F, 0.0F);
		Cube10_r1.setTextureOffset(52, 53).addBox(-15.0F, -37.5F, -1.5F, 4.0F, 30.0F, 6.0F, 1.0F, false);

		Cube9_r1 = new ModelRenderer(this);
		Cube9_r1.setRotationPoint(-6.0F, 21.0F, 68.0F);
		arm2.addChild(Cube9_r1);
		setRotationAngle(Cube9_r1, 1.3963F, 0.0F, 0.0F);
		Cube9_r1.setTextureOffset(0, 2).addBox(12.5F, -70.0F, 8.0F, 1.0F, 1.0F, 4.0F, 0.5F, false);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(4.0F, 2.0F, 0.0F);
		leg0.setTextureOffset(66, 27).addBox(-2.5F, 0.0F, -3.0F, 8.0F, 22.0F, 5.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
		leg1.setTextureOffset(20, 57).addBox(-4.5F, -9.0F, -3.0F, 8.0F, 22.0F, 5.0F, 0.0F, false);

		Crystals = new ModelRenderer(this);
		Crystals.setRotationPoint(0.0F, 24.0F, 0.0F);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(-11.0F, -53.0F, 11.0F);
		Crystals.addChild(body_r2);
		setRotationAngle(body_r2, 1.5272F, 0.0F, 0.0F);
		body_r2.setTextureOffset(72, 72).addBox(1.5F, -21.0F, -3.0F, 8.0F, 5.0F, 9.0F, -0.5F, false);

		body_r3 = new ModelRenderer(this);
		body_r3.setRotationPoint(27.0F, -38.0F, 15.0F);
		Crystals.addChild(body_r3);
		setRotationAngle(body_r3, 0.6109F, 0.0F, -2.0944F);
		body_r3.setTextureOffset(92, 27).addBox(16.5F, -21.0F, -3.0F, 8.0F, 5.0F, 6.0F, -0.5F, false);

		body_r4 = new ModelRenderer(this);
		body_r4.setRotationPoint(-13.0F, -26.0F, 15.0F);
		Crystals.addChild(body_r4);
		setRotationAngle(body_r4, 0.6109F, 0.0F, -0.48F);
		body_r4.setTextureOffset(86, 86).addBox(16.5F, -21.0F, -3.0F, 8.0F, 5.0F, 6.0F, -0.5F, false);

		body_r5 = new ModelRenderer(this);
		body_r5.setRotationPoint(-20.0F, -37.0F, 14.0F);
		Crystals.addChild(body_r5);
		setRotationAngle(body_r5, 0.6109F, 0.0F, 0.0F);
		body_r5.setTextureOffset(72, 54).addBox(16.5F, -21.0F, -3.0F, 8.0F, 5.0F, 6.0F, -0.5F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		arm1.render(matrixStack, buffer, packedLight, packedOverlay);
		arm2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		Crystals.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}