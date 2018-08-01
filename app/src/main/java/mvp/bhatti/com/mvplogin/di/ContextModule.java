package mvp.bhatti.com.mvplogin.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by saad on 31/07/2018.
 */
@Module
public class ContextModule {
    Context context;
    public ContextModule(Context context)
    {
        this.context=context;

    }

    @Provides
    public Context getContext()
    {
        return context.getApplicationContext();
    }
}
