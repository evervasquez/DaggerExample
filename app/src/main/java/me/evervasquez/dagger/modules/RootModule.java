package me.evervasquez.dagger.modules;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.evervasquez.dagger.MainActivity;
import me.evervasquez.dagger.trash.B;
import me.evervasquez.dagger.trash.C;
import me.evervasquez.dagger.utils.DaggerApplication;

/**
 * Created by eveR on 28/01/15.
 */

@Module(injects = {DaggerApplication.class, MainActivity.class}, library = true)

public class RootModule {
    private static Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    //para diferenciar el context
    @Named("ApplicationContext")
    @Provides
    Context provideAplicationContext() {
        return this.context;
    }

    @Provides
    @Singleton
    B provideB(C c) {
        return c;
    }
}
