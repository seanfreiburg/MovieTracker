package com.sfreiburg.framework.presenters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface EventConsumer<VE> {
    fun onEvent(event: VE)
}

interface ViewModelOutput<VS : MavericksState, VM> {
    val viewModelFlow: Flow<VM>

    fun VS.reduce(): VM
}

// class to wrap MavericksViewModel to implement a couple interfaces and
// access to viewmodels instead of state
abstract class MavericksPresenter<VS : MavericksState, VE, VM>(initialState: VS) :
    MavericksViewModel<VS>(initialState), EventConsumer<VE>, ViewModelOutput<VS, VM> {

    abstract override fun onEvent(event: VE)

    override val viewModelFlow: Flow<VM>
        get() = stateFlow.map { it.reduce() }
}


@Composable
fun <P : MavericksPresenter<VS, VE, VM>, VS : MavericksState, VE: Any, VM: Any> P.collectViewModelsAsState(): State<VM> {
    return viewModelFlow.collectAsState(initial = com.airbnb.mvrx.withState(this) { it.reduce() })
}