package com.nemo.githubuserviewer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nemo.githubuserviewer.R
import com.nemo.githubuserviewer.databinding.DetailedUserFragmentBinding
import com.nemo.githubuserviewer.model.UserRepository
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.ui.main.viewmodel.DetailedUserViewModel
import com.nemo.githubuserviewer.ui.main.viewmodel.DetailedUserViewModelFactory

class DetailedUserFragment(private val detailedUser: DetailedUser, private val userRepository: UserRepository) : Fragment() {

    private lateinit var binding: DetailedUserFragmentBinding
    private lateinit var viewModel: DetailedUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DetailedUserFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, DetailedUserViewModelFactory(detailedUser, userRepository))[DetailedUserViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.biFollowing.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                Toast.makeText(context, "Sorry, you have no friends.", Toast.LENGTH_SHORT).show()
            } else {
                showBidirectionalFollowers(BidirectionalFollowedFragment(it))
            }

        })
    }

    private fun showBidirectionalFollowers(fragment: BidirectionalFollowedFragment) {
        requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                )
                .add(R.id.container, fragment)
                .show(fragment)
                .addToBackStack(BidirectionalFollowedFragment.TAG)
                .commit()
    }

    companion object {
        const val TAG = "DetailedUserFragment"
    }

}
