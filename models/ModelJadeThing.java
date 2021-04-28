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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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