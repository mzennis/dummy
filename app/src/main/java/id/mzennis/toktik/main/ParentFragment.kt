package id.mzennis.toktik.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import id.mzennis.toktik.databinding.FragmentParentBinding
import id.mzennis.toktik.main.adapter.ScreenSlidePagerAdapter

class ParentFragment : Fragment() {

    private var _binding: FragmentParentBinding? = null
    private val binding get() = _binding!!

    private val screenSlidePagerAdapter by lazy { ScreenSlidePagerAdapter(this@ParentFragment) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = screenSlidePagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Child ${(position + 1)}"
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}