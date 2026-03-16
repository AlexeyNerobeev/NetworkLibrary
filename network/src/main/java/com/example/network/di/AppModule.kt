package com.example.network.di

import android.content.Context
import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.CartRepositoryImpl
import com.example.network.data.repositoryImpl.NewsRepositoryImpl
import com.example.network.data.repositoryImpl.OrderRepositoryImpl
import com.example.network.data.repositoryImpl.ProductsRepositoryImpl
import com.example.network.data.repositoryImpl.ProjectRepositoryImpl
import com.example.network.data.repositoryImpl.SharedPrefsRepositoryImpl
import com.example.network.data.repositoryImpl.UserRepositoryImpl
import com.example.network.data.utils.HttpConstants.BASE_URL
import com.example.network.domain.repository.AuthRepository
import com.example.network.domain.repository.CartRepository
import com.example.network.domain.repository.NewsRepository
import com.example.network.domain.repository.OrderRepository
import com.example.network.domain.repository.ProductRepository
import com.example.network.domain.repository.ProjectRepository
import com.example.network.domain.repository.SharedPrefsRepository
import com.example.network.domain.repository.UserRepository
import com.example.network.domain.usecase.CreateCartUseCase
import com.example.network.domain.usecase.CreateProjectUseCase
import com.example.network.domain.usecase.DeleteTokenUseCase
import com.example.network.domain.usecase.DeleteUserUseCase
import com.example.network.domain.usecase.EditUserUseCase
import com.example.network.domain.usecase.GetNewsUseCase
import com.example.network.domain.usecase.GetProductByIdUseCase
import com.example.network.domain.usecase.GetProductsUseCase
import com.example.network.domain.usecase.GetProjectsUseCase
import com.example.network.domain.usecase.GetUserUseCase
import com.example.network.domain.usecase.LoadBucketIdUseCase
import com.example.network.domain.usecase.LoadEmailUseCase
import com.example.network.domain.usecase.LoadTokenUseCase
import com.example.network.domain.usecase.LoadUserIdUseCase
import com.example.network.domain.usecase.LoginUseCase
import com.example.network.domain.usecase.RegisterUseCase
import com.example.network.domain.usecase.SaveBucketIdUseCase
import com.example.network.domain.usecase.SaveEmailUseCase
import com.example.network.domain.usecase.SaveTokenUseCase
import com.example.network.domain.usecase.SaveUserIdUseCase
import com.example.network.domain.usecase.UpdateCartUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideHttpClient(sharedPrefsRepository: SharedPrefsRepository): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    this.explicitNulls
                    this.encodeDefaults
                })
            }
            defaultRequest {
                header(key = "Authorization",
                    value = "Bearer ${sharedPrefsRepository.loadToken()}")
                url(BASE_URL)
            }
        }
    }

    @Provides
    fun provideAuthRepository(client: HttpClient): AuthRepository {
        return AuthRepositoryImpl(client)
    }

    @Provides
    fun provideSharedPrefsRepository(@ApplicationContext context: Context): SharedPrefsRepository {
        return SharedPrefsRepositoryImpl(context)
    }

    @Provides
    fun provideUserRepository(httpClient: HttpClient): UserRepository {
        return UserRepositoryImpl(httpClient)
    }

    @Provides
    fun provideNewsRepository(httpClient: HttpClient): NewsRepository {
        return NewsRepositoryImpl(httpClient)
    }

    @Provides
    fun provideProductsRepository(httpClient: HttpClient): ProductRepository {
        return ProductsRepositoryImpl(httpClient)
    }

    @Provides
    fun provideCartRepository(httpClient: HttpClient): CartRepository {
        return CartRepositoryImpl(httpClient)
    }

    @Provides
    fun provideOrderRepository(httpClient: HttpClient): OrderRepository {
        return OrderRepositoryImpl(httpClient)
    }

    @Provides
    fun provideProjectRepository(httpClient: HttpClient): ProjectRepository{
        return ProjectRepositoryImpl(httpClient)
    }

    @Provides
    fun provideCreateCartUseCase(cartRepository: CartRepository): CreateCartUseCase{
        return CreateCartUseCase(cartRepository)
    }

    @Provides
    fun provideCreateOrderUseCase(cartRepository: CartRepository): CreateCartUseCase{
        return CreateCartUseCase(cartRepository)
    }

    @Provides
    fun provideDeleteTokenUseCase(sharedPrefsRepository: SharedPrefsRepository): DeleteTokenUseCase{
        return DeleteTokenUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideDeleteUserUseCase(authRepository: AuthRepository): DeleteUserUseCase{
        return DeleteUserUseCase(authRepository)
    }

    @Provides
    fun provideEditUserUseCase(userRepository: UserRepository): EditUserUseCase{
        return EditUserUseCase(userRepository)
    }

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase{
        return GetNewsUseCase(newsRepository)
    }

    @Provides
    fun provideGetProductByIdUseCase(productRepository: ProductRepository): GetProductByIdUseCase{
        return GetProductByIdUseCase(productRepository)
    }

    @Provides
    fun provideGetProductsUseCase(productRepository: ProductRepository): GetProductsUseCase{
        return GetProductsUseCase(productRepository)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase{
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun provideLoadBucketIdUseCase(sharedPrefsRepository: SharedPrefsRepository): LoadBucketIdUseCase{
        return LoadBucketIdUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideLoadTokenUseCase(sharedPrefsRepository: SharedPrefsRepository): LoadTokenUseCase{
        return LoadTokenUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase{
        return LoginUseCase(authRepository)
    }

    @Provides
    fun provideRegisterUseCase(authRepository: AuthRepository): RegisterUseCase{
        return RegisterUseCase(authRepository)
    }

    @Provides
    fun provideSaveBucketIdUseCase(sharedPrefsRepository: SharedPrefsRepository): SaveBucketIdUseCase{
        return SaveBucketIdUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideSaveTokenUseCase(sharedPrefsRepository: SharedPrefsRepository): SaveTokenUseCase{
        return SaveTokenUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideUpdateCartUseCase(cartRepository: CartRepository): UpdateCartUseCase{
        return UpdateCartUseCase(cartRepository)
    }

    @Provides
    fun provideGetProjectsUseCase(projectRepository: ProjectRepository): GetProjectsUseCase{
        return GetProjectsUseCase(projectRepository)
    }

    @Provides
    fun provideCreateProjectUseCase(projectRepository: ProjectRepository): CreateProjectUseCase{
        return CreateProjectUseCase(projectRepository)
    }

    @Provides
    fun provideSaveEmailUseCase(sharedPrefsRepository: SharedPrefsRepository): SaveEmailUseCase{
        return SaveEmailUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideLoadEmailUseCase(sharedPrefsRepository: SharedPrefsRepository): LoadEmailUseCase{
        return LoadEmailUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideSaveUserIdUseCase(sharedPrefsRepository: SharedPrefsRepository): SaveUserIdUseCase{
        return SaveUserIdUseCase(sharedPrefsRepository)
    }

    @Provides
    fun provideLoadUserIdUseCase(sharedPrefsRepository: SharedPrefsRepository): LoadUserIdUseCase{
        return LoadUserIdUseCase(sharedPrefsRepository)
    }
}