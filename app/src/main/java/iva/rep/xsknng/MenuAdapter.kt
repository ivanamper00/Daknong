package iva.rep.xsknng

import android.view.*
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import iva.rep.xsknng.databinding.ItemMenuBinding

class MenuAdapter(
    private val menu: Menu,
    private val listener: Listener
): RecyclerView.Adapter<MenuAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder.binding){
            menuTitle.text = menu[position].title
            root.setOnClickListener { listener.onMenuClick(menu[position]) }
        }
    }

    override fun getItemCount(): Int = menu.size()

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMenuBinding.bind(itemView)
        }
    }

    interface Listener {
        fun onMenuClick(menuItem: MenuItem)
    }
}