package org.quickoline.home.presentation.viewmodel.userentry

internal sealed interface UserEntryUiEvents {

    data object CheckIfOnBoardingIsCompleted: UserEntryUiEvents

}