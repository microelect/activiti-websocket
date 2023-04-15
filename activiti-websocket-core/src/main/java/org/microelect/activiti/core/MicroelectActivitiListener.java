package org.microelect.activiti.core;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.BaseEntityEventListener;

public class MicroelectActivitiListener extends BaseEntityEventListener {

    @Override
    protected void onCreate(ActivitiEvent event) {
        super.onCreate(event);
    }

    @Override
    protected void onInitialized(ActivitiEvent event) {
        super.onInitialized(event);
    }

    @Override
    protected void onDelete(ActivitiEvent event) {
        super.onDelete(event);
    }

    @Override
    protected void onUpdate(ActivitiEvent event) {
        super.onUpdate(event);
    }

    @Override
    protected void onEntityEvent(ActivitiEvent event) {
        super.onEntityEvent(event);
    }
}
