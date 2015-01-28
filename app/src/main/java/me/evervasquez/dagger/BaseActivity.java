package me.evervasquez.dagger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.List;

import dagger.ObjectGraph;
import me.evervasquez.dagger.modules.ActivityModule;
import me.evervasquez.dagger.utils.DaggerApplication;

/**
 * Created by eveR on 28/01/15.
 */
public abstract class BaseActivity extends ActionBarActivity{
    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cast del object application
        DaggerApplication app = (DaggerApplication) getApplication();
        List<Object> modules = getModules();
        //aniadimos un modulo
        modules.add(new ActivityModule(this));
        objectGraph = app.plus(modules);
        objectGraph.inject(this);
    }

    protected abstract List<Object> getModules();
}
