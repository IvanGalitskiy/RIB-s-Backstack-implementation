package com.example.ribbackstack.root.holder.child_two

import android.view.View
import com.example.ribbackstack.root.holder.child_two.child_fourth.ChildFourthBuilder
import com.example.ribbackstack.root.navigation.BackstackViewRouter
import com.example.ribbackstack.root.navigation.DetachListener

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link ChildTwoBuilder.ChildTwoScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ChildTwoRouter(
    view: ChildTwoView,
    interactor: ChildTwoInteractor,
    component: ChildTwoBuilder.Component,
    val childFourthBuilder: ChildFourthBuilder) : BackstackViewRouter<ChildTwoView, ChildTwoInteractor, ChildTwoBuilder.Component>(view, interactor, component){

    fun attachChildFour(){
        val router = childFourthBuilder.build()
        router.detachListener = this
        attachChild(router)
    }
}
