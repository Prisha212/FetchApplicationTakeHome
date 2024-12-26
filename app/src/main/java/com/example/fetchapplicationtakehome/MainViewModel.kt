package com.example.fetchapplicationtakehome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}


class MainViewModel : ViewModel() {
    private val api = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FetchApi::class.java)


    private val _items = MutableStateFlow<Map<Int, List<Item>>>(emptyMap())
    val items: StateFlow<Map<Int, List<Item>>> = _items


    init {
        loadItems()
    }


    private fun loadItems() {
        viewModelScope.launch {
            try {
                val itemList = api.getItems()
                    .filter { !it.name.isNullOrBlank() }
                    .sortedWith(
                        compareBy<Item> { it.listId }
                            .thenBy { it.name ?: "" }
                    )
                _items.value = itemList.groupBy { it.listId }
            } catch (e: Exception) {
                _items.value = emptyMap()
            }
        }
    }
}
