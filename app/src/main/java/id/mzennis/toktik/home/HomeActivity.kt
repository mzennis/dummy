package id.mzennis.toktik.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import id.mzennis.toktik.databinding.ActivityHomeBinding
import id.mzennis.toktik.databinding.ItemCountryBinding
import id.mzennis.toktik.home.di.DaggerHomeComponent
import id.mzennis.toktik.home.model.Country
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter by lazy { CountryAdapter() }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            hasFixedSize()
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.countries
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest { countries ->
                    adapter.submitList(countries)
                }
        }
    }

    private fun inject() {
        DaggerHomeComponent.create().inject(this)
    }

    internal class CountryAdapter : ListAdapter<Country, CountryAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem == newItem
            }
        }
    ) {

        inner class ViewHolder(
            private val binding: ItemCountryBinding
        ) : RecyclerView.ViewHolder(binding.root) {

            fun bind(country: Country) {
                binding.tvCountry.text = country.name
                binding.tvLanguages.text = country.languages.joinToString { it.name }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemCountryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(getItem(position))
        }
    }
}