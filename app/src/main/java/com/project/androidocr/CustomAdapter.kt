package com.project.androidocr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText


class CustomAdapter(private val mList: ArrayList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sub_cateogry, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.edtProductPrice.setText(mList[position].price)
        holder.tvCategory.setText(mList[position].categoryName)
        holder.tvProductName.text = mList[position].itemName


        // sets the image to the imageview from our itemHolder class
        holder.tvCategory.setOnClickListener {
            val listPopupWindow = ListPopupWindow(holder.tvCategory.context, null, R.attr.listPopupWindowStyle)
            listPopupWindow.anchorView = holder.tvCategory.rootView

            val items = holder.tvCategory.context.resources.getStringArray(R.array.categories)
            val adapter = ArrayAdapter( holder.tvCategory.context, android.R.layout.simple_list_item_1, items)
            listPopupWindow.setAdapter(adapter)
            listPopupWindow.show()
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val edtProductPrice: TextInputEditText = itemView.findViewById(R.id.edtProductPrice)
        val tvCategory: TextInputEditText = itemView.findViewById(R.id.tvCategory)

    }
}