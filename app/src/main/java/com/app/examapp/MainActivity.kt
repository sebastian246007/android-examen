package com.app.examapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.examapp.ui.cart.CartView
import com.app.examapp.ui.cart.viewModel.CartViewModel
import com.app.examapp.ui.cart.viewModel.CartViewModelFactory
import com.app.examapp.ui.home.viewModel.CategoryViewModelFactory
import com.app.examapp.ui.home.HomeView
import com.app.examapp.ui.home.viewModel.CategoryVewModel
import com.app.examapp.ui.login.LoginView
import com.app.examapp.ui.login.viewModel.LoginViewModel
import com.app.examapp.ui.login.viewModel.LoginViewModelFactory
import com.app.examapp.ui.product.ProductView
import com.app.examapp.ui.product.productDetail.ProductDetailView
import com.app.examapp.ui.product.productDetail.viewModel.ProductDetailViewModel
import com.app.examapp.ui.product.productDetail.viewModel.ProductDetailViewModelFactory
import com.app.examapp.ui.product.viewModel.ProductViewModel
import com.app.examapp.ui.product.viewModel.ProductViewModelFactory
import com.app.examapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    private val loginVm by viewModels<LoginViewModel>() {
        LoginViewModelFactory(application = application)
    }

    private val categoryVm by viewModels<CategoryVewModel>() {
        CategoryViewModelFactory(application = application)
    }

    private val productVm by viewModels<ProductViewModel>() {
        ProductViewModelFactory()
    }
    private val productDetailVm by viewModels<ProductDetailViewModel>() {
        ProductDetailViewModelFactory()
    }

    private val cartVm by viewModels<CartViewModel>() {
        CartViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppNavHost(
                loginVm, categoryVm, productVm,
                productDetailVm, cartVm
            )

        }
    }
}

@Composable
fun AppNavHost(
    login: LoginViewModel, category: CategoryVewModel,
    product: ProductViewModel, productDetail: ProductDetailViewModel,
    cart: CartViewModel
) {
    val nav = rememberNavController()

    val context = LocalContext.current
    AppTheme {
        NavHost(navController = nav, startDestination = "login") {

            composable("login") {
                LoginView(onSuccess = { nav.navigate("home") }, login)
            }
            composable("home") {
                HomeView(onClick = { nav.navigate("products") }, category)
            }
            composable("products") {
                ProductView(
                    onClick = { id ->
                        nav.navigate("product_detail/$id")
                    },
                    onCartClick={
                      nav.navigate("cart")
                    },
                    vm = product,
                    vmCart = cart
                )
            }
            composable("product_detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0

                ProductDetailView(
                    onAddCart = { nav.popBackStack() },
                    vm = productDetail,
                    vmCart = cart,
                    id = id
                )
            }

            composable("cart") {
                CartView(cart,{ nav.popBackStack() })
            }

        }
    }


}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ExamAppTheme {
//        Greeting("Android")
//    }
//}