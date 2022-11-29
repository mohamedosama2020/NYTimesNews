package com.mohamed.nytimesnews.ui.news_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.nytimesnews.entities.news.remote.toUIModel
import com.mohamed.nytimesnews.entities.news.ui.News
import com.mohamed.nytimesnews.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val getNewsUseCase: GetNewsUseCase):ViewModel() {

    private val _showLoading = MutableLiveData(true)
    val showLoading:LiveData<Boolean> = _showLoading

    private val _news:MutableLiveData<List<News>> = MutableLiveData(listOf())
    val news:LiveData<List<News>> = _news

    init {
        getNews()
    }

    private fun getNews(){
        _showLoading.value = true
        viewModelScope.launch {
            try{
                val response = getNewsUseCase()
                if(response.isSuccessful){
                    _showLoading.value = false
                    _news.value = response.body()?.toUIModel()
                }else{
                    _showLoading.value = false
                    _news.value = null
                }
            }catch (e:Exception){
                _showLoading.value = false
                _news.value = null
                println(e.localizedMessage)
            }
        }
    }
}