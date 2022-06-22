package iva.rep.xsknng

import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import iva.rep.xsknng.base.BaseFragment
import iva.rep.xsknng.binding.viewBinding
import iva.rep.xsknng.databinding.FragmentMainBinding

class MainFragment(
    private val listener : Listener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main),
    MenuAdapter.Listener {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val menus: Menu
        get() = listener.menu

    private val adapter by lazy { MenuAdapter(menus, this) }

    override fun setupViews() {
        with(binding){
            menuRecycler.layoutManager = LinearLayoutManager(requireContext())
            menuRecycler.adapter = adapter
        }
    }

    override fun viewModelObservers() {
    }

    interface Listener {
        val menu: Menu
        fun onMenuClick(menuItem: MenuItem)
    }

    override fun onMenuClick(menuItem: MenuItem) {
        listener.onMenuClick(menuItem)
    }
}