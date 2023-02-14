package ru.akhmetovdaniyar.exchangerate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel: ViewModelActivity = ViewModelProvider(requireActivity())[ViewModelActivity::class.java]

        val count1: TextView = requireView().findViewById(R.id.count1)
        val count2: TextView = requireView().findViewById(R.id.count2)
        val count3: TextView = requireView().findViewById(R.id.count3)
        val button: Button = requireView().findViewById(R.id.buttonRefresh)

        viewModel.priceLivedata.observe(viewLifecycleOwner, Observer {
            count1.text = it[2]
            count2.text = it[0]
            count3.text = it[1]

        })

        button.setOnClickListener {
            viewModel.getInfo()
        }
    }
}