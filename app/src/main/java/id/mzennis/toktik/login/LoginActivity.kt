package id.mzennis.toktik.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.mzennis.toktik.MyApplication
import id.mzennis.toktik.databinding.ActivityLoginBinding
import id.mzennis.toktik.login.di.DaggerLoginComponent
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerLoginComponent.builder()
            .applicationComponent((application as MyApplication).appComponent)
            .build()
            .inject(this)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.text = if (viewModel.isLoggedIn) "You are now login, do u want to Logout?" else "Login"
        binding.btnLogin.setOnClickListener {
            val newState = !viewModel.isLoggedIn
            viewModel.setLogin(newState)
            setResult(RESULT_OK, Intent().apply {
                putExtra("newState", newState)
            })
            finish()
        }
    }
}