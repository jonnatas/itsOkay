package com.example.jonnatas.itsokay.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by jonnatas on 14/11/17.
 */

public final class ConfiguracaoFirebase {
    private static DatabaseReference reference;
    private static FirebaseAuth firebaseAuth;

    public static DatabaseReference getFirebase() {

        if (reference == null) {
            reference = FirebaseDatabase.getInstance().getReference();
        }

        return reference;
    }

    public static FirebaseAuth getFirebaseAuth() {
        if (firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }
}
