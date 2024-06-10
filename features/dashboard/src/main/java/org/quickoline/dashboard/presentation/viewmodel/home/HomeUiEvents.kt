package org.quickoline.dashboard.presentation.viewmodel.home

internal sealed interface HomeUiEvents {
    data object FetchTrendingData : HomeUiEvents
}