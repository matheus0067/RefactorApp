package com.matheus.picpay.di

import android.content.Context
import androidx.room.Room
import com.matheus.picpay.data.local.AppDatabase
import com.matheus.picpay.data.local.UserDao
import com.matheus.picpay.data.remote.PicPayService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providePicPayService(): PicPayService {
        return Retrofit.Builder()
            .baseUrl("https://api.picpay.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PicPayService::class.java)
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "picpay-db")
            .fallbackToDestructiveMigration()
            .build()
    }
}