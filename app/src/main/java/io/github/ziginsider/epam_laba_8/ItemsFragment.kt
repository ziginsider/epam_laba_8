package io.github.ziginsider.epam_laba_8

class ItemsFragment : BaseFragment() {
    override val logTag = ItemsFragment::class.java.simpleName
    override fun getLayout(): Int {
        return R.layout.fragment_items
    }
}