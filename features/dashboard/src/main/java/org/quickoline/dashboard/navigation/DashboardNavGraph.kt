package org.quickoline.dashboard.navigation

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.screens.HomeScreen
import org.quickoline.dashboard.presentation.screens.PostDetailScreen
import org.quickoline.dashboard.presentation.screens.PostListScreen
import org.quickoline.dashboard.presentation.viewmodel.home.HomeViewModel
import org.quickoline.dashboard.presentation.viewmodel.post.PostViewModel
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryUiEvents
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryViewModel
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.utils.ApiResponse
import org.quickoline.utils.Constants
import org.quickoline.utils.canNavigate

@Serializable
object DashboardGraph

fun NavController.navigateToDashBoardGraph(navOptions: NavOptions? = null) {
    if (canNavigate()) navigate(route = DashboardGraph, navOptions = navOptions)
}

fun NavGraphBuilder.dashboardGraph(
    navigator: NavController,
    navigateToSource: (String) -> Unit,
    navigateToWebsite: (String) -> Unit,
    navigateToOnBoarding: () -> Unit
) {
    navigation<DashboardGraph>(startDestination = DashboardDestinations.Home) {

        composable<DashboardDestinations.Home> {

            val userEntryVm = koinViewModel<UserEntryViewModel>(
                parameters = { parametersOf(Constants.USER_ENTRY) }
            )
            val userEntryState by userEntryVm.userEntryState.collectAsState()
            val context = LocalContext.current

            LaunchedEffect(key1 = userEntryState) {

                userEntryVm.onEvent(UserEntryUiEvents.CheckIfOnBoardingIsCompleted)

                // Check the policy response state
                when (val policy = userEntryState.policyResponse) {
                    is ApiResponse.Error -> {
                        Toast.makeText(
                            context,
                            policy.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        navigateToOnBoarding()
                        return@LaunchedEffect
                    }

                    is ApiResponse.Success -> {
                        // Check the user entry response state
                        when (val entry = userEntryState.userEntryResponse) {
                            is ApiResponse.Error -> {
                                Toast.makeText(
                                    context,
                                    entry.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                                navigateToOnBoarding()
                                return@LaunchedEffect
                            }

                            is ApiResponse.Success -> {
                                if (entry.data.not() || policy.data.not()) {
                                    navigateToOnBoarding()
                                }
                                return@LaunchedEffect
                            }

                            else -> return@LaunchedEffect
                        }
                    }

                    else -> return@LaunchedEffect
                }
            }

            val homeVm = koinViewModel<HomeViewModel>()
            val homeUiState by homeVm.homeUiState.collectAsState()
            HomeScreen(
                uiState = homeUiState,
                uiEvent = homeVm::onEvent,
                navigateToPostListScreen = { category ->
                    if (navigator.canNavigate()) {
                        navigator.navigate(DashboardDestinations.PostList(category.name))
                    }
                },
                navigateToPostDetail = { postData ->
                    val encodedPostData = Json.encodeToString(postData)
                    if (navigator.canNavigate()) {
                        navigator.navigate(DashboardDestinations.PostDetail(encodedPostData))
                    }
                }
            )
        }

        composable<DashboardDestinations.PostList> { backStack ->

            val category = backStack.toRoute<DashboardDestinations.PostList>().category
            val postVm = koinViewModel<PostViewModel>()
            val postUiState by postVm.postUiState.collectAsState()

            PostListScreen(
                uiState = postUiState,
                uiEvent = postVm::onEvent,
                category = Category.valueOf(category),
                navigateToPostDetail = { postData ->
                    val encodedPostData = Json.encodeToString(postData)
                    if (navigator.canNavigate()) {
                        navigator.navigate(DashboardDestinations.PostDetail(encodedPostData))
                    }
                },
                navigateBack = { if (navigator.canNavigate()) navigator.popBackStack() }
            )
        }

        composable<DashboardDestinations.PostDetail> { backStack ->

            val postData = backStack.toRoute<DashboardDestinations.PostDetail>().postData
            val decodedPostData = Json.decodeFromString<PublicPostData>(postData)

            PostDetailScreen(
                postData = decodedPostData,
                navigateToSource = navigateToSource,
                navigateToWebsite = navigateToWebsite,
                navigateBack = { if (navigator.canNavigate()) navigator.popBackStack() }
            )
        }
    }
}
