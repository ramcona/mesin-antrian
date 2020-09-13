package arira.co.id.mesinatrian.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.app.App.Companion.pref
import arira.co.id.mesinatrian.helper.BaseActivity
import arira.co.id.mesinatrian.ui.activity.dataBaru.DataActivity
import arira.co.id.mesinatrian.ui.activity.main.MainActivity
import arira.co.id.mesinatrian.ui.activity.onboarding.OnBoardingActivity

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        statusPutih()

        Handler(Looper.getMainLooper()).postDelayed({
            if (pref.getData().loket.isEmpty()){
                startActivity(Intent(applicationContext, DataActivity::class.java))

            }else{
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }

            finish()
        }, 3000)

    }
}