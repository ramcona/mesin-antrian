package arira.co.id.mesinatrian.helper

class JSONParseData {

    private var gender_mitra: String = ""
    private var note: String = ""
    private var long_customer: String = ""
    private var distance: String = ""
    private var mitra_id: String = ""
    private var discount: String = ""
    private var created_at: String = ""
    private var promo_id: String = ""
    private var duration: String = ""
    private var schedule: String = ""
    private var subcategory_id: String = ""
    private var gender_customer: String = ""
    private var updated_at: String = ""
    private var est_schedule: String = ""
    private var price: String = ""
    private var lat_mitra: String = ""
    private var datetime_order: String = ""
    private var lat_customer: String = ""
    private var id: Int = 0
    private var long_mitra: String = ""
    private var status: String = ""

    private lateinit var pref: SharedPref

//    fun parsedata(payload: String, context: Context) {
//        pref = SharedPref(context)
//        try {
//            //==== PARSE DATA ========
//            val data = payload
//            val models = Gson().fromJson(data, ModelRiwayat::class.java)
//            pref.setOrder(models)
//
////            Log.e("MGS", "insert data")
//        } catch (e: JSONException) {
//            log("JSONPARSE", e.message.toString())
//        }
//    }
//
//    fun parsechat(paylaod: String): ModelChat {
//        val models: ModelChat = Gson().fromJson(paylaod, ModelChat::class.java)
//        return models
//    }

}