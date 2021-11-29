package com.wanda.idn.foodiest.model.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.wanda.idn.foodiest.databinding.ItemRecipeBinding
import com.wanda.idn.foodiest.model.Recipes
import com.wanda.idn.foodiest.model.activity.DetailActivity
import com.bumptech.glide.Glide as Glide

class RecipesAdopter (private val listRecipes: ArrayList<Recipes>) : RecyclerView.Adapter<RecipesAdopter.RecipesViewHolder>() {
    inner class RecipesViewHolder (val binding : ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecipesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        with(holder){
            with(listRecipes[position]){
                Glide.with(holder.itemView.context).load(pictures).apply(RequestOptions().override(100,200)).into(binding.ivItemRecipe)
                binding.TvItemName.text = name
                binding.TvItemCategory.text = category
                binding.TvItemNumber.text = number
                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val dataSend = Recipes(
                        name = listRecipes[position].name,
                        category = listRecipes[position].category,
                        description = listRecipes[position].description,
                        ingredients = listRecipes[position].ingredients,
                        instructions = listRecipes[position].instructions,
                        pictures = listRecipes[position].pictures,
                        number = listRecipes[position].number,
                        calories = listRecipes[position].calories,
                        carbo = listRecipes[position].carbo,
                        protein = listRecipes[position].protein

                    )
                    val intentToDetail = Intent(mContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)
                }


            }
        }
    }

    override fun getItemCount(): Int = listRecipes.size
}