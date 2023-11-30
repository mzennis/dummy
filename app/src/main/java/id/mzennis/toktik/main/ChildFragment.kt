package id.mzennis.toktik.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import id.mzennis.toktik.MyApplication
import id.mzennis.toktik.databinding.FragmentChildBinding
import id.mzennis.toktik.login.LoginActivity
import id.mzennis.toktik.main.di.DaggerMainComponent
import javax.inject.Inject

class ChildFragment : Fragment() {

    companion object {

        fun createInstance(position: Int): ChildFragment {
            return ChildFragment().apply {
                arguments = Bundle().apply {
                    putInt("position", position)
                }
            }
        }
    }

    private var _binding: FragmentChildBinding? = null
    private val binding get() = _binding!!

    private val position: Int
        get() {
            return arguments?.getInt("position") ?: -1
        }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ChildViewModel by viewModels { viewModelFactory }

    private val goToLogin = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            renderButton()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder()
            .applicationComponent((requireActivity().application as MyApplication).appComponent)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChildBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myData = viewModel.getMyData(position).joinToString { "\n$it" }
        binding.text.text = myData
        binding.btnAction.setOnClickListener {
            goToLogin.launch(
                Intent(requireContext(), LoginActivity::class.java)
            )
        }

        renderButton()
    }

    private fun renderButton() {
        binding.btnAction.text = if (viewModel.isLoggedIn) "Now, Logout?" else "You have to login first!"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}