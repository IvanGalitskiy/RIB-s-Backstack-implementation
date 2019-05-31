package com.example.ribbackstack.root

import android.view.View
import com.example.ribbackstack.root.holder.HolderBuilder
import com.example.ribbackstack.root.navigation.BackstackViewRouter
import com.example.ribbackstack.root.navigation.DetachListener
import com.uber.rib.core.Router

import com.uber.rib.core.ViewRouter
import java.util.*

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
    view: RootView,
    interactor: RootInteractor,
    component: RootBuilder.Component,
    private val holderBuilder: HolderBuilder
) : BackstackViewRouter<RootView, RootInteractor, RootBuilder.Component>(view, interactor, component) {


    fun attachHolder() {
        val router = holderBuilder.build(view)
        router.setDetachListener(this)
        attachChild(router)
        view.addView(router.view)
    }
}
