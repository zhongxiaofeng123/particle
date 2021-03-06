package com.particle.game.block.trigger.impl;

import com.particle.game.block.trigger.components.IEntityEnterBlockTrigger;
import com.particle.game.entity.state.EntityStateService;
import com.particle.game.entity.state.model.EntityStateType;
import com.particle.model.entity.Entity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WaterTrigger implements IEntityEnterBlockTrigger {

    @Inject
    private EntityStateService entityStateService;

    @Override
    public void trigger(Entity entity) {
        this.entityStateService.disableState(entity, EntityStateType.ON_FIRE.getName());
    }
}
