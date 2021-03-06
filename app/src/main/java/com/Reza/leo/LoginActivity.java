package com.Reza.leo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.elmargomez.typer.Font;
import com.elmargomez.typer.Typer;
import com.Reza.leo.Domain.Authentication;
import com.Reza.leo.Domain.UserLoginTask;
import com.Reza.leo.api.Api;
import com.Reza.leo.api.UsersApi;
import com.Reza.leo.models.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginActivity extends AppCompatActivity implements UserLoginTask.IUserLoginTask {

    public static final String TAG = "Tuna";
    private final int REG = 1;

    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Boolean isUserUnknown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mEmailView.setTypeface(Typer.set(getApplicationContext()).getFont(Font.ROBOTO_REGULAR));
        mEmailView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent event) {

                if (id == EditorInfo.IME_ACTION_NEXT) {
                    if (mPasswordView != null) {
                        mPasswordView.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setTypeface(Typer.set(getApplicationContext()).getFont(Font.ROBOTO_REGULAR));
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setTypeface(Typer.set(getApplicationContext()).getFont(Font.ROBOTO_REGULAR));
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });



        TextView loginStaticText = (TextView) findViewById(R.id.login_static_text);
        loginStaticText.setTypeface(Typer.set(getApplicationContext()).getFont(Font.ROBOTO_REGULAR));




        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        isUserUnknown = true;
        Log.d(TAG, "login activity onCreate done");
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;

        if (requestCode == REG){
            String fName = data.getStringExtra(String.valueOf(R.id.form_reg_full_name));
            String username = data.getStringExtra(String.valueOf(R.id.form_reg_user_name));
            String phoneNo = data.getStringExtra(String.valueOf(R.id.form_reg_phone_number));
            String emailReg = data.getStringExtra(String.valueOf(R.id.form_reg_email));
            String passwReg = data.getStringExtra(String.valueOf(R.id.form_reg_password));

            Toast.makeText(this,fName+","+username+","+phoneNo+","+emailReg+","+passwReg,Toast.LENGTH_LONG).show();
        }
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            Log.d("DONDON", "Email: " + email + " Password: " + password);

            //Init retrofit
//            RestAdapter retrofit = new RestAdapter.Builder()
//                                                 .setEndpoint("http://mokes.kodrindonesia.com/api/v1/")
//                                                 .build();

            //create service
            UsersApi usersApi = Api.connect(UsersApi.class);
            usersApi.userLogin(email, password, new Callback<User>() {

                @Override
                public void success(User user, Response response) {
                    try {
                        String token = user.getToken();
                        Log.d("DONDON","Registrasi berhasil, TOKEN: " + token );
                        goToHome(user.getEmail(),user.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("DONDON","Please check your network connection");
                }
            });

//            mAuthTask = new UserLoginTask(this, email, password);
//            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow

        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public void goToHome(String email, String name) {
        Intent loggedIn = new Intent(this, MainActivity.class);
//        String email = mEmailView.getText().toString();
//        String password = mPasswordView.getText().toString();

        Authentication data = new Authentication(name);
        loggedIn.putExtra("auth", data);

        this.startActivity(loggedIn);

        Toast.makeText(this.getApplicationContext(), "Selamat Bergabung" , Toast.LENGTH_SHORT).show();
//        Snackbar snackbar = Snackbar
//                .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);LENGTH_LONG

//        snackbar.show();
        showProgress(false);
    }

    @Override
    public void OnPostExecute(Boolean success) {
        mAuthTask = null;

        if (success) {
            Intent loggedIn = new Intent(this, MainActivity.class);
            String email = mEmailView.getText().toString();
            String password = mPasswordView.getText().toString();

            Authentication data = new Authentication("Kodr Indonesia");

            loggedIn.putExtra("auth", data);

            this.startActivity(loggedIn);

            Toast.makeText(this.getApplicationContext(), "Selamat Datang", Toast.LENGTH_SHORT).show();
            showProgress(false);
            finish();
        } else if (isUserUnknown) {
            showProgress(false);
            mEmailView.setError(getString(R.string.invalid_user_name));
            mEmailView.requestFocus();
        } else {
            showProgress(false);
            mPasswordView.setError(getString(R.string.error_incorrect_password));
            mPasswordView.requestFocus();
        }
    }

    @Override
    public void OnCancelled() {
        mAuthTask = null;
        showProgress(false);
    }

    @Override
    public void OnUserUnkown(Boolean state) {
        isUserUnknown = state;
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1 ;
    }

    @Override
    public void onBackPressed() {

        System.exit(0);

    }
}

