package com.umutsaydam.quicknewsapp.di

import android.app.Application
import androidx.room.Room
import com.umutsaydam.quicknewsapp.data.local.NewsDao
import com.umutsaydam.quicknewsapp.data.local.NewsDatabase
import com.umutsaydam.quicknewsapp.data.local.NewsTypeConverter
import com.umutsaydam.quicknewsapp.data.manger.LocalUserMangerImpl
import com.umutsaydam.quicknewsapp.data.remote.NewsApi
import com.umutsaydam.quicknewsapp.data.repository.NewsRepositoryImpl
import com.umutsaydam.quicknewsapp.domain.manager.LocalUserManager
import com.umutsaydam.quicknewsapp.domain.repository.NewsRepository
import com.umutsaydam.quicknewsapp.domain.usecases.app_entry.AppEntryUseCases
import com.umutsaydam.quicknewsapp.domain.usecases.app_entry.ReadAppEntry
import com.umutsaydam.quicknewsapp.domain.usecases.app_entry.SaveAppEntry
import com.umutsaydam.quicknewsapp.domain.usecases.news.DeleteArticle
import com.umutsaydam.quicknewsapp.domain.usecases.news.GetNews
import com.umutsaydam.quicknewsapp.domain.usecases.news.NewsUseCases
import com.umutsaydam.quicknewsapp.domain.usecases.news.SearchNews
import com.umutsaydam.quicknewsapp.domain.usecases.news.SelectArticle
import com.umutsaydam.quicknewsapp.domain.usecases.news.SelectArticles
import com.umutsaydam.quicknewsapp.domain.usecases.news.UpsertArticle
import com.umutsaydam.quicknewsapp.util.Constants.BASE_URL
import com.umutsaydam.quicknewsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application,
    ): LocalUserManager = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager,
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao,
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application,
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase,
    ): NewsDao = newsDatabase.newsDao
}