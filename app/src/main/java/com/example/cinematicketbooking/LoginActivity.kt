package com.example.cinematicketbooking

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton
    private lateinit var btnGoogle: MaterialButton
    private lateinit var btnFacebook: MaterialButton
    private lateinit var tvForgotPassword: TextView
    private lateinit var tvSignup: TextView
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        setupClickListeners()
        setupSignupText()
    }

    private fun initViews() {
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnGoogle = findViewById(R.id.btn_google)
        btnFacebook = findViewById(R.id.btn_facebook)
        tvForgotPassword = findViewById(R.id.tv_forgot_password)
        tvSignup = findViewById(R.id.tv_signup)
        ivBack = findViewById(R.id.iv_back)
    }

    private fun setupClickListeners() {
        ivBack.setOnClickListener {                    // Back button
            finish()
        }

        btnLogin.setOnClickListener {                           // Login button - simplified, no validation
            handleLogin()
        }
        btnGoogle.setOnClickListener {
            handleGoogleLogin()
        }
        btnFacebook.setOnClickListener {
            handleFacebookLogin()
        }
        tvForgotPassword.setOnClickListener {
            handleForgotPassword()
        }
    }

    private fun setupSignupText() {
        val text = "Don't have an account? Sign Up"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Navigate to Sign Up Activity
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(this@LoginActivity, R.color.primary_purple)
                ds.isUnderlineText = false
            }
        }

        // Find the start and end index of "Sign Up"
        val signUpStart = text.indexOf("Sign Up")
        val signUpEnd = signUpStart + "Sign Up".length

        spannableString.setSpan(
            clickableSpan,
            signUpStart,
            signUpEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvSignup.text = spannableString
        tvSignup.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun handleLogin() {

        // Navigate to MainActivity (Home Screen)
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun handleForgotPassword() {
        handleForgotPassword()
    }
    private fun handleGoogleLogin() {
        handleGoogleLogin()
    }
    private fun handleFacebookLogin() {
        handleFacebookLogin()
    }
}