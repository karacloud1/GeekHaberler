package com.cloud.geekhaberler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cloud.geekhaberler.databinding.FragmentSmallCardBinding
import com.squareup.picasso.Picasso


private const val ARG_PARAM1 = "head"
private const val ARG_PARAM2 = "image"

class SmallCardFragment : Fragment() {
    private lateinit var binding : FragmentSmallCardBinding
    private var head: String? = null
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            head = it.getString(ARG_PARAM1)
            image = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_small_card,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtHead.text = head
        Picasso.get().load(image).resize(500,0).into(binding.imageView)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SmallCardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}