package uz.uzsoft.qqbtrans.ui.viewPager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.uzsoft.qqbtrans.utils.extentions.putArgument


class Adapter(
    private val color: List<Int>,
    private val image: List<Int>,
    private val info: List<String>,
    activity:FragmentActivity
):FragmentStateAdapter(activity){
    private var listenerNext:((Int)->Unit)?=null
    private var listenerBack:((Int)->Unit)?=null
    override fun getItemCount()=image.size
    override fun createFragment(position: Int): Fragment= ExampleFragment().apply {
        listenerBack?.let { this.setBack(it)}
        listenerNext?.let { this.setNext(it) }
    }.putArgument {
        putInt("IMAGE",image[position])
        putInt("COLOR",color[position])
        putString("INFO",info[position])
    }
    fun setNext(block:(Int)->Unit){
        listenerNext=block
    }
    fun setBack(block:(Int)->Unit){
        listenerBack=block
    }
}