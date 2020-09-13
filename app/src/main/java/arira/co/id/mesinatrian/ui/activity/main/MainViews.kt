package arira.co.id.mesinatrian.ui.activity.main

interface MainViews {
    fun onLoading()
    fun onSuccess()
    fun onFailed(msg:String, code:Int)
}