package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.network.ChuckNorrisService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Denis Gasparoto on 25/03/2020.
 */
private const val NETWORK_TIMEOUT = 30L

internal val networkModule = module {
    single {
        buildRetrofitClient(androidContext().getString(R.string.base_url)).run {
            create(ChuckNorrisService::class.java)
        }
    }
}


private fun buildRetrofitClient(url: String) = Retrofit.Builder()
    .baseUrl(url)
    .client(buildHttpClient())
    .addConverterFactory(MoshiConverterFactory.create(buildMoshi()))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
    .build()

private fun buildHttpClient() = OkHttpClient.Builder()
    .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
    .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
    .addInterceptor(buildInterceptor())
    .build()

private fun buildInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun buildMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
