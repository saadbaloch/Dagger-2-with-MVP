package mvp.bhatti.com.mvplogin.di;

import javax.inject.Singleton;

import dagger.Component;
import mvp.bhatti.com.mvplogin.MainActivity;
import mvp.bhatti.com.mvplogin.presenter.LoginPresenter;
import mvp.bhatti.com.mvplogin.view.LoginActivity;

/**
 * Created by saad on 31/07/2018.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void injectLoginActivity(LoginActivity loginActivity);

}
