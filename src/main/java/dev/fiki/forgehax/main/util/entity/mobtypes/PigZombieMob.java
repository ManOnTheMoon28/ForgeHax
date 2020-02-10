package dev.fiki.forgehax.main.util.entity.mobtypes;

import dev.fiki.forgehax.main.util.reflection.FastReflection;
import dev.fiki.forgehax.main.util.common.PriorityEnum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombiePigmanEntity;

/**
 * Created on 6/27/2017 by fr1kin
 */
public class PigZombieMob extends MobType {
  
  @Override
  protected PriorityEnum getPriority() {
    return PriorityEnum.LOW;
  }
  
  @Override
  public boolean isMobType(Entity entity) {
    return entity instanceof ZombiePigmanEntity;
  }
  
  @Override
  protected MobTypeEnum getMobTypeUnchecked(Entity entity) {
    ZombiePigmanEntity zombie = (ZombiePigmanEntity) entity;
    return (zombie.isAggressive() || FastReflection.Fields.ZombiePigmanEntity_angerLevel.get(zombie) > 0)
        ? MobTypeEnum.HOSTILE
        : MobTypeEnum.NEUTRAL;
  }
}