package com.readlearncode;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Startup
@Singleton
public class PoolManager {
    private Queue<Object> pooledObjects = new LinkedBlockingQueue<>(1000);

    public PoolManager() {
        for(int i=0;i<1_000;i++){
            pooledObjects.offer(new Object());
        }
    }



    public void returnObject(Object object){
        pooledObjects.offer(object);
    }

    public Object borrowObject(){
        return pooledObjects.poll();
    }
}
