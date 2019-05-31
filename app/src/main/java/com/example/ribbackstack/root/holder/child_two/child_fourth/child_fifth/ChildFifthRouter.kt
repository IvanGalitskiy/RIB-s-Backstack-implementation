package com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth

import android.view.View
import com.example.ribbackstack.root.navigation.BackstackViewRouter

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link ChildFifthBuilder.ChildFifthScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ChildFifthRouter(
    view: ChildFifthView,
    interactor: ChildFifthInteractor,
    component: ChildFifthBuilder.Component) : BackstackViewRouter<ChildFifthView, ChildFifthInteractor, ChildFifthBuilder.Component>(view, interactor, component){
    override fun handleBackPress(): Boolean {
        return super.handleBackPress()
    }
}
