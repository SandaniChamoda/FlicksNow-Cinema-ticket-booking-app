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

class SignupActivity : AppCompatActivity() {

    private lateinit var etName: TextInputEditText
    private lateinit var etPhone: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnRegister: MaterialButton
    private lateinit var btnGoogle: MaterialButton
    private lateinit var btnFacebook: MaterialButton
    private lateinit var tvLogin: TextView
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initViews()
        setupClickListeners()
        setupLoginText()
    }

    private fun initViews() {
        etName = findViewById(R.id.et_name)
        etPhone = findViewById(R.id.et_phone)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)
        btnRegister = findViewById(R.id.btn_register)
        btnGoogle = findViewById(R.id.btn_google)
        btnFacebook = findViewById(R.id.btn_facebook)
        tvLogin = findViewById(R.id.tv_login)
        ivBack = findViewById(R.id.iv_back)
    }

    private fun setupClickListeners() {
        // Back button
        ivBack.setOnClickListener {
            finish()
        }

        // Register button - simplified, no validation
        btnRegister.setOnClickListener {
            handleRegister()
        }

        // Google sign up
        btnGoogle.setOnClickListener {
            handleGoogleSignUp()
        }

        // Facebook sign up
        btnFacebook.setOnClickListener {
            handleFacebookSignUp()
        }
    }

    private fun setupLoginText() {
        val text = "Already have an account? Login"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Navigate to Login Activity
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(this@SignupActivity, R.color.primary_purple)
                ds.isUnderlineText = false
            }
        }

        // Find the start and end index of "Login"
        val loginStart = text.indexOf("Login")
        val loginEnd = loginStart + "Login".length

        spannableString.setSpan(
            clickableSpan,
            loginStart,
            loginEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvLogin.text = spannableString
        tvLogin.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun handleRegister() {
        // Navigate to Login Activity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleGoogleSignUp() {
        handleGoogleSignUp()
    }

    private fun handleFacebookSignUp() {
        handleFacebookSignUp()
    }
}