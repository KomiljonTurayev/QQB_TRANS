package uz.uzsoft.qqbtrans.data.data

data class ResponseData<T>(
    val success:Boolean,
    val data:T?=null,
    val message:String,
    val code:Int
)