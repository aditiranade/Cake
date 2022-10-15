package com.example.cake.ui.theme

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cake.R


enum class CakeScreen(@StringRes val title: Int) {
    Start(title = R.string.start),
    Recipe(title = R.string.recipe),
    Recipe1(title = R.string.recipe_1),
    Recipe2(title = R.string.recipe_2),
    Recipe3(title = R.string.recipe_3),
    Calories(title = R.string.calorie_count)
}

@Composable
fun CakeAppBar(
    currentScreen: CakeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun CakeApp(
    modifier: Modifier = Modifier,
    viewModel: CakeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = CakeScreen.valueOf(
        backStackEntry?.destination?.route ?: CakeScreen.Start.name
    )
    Scaffold(
        topBar = {
            CakeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        val calories = viewModel.calculateCalories()

        NavHost(
            navController = navController,
            startDestination = CakeScreen.Start.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = CakeScreen.Start.name) {
                StartScreen(
                    onNextButtonClicked = {
                        navController.navigate(CakeScreen.Recipe.name)
                    },
                    modifier = Modifier
                )
            }

            composable(route = CakeScreen.Recipe.name) {
                RecipeScreen(
                    onNextButtonClicked = {
                        navController.navigate(CakeScreen.Recipe1.name)
                    }, modifier = Modifier
                )
            }

            composable(route = CakeScreen.Recipe1.name) {
                Recipe1Screen(onNextButtonClicked = {
                    navController.navigate(CakeScreen.Recipe2.name)
                }
                )
            }

            composable(route = CakeScreen.Recipe2.name) {
                Recipe2Screen(onNextButtonClicked = {
                    navController.navigate(CakeScreen.Recipe3.name)
                }
                )
            }

            composable(route = CakeScreen.Recipe3.name) {
                Recipe3Screen(onNextButtonClicked = {
                    navController.navigate(CakeScreen.Calories.name)
                }
                )
            }

            composable(route = CakeScreen.Calories.name) {
                CaloriesScreen()
            }
        }
    }
}



