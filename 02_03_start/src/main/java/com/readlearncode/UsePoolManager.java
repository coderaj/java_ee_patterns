package com.readlearncode;

import javax.inject.Inject;

public class UsePoolManager {
    @Inject
    private PoolManager poolManager;

    public void usePooledObject(){
        Object object = poolManager.borrowObject();

        // use object

        poolManager.returnObject(object);
    }
}
