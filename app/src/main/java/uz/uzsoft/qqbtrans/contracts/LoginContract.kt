package uz.uzsoft.qqbtrans.contracts

import uz.uzsoft.qqbtrans.utils.SingleBlock

interface LoginContract {
    interface Model{
        fun message(block: SingleBlock<String>)
        fun success(block: SingleBlock<String>)
//        fun login(data: LoginData)
        fun setToken(token:String)
    }
    interface View{
        fun getOtp(): String
        fun openMain()
        fun openLoader()
        fun closeLoader()
        fun showMessage(message: String,error:String)
        fun openRegistration()
    }
    interface ViewModel{
        fun logIn()
        fun register()
    }
}