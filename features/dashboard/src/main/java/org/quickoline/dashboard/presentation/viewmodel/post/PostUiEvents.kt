package org.quickoline.dashboard.presentation.viewmodel.post

import org.quickoline.dashboard.presentation.components.Category

internal sealed interface PostUiEvents {
    data class FetchPostData(val category: Category): PostUiEvents
}