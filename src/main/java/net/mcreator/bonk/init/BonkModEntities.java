
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.bonk.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.bonk.entity.YeeterMilkEntity;
import net.mcreator.bonk.entity.XPEntity;
import net.mcreator.bonk.entity.UpgradedMilkEntity;
import net.mcreator.bonk.entity.UltimateBeanEntity;
import net.mcreator.bonk.entity.SplitterMilkEntity;
import net.mcreator.bonk.entity.RichMilkEntity;
import net.mcreator.bonk.entity.NyooommmEntity;
import net.mcreator.bonk.entity.MinerMilkEntity;
import net.mcreator.bonk.entity.MilkEntity;
import net.mcreator.bonk.entity.GigaMilkEntity;
import net.mcreator.bonk.entity.BonkerEntity;
import net.mcreator.bonk.entity.BonkerBuddyEntity;
import net.mcreator.bonk.entity.BeanyMilkEntity;
import net.mcreator.bonk.entity.BeanEntity;
import net.mcreator.bonk.entity.AntiBeanEntity;
import net.mcreator.bonk.entity.AnActualMilkGunEntity;
import net.mcreator.bonk.entity.AmbushMilkEntity;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BonkModEntities {
	private static final List<EntityType<?>> REGISTRY = new ArrayList<>();
	public static final EntityType<BeanEntity> BEAN = register("bean",
			EntityType.Builder.<BeanEntity>of(BeanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(BeanEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<NyooommmEntity> NYOOOMMM = register("nyooommm",
			EntityType.Builder.<NyooommmEntity>of(NyooommmEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(NyooommmEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<MilkEntity> MILK = register("entitybulletmilk",
			EntityType.Builder.<MilkEntity>of(MilkEntity::new, MobCategory.MISC).setCustomClientFactory(MilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<XPEntity> XP = register("xp", EntityType.Builder.<XPEntity>of(XPEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(XPEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<UpgradedMilkEntity> UPGRADED_MILK = register("entitybulletupgraded_milk",
			EntityType.Builder.<UpgradedMilkEntity>of(UpgradedMilkEntity::new, MobCategory.MISC).setCustomClientFactory(UpgradedMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<GigaMilkEntity> GIGA_MILK = register("entitybulletgiga_milk",
			EntityType.Builder.<GigaMilkEntity>of(GigaMilkEntity::new, MobCategory.MISC).setCustomClientFactory(GigaMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<BeanyMilkEntity> BEANY_MILK = register("entitybulletbeany_milk",
			EntityType.Builder.<BeanyMilkEntity>of(BeanyMilkEntity::new, MobCategory.MISC).setCustomClientFactory(BeanyMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<SplitterMilkEntity> SPLITTER_MILK = register("entitybulletsplitter_milk",
			EntityType.Builder.<SplitterMilkEntity>of(SplitterMilkEntity::new, MobCategory.MISC).setCustomClientFactory(SplitterMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<YeeterMilkEntity> YEETER_MILK = register("entitybulletyeeter_milk",
			EntityType.Builder.<YeeterMilkEntity>of(YeeterMilkEntity::new, MobCategory.MISC).setCustomClientFactory(YeeterMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<RichMilkEntity> RICH_MILK = register("entitybulletrich_milk",
			EntityType.Builder.<RichMilkEntity>of(RichMilkEntity::new, MobCategory.MISC).setCustomClientFactory(RichMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<AmbushMilkEntity> AMBUSH_MILK = register("entitybulletambush_milk",
			EntityType.Builder.<AmbushMilkEntity>of(AmbushMilkEntity::new, MobCategory.MISC).setCustomClientFactory(AmbushMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<MinerMilkEntity> MINER_MILK = register("entitybulletminer_milk",
			EntityType.Builder.<MinerMilkEntity>of(MinerMilkEntity::new, MobCategory.MISC).setCustomClientFactory(MinerMilkEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<BonkerEntity> BONKER = register("bonker",
			EntityType.Builder.<BonkerEntity>of(BonkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(BonkerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<BonkerBuddyEntity> BONKER_BUDDY = register("bonker_buddy",
			EntityType.Builder.<BonkerBuddyEntity>of(BonkerBuddyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BonkerBuddyEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final EntityType<AnActualMilkGunEntity> AN_ACTUAL_MILK_GUN = register("entitybulletan_actual_milk_gun",
			EntityType.Builder.<AnActualMilkGunEntity>of(AnActualMilkGunEntity::new, MobCategory.MISC)
					.setCustomClientFactory(AnActualMilkGunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final EntityType<AntiBeanEntity> ANTI_BEAN = register("anti_bean",
			EntityType.Builder.<AntiBeanEntity>of(AntiBeanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(AntiBeanEntity::new).sized(0.6f, 1.8f));
	public static final EntityType<UltimateBeanEntity> ULTIMATE_BEAN = register("ultimate_bean",
			EntityType.Builder.<UltimateBeanEntity>of(UltimateBeanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UltimateBeanEntity::new).sized(0.6f, 1.8f));

	private static <T extends Entity> EntityType<T> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		EntityType<T> entityType = (EntityType<T>) entityTypeBuilder.build(registryname).setRegistryName(registryname);
		REGISTRY.add(entityType);
		return entityType;
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new EntityType[0]));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BeanEntity.init();
			NyooommmEntity.init();
			XPEntity.init();
			BonkerEntity.init();
			BonkerBuddyEntity.init();
			AntiBeanEntity.init();
			UltimateBeanEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BEAN, BeanEntity.createAttributes().build());
		event.put(NYOOOMMM, NyooommmEntity.createAttributes().build());
		event.put(XP, XPEntity.createAttributes().build());
		event.put(BONKER, BonkerEntity.createAttributes().build());
		event.put(BONKER_BUDDY, BonkerBuddyEntity.createAttributes().build());
		event.put(ANTI_BEAN, AntiBeanEntity.createAttributes().build());
		event.put(ULTIMATE_BEAN, UltimateBeanEntity.createAttributes().build());
	}
}
