package com.example.thestuddyproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {



    private EditText email;
    private EditText password;
    private Button signin;
    private ProgressBar progressBar;
 private EditText confirmPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        signin = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progressBar);
        confirmPassword = findViewById(R.id.input_confirm_password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: attempting to register.");

                //check for null valued EditText fields
                if(!isEmpty(email.getText().toString())
                        && !isEmpty(password.getText().toString())
                        && !isEmpty(confirmPassword.getText().toString())){

                        //check if passwords match
                        if(doStringsMatch(password.getText().toString(), confirmPassword.getText().toString())){

                            //Initiate registration task
                            registerNewEmail(email.getText().toString(), password.getText().toString());
                        }else{
                            Toast.makeText(RegisterActivity.this, "Passwords do not Match", Toast.LENGTH_SHORT).show();
                        }
                }
                else{
                    Toast.makeText(RegisterActivity.this, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }

    private void registerNewEmail(String email, String password) {
        showDialog();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseAuth.getInstance().signOut();
                } else  {
                    Toast.makeText(RegisterActivity.this, "unable to register", Toast.LENGTH_SHORT);
                }
                hideDialog();
            }
        });
    }





 // ---------------------------------------------------------------------------------------------------- //
    private boolean isEmpty(String string){
        return string.equals("");
    }

    private boolean doStringsMatch(String s1, String s2){
        return s1.equals(s2);
    }

    private void showDialog(){
        progressBar.setVisibility(View.VISIBLE);

    }

    private void hideDialog(){
        if(progressBar.getVisibility() == View.VISIBLE){
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            return;
        }
    }


}