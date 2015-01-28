package me.evervasquez.dagger.trash;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by eveR on 28/01/15.
 */
public class A {

    @Inject
    public A() {
    }

    public void dondeEstoy(){
        Log.i(A.class.getSimpleName(),"Estoy en A");
    }
}
