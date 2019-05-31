package com.example.ribbackstack.root.holder.child_one

import android.view.View
import com.example.ribbackstack.root.navigation.BackstackViewRouter

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link ChildOneBuilder.ChildOneScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ChildOneRouter(
    view: ChildOneView,
    interactor: ChildOneInteractor,
    component: ChildOneBuilder.Component) : BackstackViewRouter<ChildOneView, ChildOneInteractor, ChildOneBuilder.Component>(view, interactor, component)
