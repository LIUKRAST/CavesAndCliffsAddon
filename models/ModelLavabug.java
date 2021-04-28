// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelLavabug extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer body2;
	private final ModelRenderer body_r1;
	private final ModelRenderer rightWingTip;
	private final ModelRenderer rightWingTip_r1;
	private final ModelRenderer rightWingTip_r2;
	private final ModelRenderer Legs;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer head_r5;
	private final ModelRenderer Sting;
	private final ModelRenderer body_r2;

	public ModelLavabug() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 22).addBox(-4.0F, 3.0F, -3.0F, 8.0F, 9.0F, 12.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 43).addBox(-3.0F, 2.0F, -8.0F, 6.0F, 7.0F, 5.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-2.25F, 35.0F, -10.5F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.4363F, 0.0F);
		Head_r1.setTextureOffset(0, 4).addBox(-2.0F, -27.0F, -10.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		Head_r1.setTextureOffset(5, 0).addBox(-1.0F, -26.5F, 1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		Head_r1.setTextureOffset(0, 4).addBox(-1.0F, -26.5F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r1.setTextureOffset(0, 5).addBox(-1.0F, -26.5F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r1.setTextureOffset(0, 6).addBox(-1.0F, -26.5F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r1.setTextureOffset(6, 4).addBox(-1.0F, -26.5F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r1.setTextureOffset(29, 34).addBox(-2.0F, -27.0F, -7.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(5.0F, 35.0F, -9.0F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0F, -0.4363F, 0.0F);
		Head_r2.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -10.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		Head_r2.setTextureOffset(5, 5).addBox(-3.0F, -26.5F, 1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		Head_r2.setTextureOffset(0, 0).addBox(-3.0F, -26.5F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r2.setTextureOffset(0, 1).addBox(-3.0F, -26.5F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r2.setTextureOffset(0, 2).addBox(-3.0F, -26.5F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r2.setTextureOffset(6, 2).addBox(-3.0F, -26.5F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		Head_r2.setTextureOffset(40, 0).addBox(-2.0F, -27.0F, -7.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 0.0F, 0.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(2.0F, 2.0F, 0.0F);
		body2.addChild(body_r1);
		setRotationAngle(body_r1, -1.9635F, 0.0F, 0.0F);
		body_r1.setTextureOffset(0, 0).addBox(-7.0F, -20.0F, -3.0F, 10.0F, 12.0F, 10.0F, 0.0F, false);

		rightWingTip = new ModelRenderer(this);
		rightWingTip.setRotationPoint(11.0F, 1.0F, 2.5F);
		setRotationAngle(rightWingTip, -0.1309F, -0.2182F, 1.8326F);

		rightWingTip_r1 = new ModelRenderer(this);
		rightWingTip_r1.setRotationPoint(-34.5F, 10.0F, -16.5F);
		rightWingTip.addChild(rightWingTip_r1);
		setRotationAngle(rightWingTip_r1, -0.2618F, -2.3562F, -0.4363F);
		rightWingTip_r1.setTextureOffset(28, 28).addBox(-15.8271F, 25.1056F, -26.8571F, 17.0F, 6.0F, 0.0F, 0.0F, false);

		rightWingTip_r2 = new ModelRenderer(this);
		rightWingTip_r2.setRotationPoint(-34.5F, 10.0F, -16.5F);
		rightWingTip.addChild(rightWingTip_r2);
		setRotationAngle(rightWingTip_r2, -0.2618F, -2.3998F, 0.2182F);
		rightWingTip_r2.setTextureOffset(28, 22).addBox(-19.0682F, -4.748F, -34.7177F, 17.0F, 6.0F, 0.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 24.0F, 0.0F);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(-7.0F, 11.0F, 16.0F);
		Legs.addChild(head_r3);
		setRotationAngle(head_r3, 0.2618F, 0.0F, 0.0F);
		head_r3.setTextureOffset(10, 21).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		head_r3.setTextureOffset(4, 21).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(-7.0F, 11.0F, 12.0F);
		Legs.addChild(head_r4);
		setRotationAngle(head_r4, 0.2618F, 0.0F, 0.0F);
		head_r4.setTextureOffset(0, 25).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		head_r4.setTextureOffset(6, 21).addBox(11.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);

		head_r5 = new ModelRenderer(this);
		head_r5.setRotationPoint(1.0F, 11.0F, 8.0F);
		Legs.addChild(head_r5);
		setRotationAngle(head_r5, 0.2618F, 0.0F, 0.0F);
		head_r5.setTextureOffset(8, 21).addBox(3.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		head_r5.setTextureOffset(2, 25).addBox(-5.0F, -25.0F, -3.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);

		Sting = new ModelRenderer(this);
		Sting.setRotationPoint(0.0F, 24.0F, 0.0F);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(-3.0F, -14.0F, 9.0F);
		Sting.addChild(body_r2);
		setRotationAngle(body_r2, -1.9635F, 0.0F, 0.0F);
		body_r2.setTextureOffset(0, 20).addBox(3.0F, -12.0F, -3.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		body2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightWingTip.render(matrixStack, buffer, packedLight, packedOverlay);
		Legs.render(matrixStack, buffer, packedLight, packedOverlay);
		Sting.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}