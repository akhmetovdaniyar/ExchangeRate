package ru.akhmetovdaniyar.exchangerate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.net.URL

class ViewModelActivity: ViewModel() {

    init {
        GlobalScope.launch {
            getInfo()
        }
    }

    private val url = URL("https://alicoup.ru/currency/")
    var priceList: MutableList<String> = mutableListOf()
    val priceLivedata = MutableLiveData<MutableList<String>>()

    fun getInfo() {
        try {
            val doc = Jsoup.connect("$url").get()
            val element = doc.select("div[class=card-body]")

            for (i in 0 until 3) {
                val price = element.select("div[class=col-sm text-sm-right]")
                    .eq(i)
                    .text()
                priceList.add(price)
            }
            priceLivedata.postValue(priceList)
        }
        catch (_: Exception) {
        }
    }
}