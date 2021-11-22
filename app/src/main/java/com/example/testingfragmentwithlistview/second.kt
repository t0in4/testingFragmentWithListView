package com.example.testingfragmentwithlistview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class second : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val second = arrayOf<String>("Do something", "Do something", "Do something else")
        val listViewVar = view.findViewById<ListView>(R.id.listView1)
       val listViewAdapter = ArrayAdapter<String>(
           requireActivity(), android.R.layout.simple_list_item_1,
            second)

        listViewVar?.setAdapter(listViewAdapter)
        return view
    }


}