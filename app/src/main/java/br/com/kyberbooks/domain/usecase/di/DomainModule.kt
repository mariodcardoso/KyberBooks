package br.com.kyberbooks.domain.usecase.di

import br.com.kyberbooks.domain.usecase.books.*
import br.com.kyberbooks.ui.registerbook.viewmodel.RegisterBookViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateBookUseCase(useCase: CreateBookUseCaseImpl): CreateBookUseCase

    @Binds
    fun bindGetBookUseCase(useCase: GetBookUseCaseImpl): GetBookUseCase

    @Binds
    fun bindUploadBookCoverUseCase(useCase: UploadBookCoverUseCaseImpl): UploadBookCoverUseCase

    @Binds
    fun bindGetReadProgressUseCase(useCase: GetReadProgressUseCaseImpl): GetReadProgressUseCase
}