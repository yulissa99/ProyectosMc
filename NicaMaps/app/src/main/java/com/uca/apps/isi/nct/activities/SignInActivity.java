package com.uca.apps.isi.nct.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tumblr.remember.Remember;
import com.uca.apps.isi.nct.MainActivity;
import com.uca.apps.isi.nct.api.Api;
import com.uca.apps.isi.nct.models.AccessToken;
import com.uca.apps.isi.nct.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.uca.apps.isi.nct.R;

/**
 * Created by Deyrin Bonilla on 2/11/2017.
 */

public class SignInActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button signIn;
    private Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initViews();
    }

    private void initViews() {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.sign_in);
        signUp = (Button) findViewById(R.id.sign_up);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,SignUp2.class);
                startActivity(intent);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


    }

    /**
     * Esto sirve para iniar sesion.
     */
    private void signIn() {
        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Necesito un email xD", Toast.LENGTH_LONG).show();
        } else if(password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Necesito la contraseña chatel", Toast.LENGTH_LONG).show();
        } else {
            loginRequest(email.getText().toString(), password.getText().toString());
        }
    }

    /**
     * To make http request
     * @param email
     * @param password
     */
    private void loginRequest(String email, String password) {
        // instance a user
        User user = new User();
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
}
