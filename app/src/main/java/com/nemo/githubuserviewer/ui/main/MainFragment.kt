package com.nemo.githubuserviewer.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.githubuserviewer.R
import com.nemo.githubuserviewer.databinding.MainFragmentBinding
import com.nemo.githubuserviewer.di.GithubUserViewerComponentProvider
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.ui.main.viewmodel.MainViewModel
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: MainFragmentBinding
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }
    private val listedUserElementAdapter = ListedUserElementAdapter(object : ItemClick<ListedUser> {
        override fun onItemClicked(view: View, item: ListedUser) {
            viewModel.userDetail(item.login)
        }

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = listedUserElementAdapter

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as GithubUserViewerComponentProvider).provideGithubUserViewerComponent()
            .githubUserViewerUIComponentFactory().create()
            .inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.usersList.observe(viewLifecycleOwner, Observer {
            listedUserElementAdapter.submitList(it)
        })

        viewModel.detailedUser.observe(viewLifecycleOwner, Observer {
            it?.let {
                showDetailedUser(DetailedUserFragment(it))
            }
        })
    }

    private fun showDetailedUser(fragment: DetailedUserFragment) {
        requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                )
                .add(R.id.container, fragment)
                .show(fragment)
                .addToBackStack(DetailedUserFragment.TAG)
                .commit()
    }

}
