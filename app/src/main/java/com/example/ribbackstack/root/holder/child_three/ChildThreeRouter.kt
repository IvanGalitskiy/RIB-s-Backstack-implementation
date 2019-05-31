package com.example.ribbackstack.root.holder.child_three

import android.view.View
import com.example.ribbackstack.root.navigation.BackstackViewRouter

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link ChildThreeBuilder.ChildThreeScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ChildThreeRouter(
    view: ChildThreeView,
    interactor: ChildThreeInteractor,
    component: ChildThreeBuilder.Component) : BackstackViewRouter<ChildThreeView, ChildThreeInteractor, ChildThreeBuilder.Component>(view, interactor, component)
