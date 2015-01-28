package me.evervasquez.dagger;

import android.content.Context;
import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;
import me.evervasquez.dagger.modules.MainActivityModule;
import me.evervasquez.dagger.trash.A;
import me.evervasquez.dagger.trash.B;
import me.evervasquez.dagger.trash.C;


public class MainActivity extends BaseActivity {

    @Inject
    A a;

    @Inject
    C c;

    @Inject
    B b;

    //inyectamos el contexto de la aplicacion
    @Inject
    @Named("ApplicationContext")
    Context appContext;

    //lazy
    @Inject
    Lazy<A> lazyA;

    //provider
    @Inject
    Provider<C> providerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a.dondeEstoy();
        b.toString();
        c.toString();

        //se ejecuta el constructor hasta que haga get
        lazyA.get();

        //se ejecuta cada vez el constructor cuando ejecutamos get de la clase C
        providerC.get();
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new LinkedList<Object>();
        modules.add(new MainActivityModule());
        return modules;
    }
}
