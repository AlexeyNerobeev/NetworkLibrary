package com.example.network

import android.util.Log
import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.CartRepositoryImpl
import com.example.network.data.repositoryImpl.NewsRepositoryImpl
import com.example.network.data.repositoryImpl.OrderRepositoryImpl
import com.example.network.data.repositoryImpl.ProductsRepositoryImpl
import com.example.network.data.repositoryImpl.ProjectRepositoryImpl
import com.example.network.data.repositoryImpl.UserRepositoryImpl
import com.example.network.data.utils.HttpConstants.BASE_URL
import com.example.network.domain.repository.NewsRepository
import com.example.network.domain.usecase.CreateCartUseCase
import com.example.network.domain.usecase.CreateOrderUseCase
import com.example.network.domain.usecase.CreateProjectUseCase
import com.example.network.domain.usecase.DeleteUserUseCase
import com.example.network.domain.usecase.EditUserUseCase
import com.example.network.domain.usecase.GetNewsUseCase
import com.example.network.domain.usecase.GetProductByIdUseCase
import com.example.network.domain.usecase.GetProductsUseCase
import com.example.network.domain.usecase.GetProjectsUseCase
import com.example.network.domain.usecase.GetUserUseCase
import com.example.network.domain.usecase.LoginUseCase
import com.example.network.domain.usecase.RegisterUseCase
import com.example.network.domain.usecase.UpdateCartUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class NetworkTests {
    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                this.explicitNulls
                this.encodeDefaults
            })
        }
        defaultRequest {
            header(key = "Authorization",
                value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2xsZWN0aW9uSWQiOiJfcGJfdXNlcnNfYXV0aF8iLCJleHAiOjE3NzM5MDgxNDksImlkIjoiNzZ1d29mNTczbDc1OTRzIiwicmVmcmVzaGFibGUiOnRydWUsInR5cGUiOiJhdXRoIn0.gPo6PxcJdXT6nWz2k1jSupLhuHrSJaGNczkw8322APo")
            url(BASE_URL)
        }
    }
    //repository
    private val cartRepository = CartRepositoryImpl(httpClient)
    private val authRepository = AuthRepositoryImpl(httpClient)
    private val newsRepository = NewsRepositoryImpl(httpClient)
    private val orderRepository = OrderRepositoryImpl(httpClient)
    private val productRepository = ProductsRepositoryImpl(httpClient)
    private val userRepository = UserRepositoryImpl(httpClient)
    private val projectRepository = ProjectRepositoryImpl(httpClient)

    //usecase
    private val registerUseCase = RegisterUseCase(authRepository)
    private val loginUseCase = LoginUseCase(authRepository)
    private val deleteUserUseCase = DeleteUserUseCase(authRepository)
    private val createCartUseCase = CreateCartUseCase(cartRepository)
    private val updateCartUseCase = UpdateCartUseCase(cartRepository)
    private val getNewsUseCase = GetNewsUseCase(newsRepository)
    private val createOrderUseCase = CreateOrderUseCase(orderRepository)
    private val getProductsUseCase = GetProductsUseCase(productRepository)
    private val getProductsByIdUseCase = GetProductByIdUseCase(productRepository)
    private val getUserUseCase = GetUserUseCase(userRepository)
    private val editUserUseCase = EditUserUseCase(userRepository)
    private val getProjectsUseCase = GetProjectsUseCase(projectRepository)
    private val createProjectUseCase = CreateProjectUseCase(projectRepository)

    @Test
    fun registerTest() = runTest{
        val register = registerUseCase.invoke(
            email = "jkgxcbkkl@mail.ru",
            password = "Password 123$",
            passwordConfirm = "Password 123$"
        )
        Log.i("register", register.toString())
    }

    @Test
    fun loginTest() = runTest{
        val login = loginUseCase.invoke(
            identity = "qwe @mail.ru",
            password = "Password 123$"
        )
        Log.i("login", login.toString())
    }

    @Test
    fun deleteUserTest() = runTest {
        val delete = deleteUserUseCase.invoke("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2xsZWN0aW9uSWQiOiJfcGJfdXNlcnNfYXV0aF8iLCJleHAiOjE3NzM5MDgxNDksImlkIjoiNzZ1d29mNTczbDc1OTRzIiwicmVmcmVzaGFibGUiOnRydWUsInR5cGUiOiJhdXRoIn0.gPo6PxcJdXT6nWz2k1jSupLhuHrSJaGNczkw8322APo")
        Log.i("delete", delete.toString())
    }

    @Test
    fun createCartTest() = runTest {
        val cart = createCartUseCase.invoke(
            user_id = "76uwof573l7594s",
            product_id = "iay9kxkli1eq90a",
            count = 1
        )
        Log.i("cart", cart.toString())
    }

    @Test
    fun updateCartTest() = runTest {
        val updateCart = updateCartUseCase.invoke(
            user_id = "76uwof573l7594s",
            product_id = "iay9kxkli1eq90a",
            count = 3,
            bucketId = "211tmr1hv86d6k6"
        )
        Log.i("updateCart", updateCart.toString())
    }

    @Test
    fun getNewsTest() = runTest{
        val getNews = getNewsUseCase.invoke()
        Log.i("getNews", getNews.toString())
    }

    @Test
    fun createOrderTest() = runTest {
        val createOrder = createOrderUseCase.invoke(
            userId = "76uwof573l7594s",
            productId = "iay9kxkli1eq90a",
            count = 1
        )
        Log.i("createOrder", createOrder.toString())
    }

    @Test
    fun getProductsTest() = runTest {
        val getProducts = getProductsUseCase.invoke(
            filterField = "id",
            filterValue = ""
        )
        Log.i("getProducts", getProducts.toString())
    }

    @Test
    fun getProductByIdTest() = runTest{
        val getProductById = getProductsByIdUseCase.invoke(
            id = "eh4qumppov3nud1"
        )
        Log.i("getProductById", getProductById.toString())
    }

    @Test
    fun getUserTest() = runTest{
        val getUser = getUserUseCase.invoke(
            id = "76uwof573l7594s"
        )
        Log.i("getUser", getUser.toString())
    }

    @Test
    fun editUserTest() = runTest {
        val editUser = editUserUseCase.invoke(
            userId = "76uwof573l7594s",
            email = "qwe@mail.ru",
            firstName = "djfsjdg",
            secondName = "dgkljsg",
            dateBirthday = "2005-11-12",
            gender = "male"
        )
        Log.i("editUser", editUser.toString())
    }

    @Test
    fun getProjectsTest() = runTest{
        val getProjects = getProjectsUseCase.invoke()
        Log.i("getProjects", getProjects.toString())
    }

    @Test
    fun createProjectTest() = runTest {
        val createProject = createProjectUseCase.invoke(
            title = "hakdg",
            typeProject = ";skdkfjsg",
            user_id = "76uwof573l7594s",
            dateStart = "",
            dateEnd = "",
            gender = "man",
            description_source = "",
            category = "",
            image = ""
        )
        Log.i("createProject", createProject.toString())
    }
}