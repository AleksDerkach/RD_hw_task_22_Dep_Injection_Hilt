package com.example.task_21_hometask_depinj_hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val repo :Repository) :ViewModel() {
    // private тому, що MutableLiveData можна змінити (postValue, setValue)
    // закриваєм від актівіті - щоб актівіті не посилала дані які потім сама отримувала
    private val _uiState = MutableLiveData<UiState>(UiState.Empty)
    // в LiveData немає (postValue, setValue)
    // так робимо щоб MutableLiveData можна було змінювати з середини ViewModel
    val uiState: LiveData<UiState> = _uiState

    fun getData(){
        //_uiState.value = UiState.Processing
        viewModelScope.launch {
            try {
                val heroResponse = repo.getSuperHero()
                if (heroResponse.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val data = heroResponse.body()
                        _uiState.postValue(UiState.Result(data))
                        //_uiState.value = UiState.Result(heroResponse.toList())
                        //_uiState.value = UiState.Result(listHero = heroResponse)
                    }
                } else {
                    _uiState.postValue(UiState.Error("Error code ${heroResponse.code()}"))
                }
            } catch (e:Exception) {
                _uiState.postValue(UiState.Error(e.localizedMessage))
            }
        }
    }

     // клас який буде тримати стани UI
    sealed class UiState {
        // object тому, що клас не передає даних
        // будуть перевикористовуватись
        object Empty:UiState()
        //object Processing:UiState()
        // при зміні даних Result буде створюватись
        class Result(var listHero: List<SuperHero>?):UiState()
        // для роботи з веб
        class Error (val descr:String):UiState()
    }
}
