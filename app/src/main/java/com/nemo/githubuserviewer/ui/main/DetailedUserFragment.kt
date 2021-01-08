package com.nemo.githubuserviewer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nemo.githubuserviewer.databinding.DetailedUserFragmentBinding
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.ui.main.viewmodel.DetailedUserViewModel
import com.nemo.githubuserviewer.ui.main.viewmodel.DetailedUserViewModelFactory

class DetailedUserFragment(val detailedUser: DetailedUser) : Fragment() {

    private lateinit var binding: DetailedUserFragmentBinding
    private lateinit var viewModel: DetailedUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DetailedUserFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, DetailedUserViewModelFactory(detailedUser))[DetailedUserViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val TAG = "DetailedUserFragment"
    }

}