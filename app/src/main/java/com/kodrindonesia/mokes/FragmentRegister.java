package com.kodrindonesia.mokes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by royyan on 2/9/2016.
 */

public class FragmentRegister extends Fragment {

    private EditText etFName, etUserName, etPhoneNo, etEmail, etPass;
    private IFragRegister context;

    public interface IFragRegister {
        void FinishRegister(int result, Intent data);
    }

    public static FragmentRegister newInstance() {
        FragmentRegister f = new FragmentRegister();
        return f;
    }

    public FragmentRegister() {
        Log.d(LoginActivity.TAG, "construct fragment register");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LoginActivity.TAG, "onCreateView fragment register");
        View view = inflater.inflate(R.layout.login_frag_form_register, container, false);

        etFName = (EditText) view.findViewById(R.id.form_reg_full_name);
        etUserName = (EditText) view.findViewById(R.id.form_reg_user_name);
        etPhoneNo = (EditText) view.findViewById(R.id.form_reg_phone_number);
        etEmail = (EditText) view.findViewById(R.id.form_reg_email);
        etPass = (EditText) view.findViewById(R.id.form_reg_password);


        Button btnRegister = (Button) view.findViewById(R.id.form_register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });

        View backToLogin = (View) view.findViewById(R.id.form_back_to_login);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.FinishRegister(LoginCantActivity.RESULT_CANCELED, null);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (IFragRegister) context;
    }

    private void attemptRegister() {

        EditText[] etarry = {etFName, etUserName, etPhoneNo, etEmail, etPass};
        // Reset errors.
        for (EditText item : etarry) {
            item.setError(null);
        }



        boolean cancel = false;
        View focusView = null;
        for (EditText item : etarry) {
            String input_data = item.getText().toString();
            if (TextUtils.isEmpty(input_data)) {
                cancel = true;
                item.setError(getString(R.string.error_field_required));
                focusView = item;
                break;
            }

            if (item == etPass && !isPasswordValid(input_data)) {
                item.setError(getString(R.string.error_invalid_password));
                focusView = item;
                cancel = true;
                break;
            }

            if (item == etEmail && !isEmailValid(input_data)) {
                item.setError(getString(R.string.error_invalid_email));
                focusView = item;
                cancel = true;
                break;
            }
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://mokes.kodrindonesia.com/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            UserApi user_api = retrofit.create(UserApi.class);

            Call<Users> call = user_api.Register("rezaandroid", "reza@gmailandroid.com");

            call.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Response<Users> response, Retrofit retrofit) {
//                   if(response.body().code=="200") {
                       Toast.makeText(getActivity(),("Registrasi Berhasil"),Toast.LENGTH_SHORT).show();
//                   }
//                    for (Users.UserItem user : response.body().getUsers()) {
//                        etPass.append("Id = " + String.valueOf(user.getId()) +
//                                        System.getProperty("line.separator") +
//                                        "Email = " + user.getEmail() +
//                                        System.getProperty("line.separator") +
//                                        "Password = " + user.getPassword() +
//                                        System.getProperty("line.separator") +
//                                        "Token Auth = " + user.getToken_auth() +
//                                        System.getProperty("line.separator") +
//                                        "Name = " + user.getName() +
//                                        System.getProperty("line.separator") +
//                                        "Updated at = " + user.getUpdated_at() +
//                                        System.getProperty("line.separator")
//                        );
//                    }
                }

                @Override
                public void onFailure(Throwable t)
                {
                    etEmail.setText(String.valueOf(t));}

            });


        }


//        if (cancel) {
//            focusView.requestFocus();
//        } else {
//
//            Intent goingBack = new Intent();
//            for(EditText item : etarry) {
//                goingBack.putExtra(String.valueOf(item.getId()),item.getText().toString());
//            }
//            context.FinishRegister(LoginCantActivity.RESULT_OK, goingBack);
//
//        }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
