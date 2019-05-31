package com.example.ribbackstack.root.holder.child_two.child_fourth

import android.view.ViewGroup
import com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth.ChildFifthBuilder
import com.example.ribbackstack.root.navigation.BackstackViewRouter
import com.example.ribbackstack.root.navigation.DetachListener
import com.uber.rib.core.Router

/**
 * Adds and removes children of {@link ChildFourthBuilder.ChildFourthScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ChildFourthRouter(
    container: ViewGroup,
    interactor: ChildFourthInteractor,
    component: ChildFourthBuilder.Component,
    val fifthChildBuilder: ChildFifthBuilder
) : BackstackViewRouter<ViewGroup, ChildFourthInteractor, ChildFourthBuilder.Component>(
    container,
    interactor,
    component
) {

    fun attachFifth() {
        val router = fifthChildBuilder.build(view)
        router.detachListener = this
        attachChild(router)
        view.addView(router.view)
    }
}
