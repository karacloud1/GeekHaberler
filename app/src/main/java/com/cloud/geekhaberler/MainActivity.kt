package com.cloud.geekhaberler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.cloud.geekhaberler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var transection : FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        transection = supportFragmentManager.beginTransaction()

        val bigCard1 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")
        val bigCard2 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")
        val bigCard3 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")
        val bigCard4 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")
        val bigCard5 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")
        val bigCard6 = BigCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme")

        val smallCard1 = SmallCardFragment.newInstance("Alışık Olmadığımız Bir Marvel Filmi: Shang Chi ve On Halkanın Efsanesi SPOILERSIZ İnceleme","a")
        transection.add(binding.linearLayout.id,bigCard1)
        transection.add(binding.linearLayout.id,bigCard2)
        transection.add(binding.linearLayout.id,smallCard1)
        transection.add(binding.linearLayout.id,bigCard3)
        transection.add(binding.linearLayout.id,bigCard4)
        transection.add(binding.linearLayout.id,bigCard5)
        transection.add(binding.linearLayout.id,bigCard6)
        transection.commit()


    }

}