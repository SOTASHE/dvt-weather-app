package com.snaye.dvtweatherapp.ui.weather.future.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snaye.dvtweatherapp.R

class FutureDetailWearherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDetailWearherFragment()
    }

    private lateinit var viewModel: FutureDetailWearherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detail_wearher_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FutureDetailWearherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}