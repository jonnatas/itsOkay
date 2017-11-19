package com.example.jonnatas.itsokay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jonnatas.itsokay.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private  Usuario usuario;
    EditText email;
    EditText editRegisterPassword;
    Button buttonRegister;
    Button buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.editTextRegister);
        editRegisterPassword = (EditText) findViewById(R.id.editRegisterPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);

    }

    public void registerUser(View view){
        usuario = new Usuario();
        final String email = this.email.getText().toString().trim();
        final String password = editRegisterPassword.getText().toString().trim();

        usuario.setEmail(email);

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, R.string.enter_your_email, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.enter_your_password, Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = task.getResult().getUser();
                            usuario.setId(user.getUid());

                            Toast.makeText(RegisterActivity.this, R.string.successfully_registred, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, InicioActivity.class);
                            intent.putExtra("email", email);
                            startActivity(intent);

                        } else {
                            Toast.makeText(RegisterActivity.this, R.string.regristration_error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void registerCancel(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }


}