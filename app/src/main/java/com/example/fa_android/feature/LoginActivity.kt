package com.example.fa_android.feature

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.fa_android.R
import com.example.fa_android.ui.screen.LoginScreen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginActivity : ComponentActivity() {
    lateinit var googleSigneInClient: GoogleSignInClient


    private val auth = FirebaseAuth.getInstance()
    private val activityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {

                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    Log.d("TAG", "onCreate: 실패 :${e}")

                    // Google Sign In failed, update UI appropriately
                    Log.w("TAG", "Google sign in failed", e)
                }

            } else {
                Log.d("TAG", "login error: ${result.resultCode}, ${result.data} ")
            }


        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen { signIn() }
        }
        initSetting()
        // startActivityForResult 랑 같음

        /*
            현재 로직이 실행 안됨
         */


    }

    private fun firebaseAuthWithGoogle(idToken: String) {

        Log.d("TAG", "firebaseAuthWithGoogle: 0 ")
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithCredential:success")

                    Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun signIn() {

        Log.d("TAG", "signIn: ")
        val signInIntent = googleSigneInClient.signInIntent
        activityLauncher.launch(signInIntent)
    }

    private fun initSetting() {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        googleSigneInClient = GoogleSignIn.getClient(this, gso)
    }
}