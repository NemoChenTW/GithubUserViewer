package com.nemo.githubuserviewer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nemo.githubuserviewer.databinding.BidirectionalFollowedFragmentBinding
import com.nemo.githubuserviewer.model.data.DetailedUser
import com.nemo.githubuserviewer.model.data.ListedUser
import com.nemo.githubuserviewer.ui.main.viewmodel.BidirectionalFollowedViewModel

class BidirectionalFollowedFragment(private val followerList: List<ListedUser>) : Fragment() {

    private lateinit var binding: BidirectionalFollowedFragmentBinding
    private lateinit var viewModel: BidirectionalFollowedViewModel

    private val followerElementAdapter = FollowerElementAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BidirectionalFollowedFragmentBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = followerElementAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(BidirectionalFollowedViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        followerElementAdapter.submitList(followerList)
    }

    companion object {
        const val TAG = "BidirectionalFollowedFragment"
    }

}