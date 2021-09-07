package com.cloud.geekhaberler

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.cloud.geekhaberler.databinding.ActivityMainBinding
import com.cloud.geekhaberler.databinding.FragmentBigCardBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BigCardFragment : Fragment() {
    private lateinit var binding : FragmentBigCardBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_big_card,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtHead.text = param1
        binding.txtContent.text = param2
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BigCardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}