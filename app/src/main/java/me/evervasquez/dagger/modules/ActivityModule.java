package me.evervasquez.dagger.modules;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eveR on 28/01/15.
 */

@Module(library = true,complete = false)
public class ActivityModule {
    private Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Named("ActivityConte")
    @Provides Context provideAplicationContext(){
        return  this.context;
    }
}
