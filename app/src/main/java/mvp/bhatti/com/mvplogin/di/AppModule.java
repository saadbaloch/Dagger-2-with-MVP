package mvp.bhatti.com.mvplogin.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import mvp.bhatti.com.mvplogin.model.interacter.LoginInteracter;
import mvp.bhatti.com.mvplogin.model.interacter.LoginInteracterImpl;
import mvp.bhatti.com.mvplogin.presenter.LoginPresenter;
import mvp.bhatti.com.mvplogin.presenter.LoginPresenterImpl;
import mvp.bhatti.com.mvplogin.view.LoginView;

/**
 * Created by saad on 31/07/2018.
 */

@Module
public class AppModule {

     LoginView loginView;

     public AppModule(LoginView loginView)
     {
       this.loginView=loginView;
     }

     @Provides
     public LoginPresenter loginPresenter(LoginInteracter loginInteracter)
     {
         return new LoginPresenterImpl(loginView,loginInteracter);
     }

     @Provides
     public LoginInteracter loginInteracter()
     {
         return new LoginInteracterImpl();
     }
}
