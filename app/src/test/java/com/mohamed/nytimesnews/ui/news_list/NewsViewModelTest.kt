package com.mohamed.nytimesnews.ui.news_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mohamed.nytimesnews.models.news.remote.NewsListResponse
import com.mohamed.nytimesnews.usecases.GetNewsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response


internal class NewsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val getNewsUseCase: GetNewsUseCase = mockk()


    @ExperimentalCoroutinesApi
    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Get Successful News List From UseCase THEN hide progress bar with News List Value`() {

        val viewModel = NewsViewModel(getNewsUseCase)
        val newsListResponse = NewsListResponse()

        runTest(testDispatcher) {
            coEvery { getNewsUseCase() } returns Response.success(200, newsListResponse)
            viewModel.getNews()
        }
        assert(viewModel.showLoading.value == false)
        assert(viewModel.news.value == newsListResponse)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Get Failed News List From UseCase THEN hide progress bar with null Value`() {

        val viewModel = NewsViewModel(getNewsUseCase)

        runTest(testDispatcher) {
            coEvery { getNewsUseCase() } returns Response.error(400,byteArrayOf().toResponseBody())
            viewModel.getNews()
        }
        assert(viewModel.showLoading.value == false)
        assert(viewModel.news.value == null)
    }
}