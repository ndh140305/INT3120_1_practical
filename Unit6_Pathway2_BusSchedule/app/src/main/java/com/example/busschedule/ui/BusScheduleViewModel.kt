/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.data.Item
import com.example.busschedule.data.ItemDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.busschedule.BusScheduleApplication

class BusScheduleViewModel(private val repository: ItemRepository): ViewModel() {

    fun getFullSchedule(): Flow<List<Item>> = repository.getAllItems()

    fun getScheduleFor(stopName: String): Flow<List<Item>> =
        repository.getItemsByStop(stopName)

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BusScheduleApplication)
                val repository = ItemRepository(application.database.itemDao())
                BusScheduleViewModel(repository)
            }
        }
    }

    class ItemRepository(private val dao: ItemDao) {
        fun getAllItems(): Flow<List<Item>> = dao.getAll()
        fun getItemsByStop(stopName: String): Flow<List<Item>> =
            dao.getByStopName(stopName).map { list -> list.filter { it.stopName == stopName } }
    }
}

