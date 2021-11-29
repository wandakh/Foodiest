package com.wanda.idn.foodiest.model.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.wanda.idn.foodiest.databinding.FragmentDesserBinding
import com.wanda.idn.foodiest.model.DataRecipes
import com.wanda.idn.foodiest.model.Recipes
import com.wanda.idn.foodiest.model.adapter.RecipesAdopter


class DesserFragment : Fragment() {
    private lateinit var desserBinding: FragmentDesserBinding
    private val list : ArrayList<Recipes> = arrayListOf()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       desserBinding = FragmentDesserBinding.inflate(inflater, container, false)
        return desserBinding.root

    }

    override fun onViewCreated(view : View, savedInstanceState: Bundle?) {
      list.addAll(DataRecipes.dataDessert)
        desserBinding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context,2)
            val recipesAdopter = RecipesAdopter(list)
            adapter = recipesAdopter
        }
    }


}