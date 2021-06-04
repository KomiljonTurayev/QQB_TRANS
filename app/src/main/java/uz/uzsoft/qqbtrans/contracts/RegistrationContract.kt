package uz.uzsoft.qqbtrans.contracts

import uz.uzsoft.qqbtrans.utils.SingleBlock

interface RegistrationContract {
    interface Model{
        fun message(block: SingleBlock<String>)
        fun success(block: SingleBlock<String>)
        fun register(data: ContactUserData)
    }
    interface View{
        fun getPhoneNumber(): String
        fun openLoading()
        fun closeLoading()
        fun openLogin(token_uuid:String)
        fun showMessage(message: String,error:String)
    }
    interface Presenter{
        fun reg()
    }
}