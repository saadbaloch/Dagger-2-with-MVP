package mvp.bhatti.com.mvplogin.di;

import javax.inject.Singleton;

import dagger.Component;
import mvp.bhatti.com.mvplogin.MainActivity;

/**
 * Created by saad on 31/07/2018.
 */

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {

    void injectHomeActivity(MainActivity mainActivity);
}
