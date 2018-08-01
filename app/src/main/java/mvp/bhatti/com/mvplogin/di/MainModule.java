package mvp.bhatti.com.mvplogin.di;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import mvp.bhatti.com.mvplogin.MainActivity;
import mvp.bhatti.com.mvplogin.presenter.MainPresenter;
import mvp.bhatti.com.mvplogin.presenter.MianPresenterInterface;
import mvp.bhatti.com.mvplogin.view.MainViewInterface;

/**
 * Created by saad on 31/07/2018.
 */
@Module(includes = ContextModule.class)
public class MainModule {
    MainViewInterface mainView;
    public MainModule(MainViewInterface mainView)
    {
        this.mainView=mainView;
    }

    @Provides
    public MainPresenter mainPresenter()
    {
        return new MainPresenter(mainView);
    }

    @Provides
    public RecyclerView.LayoutManager layoutManager(Context c)
    {
       return new GridLayoutManager(c , 2);
    }







}
