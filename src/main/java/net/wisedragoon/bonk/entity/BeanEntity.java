
package net.wisedragoon.bonk.entity;

import net.wisedragoon.bonk.procedures.BeanRightClickedOnEntityProcedure;
import net.wisedragoon.bonk.init.BonkModItems;
import net.wisedragoon.bonk.init.BonkModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

@Mod.EventBusSubscriber
public class BeanEntity extends Monster {
	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(BonkModEntities.BEAN, 40, 4, 4));
	}

	public BeanEntity(FMLPlayMessages.SpawnEntity packet, Level world) {
		this(BonkModEntities.BEAN, world);
	}

	public BeanEntity(EntityType<BeanEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(BonkModItems.BEAN_SWORD));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BonkModItems.BEANIER_ARMOR_HELMET));
		this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BonkModItems.BEANIER_ARMOR_CHESTPLATE));
		this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BonkModItems.BEANIER_ARMOR_LEGGINGS));
		this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BonkModItems.BEANIER_ARMOR_BOOTS));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Blaze.class, false, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, CaveSpider.class, false, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Creeper.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, EnderDragon.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, ElderGuardian.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, EnderMan.class, false, false));
		this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Endermite.class, false, false));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, Evoker.class, false, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, Ghast.class, false, false));
		this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, Hoglin.class, false, false));
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, Husk.class, false, false));
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, Phantom.class, false, false));
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, Piglin.class, false, false));
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, PiglinBrute.class, false, false));
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Pillager.class, false, false));
		this.targetSelector.addGoal(16, new NearestAttackableTargetGoal(this, Shulker.class, false, false));
		this.targetSelector.addGoal(17, new NearestAttackableTargetGoal(this, Silverfish.class, false, false));
		this.targetSelector.addGoal(18, new NearestAttackableTargetGoal(this, Slime.class, false, false));
		this.targetSelector.addGoal(19, new NearestAttackableTargetGoal(this, Spider.class, false, false));
		this.targetSelector.addGoal(20, new NearestAttackableTargetGoal(this, Stray.class, false, false));
		this.targetSelector.addGoal(21, new NearestAttackableTargetGoal(this, Vindicator.class, false, false));
		this.targetSelector.addGoal(22, new NearestAttackableTargetGoal(this, Witch.class, false, false));
		this.targetSelector.addGoal(23, new NearestAttackableTargetGoal(this, WitherBoss.class, false, false));
		this.targetSelector.addGoal(24, new NearestAttackableTargetGoal(this, WitherSkeleton.class, false, false));
		this.targetSelector.addGoal(25, new NearestAttackableTargetGoal(this, Zoglin.class, false, false));
		this.targetSelector.addGoal(26, new NearestAttackableTargetGoal(this, Zombie.class, false, false));
		this.targetSelector.addGoal(27, new NearestAttackableTargetGoal(this, ZombieVillager.class, false, false));
		this.targetSelector.addGoal(28, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, false, false));
		this.goalSelector.addGoal(29, new TemptGoal(this, 1, Ingredient.of(BonkModItems.BEAN_SWORD), false));
		this.goalSelector.addGoal(30, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(31, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(32, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(BonkModItems.BEAN_SWORD));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;

		BeanRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		return retval;
	}

	public static void init() {
		SpawnPlacements.register(BonkModEntities.BEAN, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL
						&& Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 100);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		return builder;
	}
}
