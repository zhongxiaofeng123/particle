package com.particle.game.entity.ai.leaf.action.movement.action;

import com.particle.api.ai.behavior.EStatus;
import com.particle.api.ai.behavior.IAction;
import com.particle.game.entity.ai.components.Knowledge;
import com.particle.game.entity.ai.service.EntityDecisionServiceProxy;
import com.particle.game.entity.movement.PositionService;
import com.particle.model.entity.Entity;
import com.particle.model.math.Direction;
import com.particle.model.math.Vector3f;

import javax.inject.Inject;

public class EntityFocusePosition implements IAction {

    @Inject
    private EntityDecisionServiceProxy entityDecisionServiceProxy;

    @Inject
    private PositionService positionService;

    @Override
    public void onInitialize() {

    }

    @Override
    public EStatus tick(Entity entity) {

        // 检查是否有合法目标
        Vector3f targetPosition = this.entityDecisionServiceProxy.getKnowledge(entity, Knowledge.POSITION_TARGET, Vector3f.class);
        if (targetPosition != null) {
            Vector3f currentPosition = this.positionService.getPosition(entity);

            Vector3f moveDistance = targetPosition.subtract(currentPosition);

            this.positionService.setDirection(entity, new Direction(moveDistance));

            return EStatus.SUCCESS;
        }

        return EStatus.FAILURE;
    }

    @Override
    public void onTicked(Entity entity, EStatus status) {

    }

    @Override
    public void onRelease() {

    }

    @Override
    public void config(String key, Object val) {

    }
}
