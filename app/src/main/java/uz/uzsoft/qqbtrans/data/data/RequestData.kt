package uz.uzsoft.qqbtrans.data.data

data class RequestData<T>(
    val method:String,
    val data:T?=null
)