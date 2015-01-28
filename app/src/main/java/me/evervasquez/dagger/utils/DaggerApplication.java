package me.evervasquez.dagger.utils;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;
import me.evervasquez.dagger.modules.RootModule;

/**
 * Created by eveR on 28/01/15.
 */
public class DaggerApplication extends Application {

    //grafo the application
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {
        objectGraph = ObjectGraph.create(getModules());
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }

    public void inject(Object object){
        objectGraph.inject(object);
    }

    private Object[] getModules(){
        return new Object[]{
                new RootModule(this)
        };
    }

    //devuelve una copia del grafo a quienes se le aniado los modulos
    public ObjectGraph plus(List<Object> modules){
        if(modules==null){
            throw new IllegalArgumentException(
                    "You can't plus a null module, review your getModules() implementation");
        }
        return objectGraph.plus(modules.toArray());
    }

}
