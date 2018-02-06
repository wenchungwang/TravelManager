package com.travel_world.travelmanager;

import android.content.DialogInterface;

import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;



import java.util.HashMap;

import java.util.Map;



public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;

    FirebaseAuth.AuthStateListener authListener;

    private String userUID;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {

            @Override

            public void onAuthStateChanged(

                    @NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user!=null) {

                    Log.d("onAuthStateChanged", "登入:"+

                            user.getUid());

                    userUID =  user.getUid();

//                    addContact();

//                    updateContact();

//                    pushFriend("Jack");

                }else{

                    Log.d("onAuthStateChanged", "已登出");

                }

            }

        };

    }



    @Override

    protected void onStart() {

        super.onStart();

        auth.addAuthStateListener(authListener);

    }



    @Override

    protected void onStop() {

        super.onStop();

        auth.removeAuthStateListener(authListener);

    }



    public void login(View v){
        final Intent it = new Intent(LoginActivity.this, Main0Activity.class);
        final String email = ((EditText)findViewById(R.id.email))

                .getText().toString();

        final String password = ((EditText)findViewById(R.id.password))

                .getText().toString();

       Log.d("AUTH", email+"/"+password);

        auth.signInWithEmailAndPassword(email, password)

                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d("onComplete", "onComplete");

                        if (!task.isSuccessful()){

                            Log.d("onComplete", "登入失敗");

                            register(email, password);

                        }
                    /*
                        else  if("".equals(email))
                        {

                            Log.d("onComplete", "輸入空字元");
                        }
                        else if("".equals(password))
                        {
                            Log.d("onComplete", "輸入空字元2");
                        }
                        */
                        else
                        {
                            Log.d("NET", "LOGIN SUSS");
                            finish();
                            startActivity(it);

                        }

                    }

                });

    }



    private void register(final String email, final String password) {

        new AlertDialog.Builder(LoginActivity.this)

                .setTitle("登入問題")

                .setMessage("無此帳號，是否要以此帳號與密碼註冊?")

                .setPositiveButton("註冊", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialog, int which) {

                        createUser(email, password);

                    }

                })

                .setNeutralButton("取消", null)

                .show();

    }



    private void createUser(String email, String password) {

        auth.createUserWithEmailAndPassword(email, password)

                .addOnCompleteListener(

                        new OnCompleteListener<AuthResult>() {

                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {

                                String message =

                                        task.isComplete() ? "註冊成功" : "註冊失敗";

                                new AlertDialog.Builder(LoginActivity.this)

                                        .setMessage(message)

                                        .setPositiveButton("OK", null)

                                        .show();

                            }

                        });

    }



    private void addContact(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference usersRef = db.getReference("users");

        usersRef.child(userUID).child("phone").setValue("55667788");

        usersRef.child(userUID).child("nickname").setValue("Hank");

    }



    private void updateContact(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference usersRef = db.getReference("users");

        Map<String, Object> data = new HashMap<>();

        data.put("nickname", "Hank123");

        usersRef.child(userUID).updateChildren(data,

                new DatabaseReference.CompletionListener() {

                    @Override

                    public void onComplete(DatabaseError databaseError,

                                           DatabaseReference databaseReference) {

                        if (databaseError!=null){

                            //正確完成

                        }else{
                            Log.d("NET", "LOGIN FAIL");
                            //發生錯誤

                        }

                    }

                });

    }



    private void pushFriend(String name){

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference usersRef = db.getReference("users");

        DatabaseReference friendsRef =

                usersRef.child(userUID).child("friends").push();

        Map<String, Object> friend = new HashMap<>();

        friend.put("name", name);

        friend.put("phone", "22334455");

        friendsRef.setValue(friend);

        String friendId = friendsRef.getKey();

        Log.d("FRIEND", friendId+"");

    }

}
