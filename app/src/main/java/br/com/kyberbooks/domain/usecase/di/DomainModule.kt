package br.com.kyberbooks.domain.usecase.di

import br.com.kyberbooks.domain.usecase.books.CreateBookUseCase
import br.com.kyberbooks.domain.usecase.books.CreateBookUseCaseImpl
import br.com.kyberbooks.domain.usecase.books.GetBookUseCase
import br.com.kyberbooks.domain.usecase.books.GetBookUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateBook(useCase: CreateBookUseCaseImpl): CreateBookUseCase

    @Binds
    fun bindGetBook(useCase: GetBookUseCaseImpl): GetBookUseCase
}