package iva.rep.xsknng

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import iva.rep.xsknng.binding.viewBinding
import iva.rep.xsknng.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    MainFragment.Listener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var fragments: List<Fragment>

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        fragments = listOf(
            MainFragment(this),
            OthersFragment(Data.items[0]),
            OthersFragment(Data.items[1]),
            OthersFragment(Data.items[2]),
            OthersFragment(Data.items[3]),
        )
        viewPagerAdapter = ViewPagerAdapter(this, fragments)
        with(binding){
            bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home -> setViewPager(0)
                    R.id.about -> setViewPager(1)
                    R.id.strategy -> setViewPager(2)
                    R.id.advice -> setViewPager(3)
                    R.id.history -> setViewPager(4)
                }
                true
            }


            with(viewPager){
                adapter = viewPagerAdapter
                offscreenPageLimit = 4
                isUserInputEnabled = false

                registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        when(position){
                            0 -> setBottomNav(R.id.home)
                            1 -> setBottomNav(R.id.about)
                            2 -> setBottomNav(R.id.strategy)
                            3 -> setBottomNav(R.id.advice)
                            4 -> setBottomNav(R.id.history)
                        }
                    }
                })
            }
        }
    }

    private fun setBottomNav(id: Int) {
        binding.bottomNavigationView.selectedItemId = id
    }

    private fun setViewPager(i: Int) {
        binding.viewPager.currentItem = i
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override val menu: Menu
        get() = binding.bottomNavigationView.menu

    override fun onMenuClick(menuItem: MenuItem) {
        setBottomNav(menuItem.itemId)
    }
}