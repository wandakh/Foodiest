package com.wanda.idn.foodiest.model.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.wanda.idn.foodiest.databinding.FragmentBreakfastBinding
import com.wanda.idn.foodiest.model.DataRecipes
import com.wanda.idn.foodiest.model.Recipes
import com.wanda.idn.foodiest.model.adapter.RecipesAdopter


class BreakfastFragment : Fragment() {
    private lateinit var breakfastBinding: FragmentBreakfastBinding
    private var list : ArrayList<Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        breakfastBinding = FragmentBreakfastBinding.inflate(inflater, container, false)
        return breakfastBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            val recipesAdopter = RecipesAdopter(list)
            adapter = recipesAdopter
        }

    }

    
}