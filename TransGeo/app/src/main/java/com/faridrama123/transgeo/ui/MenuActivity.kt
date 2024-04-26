package com.faridrama123.transgeo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.faridrama123.transgeo.R
import com.faridrama123.transgeo.ui.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    companion object{
        const val TITLE = " title"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val titlr = intent.getStringExtra(TITLE)
        viewpager_main.adapter = MyPagerAdapter(supportFragmentManager, titlr!!)

        btn_tittle.text = titlr
        back.setOnClickListener { finish() }
        next.setOnClickListener {
            viewpager_main.setCurrentItem(getItem(+ 1), true)
        }
        prev.setOnClickListener {
            viewpager_main.setCurrentItem(getItem(-1), true)
        }
        viewpager_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                btn_tittle.text = (viewpager_main.adapter as MyPagerAdapter).getPageTitle(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }

    private fun getItem(i: Int): Int {
        return viewpager_main.getCurrentItem() + i
    }
}