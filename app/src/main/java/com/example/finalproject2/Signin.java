package com.example.finalproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.concurrent.TimeUnit;

public class Signin extends AppCompatActivity {

    private EditText fNameEd,lNameEd,emailAddEd,passEd,confirmpassword,phoneNumber;

    private Button joinBtn;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String Phone_Number;
    private static final String KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress";

    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_CODE_SENT = 2;
    private static final int STATE_VERIFY_FAILED = 3;
    private static final int STATE_VERIFY_SUCCESS = 4;
    private static final int STATE_SIGNIN_FAILED = 5;
    private static final int STATE_SIGNIN_SUCCESS = 6;

    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        fNameEd=(EditText) findViewById(R.id.firstname);
        lNameEd=(EditText) findViewById(R.id.lastname);
        emailAddEd=(EditText) findViewById(R.id.txteml);
        passEd=(EditText) findViewById(R.id.txtpassword);
        joinBtn=(Button) findViewById(R.id.btnregister);
        phoneNumber=(EditText) findViewById(R.id.phoneNumber);
        confirmpassword=(EditText)findViewById(R.id.cnfpass);
        signin=findViewById(R.id.ulogin);
        firebaseAuth=FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Signin.this,Login.class);
                startActivity(in);
            }
        });
        
        joinBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                String emailid=emailAddEd.getText().toString();
                String Passwords=passEd.getText().toString();
                String Confirm_Passwords=confirmpassword.getText().toString();
               String first_name=fNameEd.getText().toString();
               String last_name=lNameEd.getText().toString();
                Phone_Number="+1"+phoneNumber.getText().toString();


                if(TextUtils.isEmpty(first_name))
                {
                    Toast.makeText(Signin.this,"Please enter first name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(last_name))
                {
                    Toast.makeText(Signin.this,"Please enter last name",Toast.LENGTH_SHORT).show();
                    return;
                }



                if(TextUtils.isEmpty(Passwords))
                {
                    Toast.makeText(Signin.this,"Please enter password name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Confirm_Passwords))
                {
                    Toast.makeText(Signin.this,"Please enter confirm password name",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Passwords.length()<6)
                {
                    Toast.makeText(Signin.this,"PASWORD IS TOO SHORT",Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(emailid))
                {
                    Toast.makeText(Signin.this,"Please enter email name",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    firebaseAuth.fetchSignInMethodsForEmail(emailid).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            Log.d("", "" + task.getResult().getSignInMethods().size());
                            if (task.getResult().getSignInMethods().size() == 0) {


                                if (Passwords.equals(Confirm_Passwords))
                                {
                                    firebaseAuth.createUserWithEmailAndPassword(emailid, Passwords)
                                            .addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()) {


                                                                    Intent in=new Intent(Signin.this,Login.class);
                                                                        startActivity(in);
//                                                                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                                                                            Phone_Number,
//                                                                            60,
//                                                                            TimeUnit.SECONDS,
//                                                                            Signin.this,
//                                                                            mCallbacks
//                                                                            );

                                                                }
                                                                else {
                                                                    Toast.makeText(Signin.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                                }
                                                            }
                                                        });


                                                    } else {

                                                        Toast.makeText(Signin.this,"Authentication Failed",Toast.LENGTH_SHORT).show();

                                                    }

                                                    // ...
                                                }
                                            });
                                }
                                else {
                                    Toast.makeText(Signin.this,"pasword dose not match",Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(Signin.this,"Email id Already Registered",Toast.LENGTH_SHORT).show();
                                return;
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });
                }




            }


        });

            mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    Log.d("TAG", "onVerificationCompleted:" + phoneAuthCredential);
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Log.w("TAG", "onVerificationFailed", e);

                    if (e instanceof FirebaseAuthInvalidCredentialsException) {
                        // Invalid request
                        // ...
                    } else if (e instanceof FirebaseTooManyRequestsException) {
                        // The SMS quota for the project has been exceeded
                        // ...
                    }
                }

                @Override
                public void onCodeSent(@NonNull String verificationId,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {
                    // The SMS verification code has been sent to the provided phone number, we
                    // now need to ask the user to enter the code and then construct a credential
                    // by combining the code with a verification ID.
                    Log.d("TAG", "onCodeSent:" + verificationId);

                    // Save verification ID and resending token so we can use them later
                    mVerificationId = verificationId;
                    mResendToken = token;
//                  Intent in=new Intent(Signin.this,MainActivity.class);
//                  startActivity(in);


                    // ...
                }
            };


//                addRecord(uname,emailid,Passwords);
//                Intent in=new Intent(Signin.this,Login.class);
//                startActivity(in);

    }


}