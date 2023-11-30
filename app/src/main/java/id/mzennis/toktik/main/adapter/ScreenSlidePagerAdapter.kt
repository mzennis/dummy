package id.mzennis.toktik.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.mzennis.toktik.main.ChildFragment

class ScreenSlidePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return ChildFragment.createInstance(position)
    }
}