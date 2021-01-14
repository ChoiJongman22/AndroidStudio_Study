package com.jongman22.simpletodolistwithroom

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TodoViewModel(application: Application): ViewModel() {

    private val disposable:CompositeDisposable= CompositeDisposable()

    private val repository:TodoRepository by lazy{//값을 변경할 수 없는 val 같은 것이 lazy사용
        TodoRepository(application)
    }
    private val todos: LiveData<List<Todo>> by lazy{
        repository.getAllTodos()
    }
    fun getAllTodos()=todos

    fun getTodoById(id:Long):LiveData<Todo>{
        return repository.getTodoById(id)
    }

    fun insert(todo:Todo,next:()->Unit){
        disposable.add(repository.insert(todo).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{next()}
        )
    }
    fun delete(id:Long,next:()->Unit){
        disposable.add(repository.delete(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{next()}
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}