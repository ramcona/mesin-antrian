package arira.co.id.mesinatrian.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.helper.BaseFragment
import kotlinx.android.synthetic.main.fragment_on_boarding.view.*

class OnBoardingFragment : BaseFragment() {

    interface OnBoardingListener {
        fun onNextClick()
        fun onFinishClick()
    }

    private lateinit var onBoardingListener : OnBoardingListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_on_boarding, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root.fonboard_dot_indikator.setViewPager(viewPager)
        when(arguments!!.getString(type2)){
            "1"->{
                root.fonboard_tv_judul.text = "Board Satu"
                root.fonboard_tv_deskripsi.text  = "Deskripsi Satu"
                root.fonboard_div_root.setBackgroundColor(resources.getColor(R.color.colorPrimary))

                root.fonboard_tv_lanjut.text = getString(R.string.lanjut)
                root.fonboard_tv_lewati.text = getString(R.string.lewati)
            }
            "2"->{
                root.fonboard_tv_judul.text = "Board Dua"
                root.fonboard_tv_deskripsi.text  = "Deskripsi Dua"
                root.fonboard_div_root.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))

                root.fonboard_tv_lanjut.text = getString(R.string.lanjut)
                root.fonboard_tv_lewati.text = getString(R.string.lewati)
            }

            "3"->{
                root.fonboard_tv_judul.text = "Board Tiga"
                root.fonboard_tv_deskripsi.text  = "Deskripsi Tiga"
                root.fonboard_div_root.setBackgroundColor(resources.getColor(R.color.colorAccent))


                root.fonboard_tv_lewati.text = ""
                root.fonboard_tv_lanjut.text = getString(R.string.selesai)
            }
        }

        root.fonboard_tv_lanjut.setOnClickListener {
            onBoardingListener.onNextClick()
        }

        root.fonboard_tv_lewati.setOnClickListener {
            onBoardingListener.onFinishClick()
        }
    }

    companion object {
        var type2 = "type"
        lateinit var viewPager:ViewPager
        fun newInstance(name : String, listener : OnBoardingListener, vp:ViewPager) : Fragment {
            val fragment = OnBoardingFragment()
            val bundle = Bundle()
            bundle.putString(type2, name)
            fragment.arguments = bundle
            fragment.onBoardingListener = listener
            viewPager  = vp
            return fragment
        }
    }
}