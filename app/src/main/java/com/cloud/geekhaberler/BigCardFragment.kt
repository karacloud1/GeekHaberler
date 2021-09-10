package com.cloud.geekhaberler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cloud.geekhaberler.databinding.FragmentBigCardBinding
import com.squareup.picasso.Picasso


private const val ARG_PARAM1 = "head"
private const val ARG_PARAM2 = "content"
private const val ARG_PARAM3 = "image"


class BigCardFragment : Fragment() {
    private lateinit var binding: FragmentBigCardBinding
    private var head: String? = null
    private var content: String? = null
    private var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            head = it.getString(ARG_PARAM1)
            content = it.getString(ARG_PARAM2)
            image = it.getString(ARG_PARAM3)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_big_card, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(image).resize(700,0).into(binding.imageView)
        binding.txtHead.text = head
        binding.txtContent.text = content

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String) =
            BigCardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)

                }
            }
    }

}