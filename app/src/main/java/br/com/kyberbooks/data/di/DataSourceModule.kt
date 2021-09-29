package br.com.kyberbooks.data.di

import br.com.kyberbooks.data.BookDataSource
import br.com.kyberbooks.data.FirebaseBookDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindBookDataSource(firebaseBookDataSource: FirebaseBookDataSource): BookDataSource

}