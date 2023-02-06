package com.pauljuma.karibuapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.pauljuma.karibuapp.HomeActivity
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentSignInBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class SignInFragment : Fragment() {
    lateinit var signInBinding: FragmentSignInBinding
    lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        signInBinding = FragmentSignInBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()

        signInBinding.btnSignIn.setOnClickListener {
            loginUser()
        }
        return signInBinding.root
    }

    private fun loginUser() {
        val email = signInBinding.tfEmailSignIn.text.toString()
        val password = signInBinding.tfPasswordSignIn.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            Toast.makeText(
                                requireContext(),
                                "You have successfully logged in",
                                Toast.LENGTH_SHORT
                            ).show()
                        }.addOnFailureListener {
                            Toast.makeText(
                                requireContext(),
                                "please confirm your credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        }.addOnCanceledListener {
                            Toast.makeText(
                                requireContext(),
                                "An error occurred please try again later",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .await()
                    withContext(Dispatchers.Main) {
                        checkLoginStatus()
                    }

                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            "You have entered the wrong credentials",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        }
    }

    private fun checkLoginStatus() {
        if (auth.currentUser == null) {
            Toast.makeText(requireContext(), "Confirm your credentials please", Toast.LENGTH_SHORT)
                .show()
        } else{
            val intent = Intent(requireContext(), HomeActivity::class.java)
            requireContext().startActivity(intent)
        }
    }
}