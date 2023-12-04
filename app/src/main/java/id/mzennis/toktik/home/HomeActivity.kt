package id.mzennis.toktik.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import id.mzennis.toktik.common.Session
import id.mzennis.toktik.databinding.ActivityHomeBinding
import id.mzennis.toktik.login.LoginActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    @Inject lateinit var session: Session

    private val goToLogin = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            renderButton()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        renderButton()
        binding.btnAction.setOnClickListener {
            goToLogin.launch(
                Intent(this, LoginActivity::class.java)
            )
        }
    }

    private fun renderButton() {
        binding.btnAction.text = if (session.isLoggedIn) "Now, Logout?" else "You have to login first!"
    }
}