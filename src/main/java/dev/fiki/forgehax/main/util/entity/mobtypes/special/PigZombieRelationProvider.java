package dev.fiki.forgehax.main.util.entity.mobtypes.special;

import dev.fiki.forgehax.main.util.common.PriorityEnum;
import dev.fiki.forgehax.main.util.entity.mobtypes.EntityRelationProvider;
import dev.fiki.forgehax.main.util.entity.mobtypes.RelationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;

/**
 * Created on 6/27/2017 by fr1kin
 */
public class PigZombieRelationProvider extends EntityRelationProvider<ZombifiedPiglinEntity> {
  
  @Override
  protected PriorityEnum getPriority() {
    return PriorityEnum.DEFAULT;
  }
  
  @Override
  public boolean isProviderFor(Entity entity) {
    return entity instanceof ZombifiedPiglinEntity;
  }

  @Override
  public RelationState getDefaultRelationState() {
    return RelationState.NEUTRAL;
  }

  @Override
  public RelationState getCurrentRelationState(ZombifiedPiglinEntity entity) {
    return (entity.isAggressive() || entity.getAngerTime() > 0)
        ? RelationState.HOSTILE
        : RelationState.NEUTRAL;
  }
}
