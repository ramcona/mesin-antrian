package arira.co.id.mesinatrian.ui.activity.main

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import arira.co.id.mesinatrian.R
import arira.co.id.mesinatrian.app.App.Companion.db
import arira.co.id.mesinatrian.app.App.Companion.myDialog
import arira.co.id.mesinatrian.app.App.Companion.pref
import arira.co.id.mesinatrian.helper.BaseActivity
import arira.co.id.mesinatrian.helper.Helper
import arira.co.id.mesinatrian.helper.Helper.log
import arira.co.id.mesinatrian.helper.MyDialog
import arira.co.id.mesinatrian.model.RiwayatModel
import arira.co.id.mesinatrian.model.TempatModel
import arira.co.id.mesinatrian.ui.activity.pengaturan.PengaturanActivity
import arira.co.id.mesinatrian.ui.activity.riwayat.RiwayatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    var mTempat:TempatModel = TempatModel()
    var terakhir:Int = 0
    var mediaPlayer:MediaPlayer? = null
    lateinit var mTTS: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusPutih()
        MobileAds.initialize(this) {}
        mTempat = pref.getData()
        val adRequest = AdRequest.Builder().build()
        mainAds.loadAd(adRequest)


        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                mTTS.language = Locale("id-ID")
            }
        })


        mediaPlayer = MediaPlayer.create(this, R.raw.call_in_bell)

        main_img_seting.setOnClickListener {
            startActivity(Intent(this@MainActivity, PengaturanActivity::class.java))
        }
        main_img_riwayat.setOnClickListener {
            startActivity(Intent(this@MainActivity, RiwayatActivity::class.java))
        }

        main_img_lanjut.setOnClickListener {
            val end = terakhir  + 1
            mTempat.antrian = end.toString()
            mTempat.tanggal  = Helper.getCurrentTime()
            pref.setData(mTempat)
            updateDatabase()
            updateNomorAntri()

            panggilan()
        }

        main_img_panggil.setOnClickListener {
            panggilan()
        }

        main_img_kembali.setOnClickListener {
            if (terakhir > 1){
                val end = terakhir  - 1
                mTempat.antrian = end.toString()

                pref.setData(mTempat)
                updateDatabase()
                updateNomorAntri()

                panggilan()
            }else{
                toast.show(getString(R.string.minimal_1),this@MainActivity )
            }
        }

        if(!mTempat.tanggal.isEmpty()){
            if (Helper.compareDatetoDays(mTempat.tanggal).toInt() > 0){
                myDialog = MyDialog(this)
                myDialog.setup()

                myDialog.bisabatal(false)
                myDialog.pesan.text = getString(R.string.ganti_hari,mTempat.antrian)
                myDialog.cancel.text = getString(R.string.tetap)
                myDialog.oke.text = getString(R.string.reset)

                myDialog.oke.setOnClickListener {
                    mTempat.antrian = "1"
                    mTempat.tanggal = Helper.getCurrentTime()

                    pref.setData(mTempat)

                    setData()
                    myDialog.tutup()
                }

                myDialog.cancel.setOnClickListener {
                    mTempat.tanggal = Helper.getCurrentTime()
                    pref.setData(mTempat)

                    myDialog.tutup()
                }

                myDialog.tampil()
            }
        }

    }

    fun panggilan(){
        if (mTempat.audio){
            audioPlay()
            mediaPlayer?.setOnCompletionListener {
                val teks = "Nomor Antrian. ${mTempat.kodeAntrian}, ${mTempat.antrian}. segera menuju loket ${mTempat.loket}"
                mTTS.speak(teks, TextToSpeech.QUEUE_ADD, null, teks)
            }
        }




    }

    fun audioPlay(){
        if (mediaPlayer != null){
            if (mediaPlayer!!.isPlaying){
                mediaPlayer!!.stop()
            }

            mediaPlayer!!.start()
        }
    }

    fun updateDatabase(){
//        mTempat = pref.getData()
        val riwayat = RiwayatModel()
        riwayat.admin = mTempat.admin
        riwayat.loket = mTempat.loket
        riwayat.nomorantri = mTempat.kodeAntrian + " " + mTempat.antrian
        riwayat.waktu = Helper.getCurrentTime()
        riwayat.tempat = mTempat.tempat
        db?.riwayatDao()?.insert(riwayat)
    }

    @SuppressLint("SetTextI18n")
    fun setData(){
        mTempat = pref.getData()

        if (mTempat.layarOn){
            main_div.keepScreenOn = true
        }else{
            main_div.keepScreenOn = false
        }

        main_tv_lokasi.text = """${mTempat.admin} - ${mTempat.tempat}"""
        main_tv_loket.text = getString(R.string.loket_, mTempat.loket)
        updateNomorAntri()
    }

    @SuppressLint("SetTextI18n")
    private  fun updateNomorAntri(){
        mTempat = pref.getData()
        terakhir = mTempat.antrian.toInt()

        if (mTempat.kodeAntrian.isEmpty()){
            main_tv_antrian.text = mTempat.antrian
        }else{
            main_tv_antrian.text = """${mTempat.kodeAntrian} - ${mTempat.antrian}"""
        }
    }

    override fun onResume() {
        super.onResume()

        setData()
    }
}