package com.psdemo.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.psdemo.todo.add.AddViewModel
import com.psdemo.todo.data.TodoRepository
import com.psdemo.todo.list.ListViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) = with(modelClass) {
            when {
                isAssignableFrom(ListViewModel::class.java) ->
                    ListViewModel(todoRepository)
                isAssignableFrom(AddViewModel::class.java) ->
                    AddViewModel(todoRepository)
                else ->
                    throw IllegalArgumentException("ViewModel class (${modelClass.name}) is not mapped")
            }
    } as T
}