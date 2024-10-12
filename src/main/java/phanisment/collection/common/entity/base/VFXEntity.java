package phanisment.collection.common.entity.base;

public class VFXEntity extends Entity implements GeoEntity {
	private final AnimationFactory factory = new AnimationFactory(this);

	public VFXBaseEntity(EntityType<? extends VFXBaseEntity> entityType, World world) {
		super(entityType, world);
		this.noClip = true;
		this.setInvisible(true);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("vfx_animation", true));
		return PlayState.CONTINUE;
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}