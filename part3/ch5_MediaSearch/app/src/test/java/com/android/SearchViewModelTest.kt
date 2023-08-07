package com.android

import android.widget.SearchView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.model.ListItem
import com.android.repository.SearchRepository
import io.reactivex.rxjava3.core.Observer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchRepository : SearchRepository

    @Mock
    lateinit var mockLoadingObserve : Observer<Boolean>

    @Mock
    lateinit var mockListObserver: Observer<List<ListItem>>

    private lateinit var viewModel : SearchViewModel

    /*@Before
    fun setUp() {
        viewModel = SearchViewModel(searchRepository)
        viewModel.showLoading.observeForever(mockLoadingObserve)
        viewModel.listLiveData.observeForever(mockListObserver)
    }

    @Test
    fun search() {
        Mockito.
    }*/
}