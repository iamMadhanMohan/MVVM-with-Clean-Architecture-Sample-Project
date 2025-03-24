package com.gangadhari.rsandroidtakehomechallenge.di

import android.content.Context
import androidx.room.Room
import com.gangadhari.rsandroidtakehomechallenge.data.local.AppDatabase
import com.gangadhari.rsandroidtakehomechallenge.data.local.DriverDao
import com.gangadhari.rsandroidtakehomechallenge.data.local.RouteDao
import com.gangadhari.rsandroidtakehomechallenge.data.remote.ApiService
import com.gangadhari.rsandroidtakehomechallenge.data.repositories.DataRepositoryImpl
import com.gangadhari.rsandroidtakehomechallenge.domain.repositories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()

    @Provides
    fun provideDriverDao(database: AppDatabase): DriverDao = database.driverDao()

    @Provides
    fun provideRouteDao(database: AppDatabase): RouteDao = database.routeDao()

    @Provides
    @Singleton
    fun provideDataRepository(impl: DataRepositoryImpl): DataRepository = impl
}
