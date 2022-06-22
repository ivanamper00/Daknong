package iva.rep.xsknng

import androidx.core.text.HtmlCompat
import iva.rep.xsknng.base.BaseFragment
import iva.rep.xsknng.binding.viewBinding
import iva.rep.xsknng.databinding.FragmentMainBinding
import iva.rep.xsknng.databinding.FragmentOthersBinding

class OthersFragment(
    private val content: DataModel
): BaseFragment<FragmentOthersBinding>(R.layout.fragment_others) {

    override val binding: FragmentOthersBinding by viewBinding(FragmentOthersBinding::bind)

    override fun setupViews() {
        with(binding){
            banner.setBackgroundResource(content.itemRes)
            menuTitle.text = content.title
            textDesc.text = HtmlCompat.fromHtml(content.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun viewModelObservers() {

    }
}