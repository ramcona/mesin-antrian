package arira.co.id.mesinatrian.ui.activity.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.adapter.OnBoardingViewPagerAdapter
import arira.co.id.mesinatrian.app.App.Companion.pref
import arira.co.id.mesinatrian.helper.BaseActivity
import arira.co.id.mesinatrian.ui.activity.dataBaru.DataActivity
import arira.co.id.mesinatrian.ui.activity.main.MainActivity
import arira.co.id.mesinatrian.ui.fragment.onboarding.OnBoardingFragment
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : BaseActivity(), OnBoardingFragment.OnBoardingListener {

    private var currentPage = 0
    private val fragments = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_on_boarding)
        statusPutih()

        val adapter = OnBoardingViewPagerAdapter(supportFragmentManager)
        for (i in 1 until 4) {
            fragments.add(OnBoardingFragment.newInstance(i.toString(), this, onboard_vp))
        }

        adapter.addFragments(fragments)

        onboard_vp.adapter = adapter

        onboard_vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                currentPage = position
            }
        })
    }

    override fun onNextClick() {
        if (currentPage == fragments.size - 1) {
            startActivity(Intent(this, MainActivity::class.java))
            pref.setIsFirstLaunchToFalse()
            finish()
        } else {
            onboard_vp.setCurrentItem(currentPage + 1, true)
        }
    }

    override fun onFinishClick() {
        startActivity(Intent(this, DataActivity::class.java))
        pref.setIsFirstLaunchToFalse()
        finish()
    }
}