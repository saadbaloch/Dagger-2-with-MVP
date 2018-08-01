package mvp.bhatti.com.mvplogin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

import javax.inject.Inject;

import mvp.bhatti.com.mvplogin.di.AppComponent;
import mvp.bhatti.com.mvplogin.di.AppModule;
import mvp.bhatti.com.mvplogin.di.ContextModule;
import mvp.bhatti.com.mvplogin.di.DaggerAppComponent;
import mvp.bhatti.com.mvplogin.di.MainModule;
import mvp.bhatti.com.mvplogin.presenter.LoginPresenter;
import mvp.bhatti.com.mvplogin.MainActivity;
import mvp.bhatti.com.mvplogin.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText etUsername,etPassword;
    Button btLogin;
    ProgressBar progressBar;
    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       AppComponent daggerAppComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        daggerAppComponent.injectLoginActivity(this);
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        btLogin = findViewById(R.id.bt_login);
        progressBar = findViewById(R.id.pg_progress);
      //  mLoginPresenter = new LoginPresenterImpl(this,new LoginInteracterImpl());
       // mLoginPresenter = new LoginPresenterImpl(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String username = AESCrypt.encrypt("username",etUsername.getText().toString().trim());
                    String pswrd = AESCrypt.encrypt("pswrd",etPassword.getText().toString().trim());
                    mLoginPresenter.validateCredetials(username,pswrd);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setPasswordError() {
        etPassword.setError("Enter Password");

    }

    @Override
    public void setUsernameError() {
        etUsername.setError("Enter Username");

    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }

    @Override
    public void showAlertError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
