package com.ixuea.courses.mymusic.component.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ixuea.courses.mymusic.component.api.DefaultNetworkService
import com.ixuea.courses.mymusic.entity.response.Meta
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

/**
 * 内容界面ViewModel
 */
class ContentViewModel: ViewModel(){

    private val _data= MutableSharedFlow<Meta<Content>>()

    val data: Flow<Meta<Content>> =_data

    fun loadMore(lastId: String?=null) {
        viewModelScope.launch {

            val r=DefaultNetworkService.create().contents(lastId)
            _data.emit(r.data!!)

        }
    }

}