package com.uca.apps.isi.nct.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tumblr.remember.Remember;
import com.uca.apps.isi.nct.MainActivity;
import com.uca.apps.isi.nct.R;
import com.uca.apps.isi.nct.api.Api;
import com.uca.apps.isi.nct.models.AccessToken;
import com.uca.apps.isi.nct.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        initViews();
    }

    private EditText name;
    private EditText email;
    private EditText password;
    private Button signUp;



    private void initViews() {
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.sign_up);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"entrandoo chatel",Snackbar.LENGTH_INDEFINITE).show();
                signUp();
            }
        });


    }

    /**
     * Esto sirve para iniar sesion.
     */
    /**
     * To make http request
     * @param email
     * @param password
     */
    private void loginRequest(String email, String password, String name) {
        // instance a user
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // create call
        Call<AccessToken> call = Api.instance().login(user);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.body() != null) {
                    Log.i("access_token", response.body().getId());
                    Remember.putString("access_token", response.body().getId(), new Remember.Callback() {
                        @Override
                        public void apply(Boolean success) {
                            if (success) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

            }
        });
    }

    private void signUp() {

        // instance a user
        User user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());

        // create call
        Call<User> call = Api.instance().signUp(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body() != null) {
                    loginRequest(name.getText().toString() ,email.getText().toString(), password.getText().toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }



}
