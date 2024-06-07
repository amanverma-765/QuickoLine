package org.quickoline.dashboard.presentation.viewmodel.userentry

internal sealed interface UserEntryUiEvents {

    data object CheckIfOnBoardingIsCompleted: UserEntryUiEvents

}