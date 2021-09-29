package br.com.kyberbooks.domain.model.di

import br.com.kyberbooks.domain.model.Book
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RegisterBooksModule {

    @Provides
    fun bindBookModel() = Book()

}