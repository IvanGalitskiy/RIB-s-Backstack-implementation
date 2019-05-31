package com.example.ribbackstack.root.holder

import android.view.View
import com.example.ribbackstack.root.holder.child_one.ChildOneBuilder
import com.example.ribbackstack.root.holder.child_three.ChildThreeBuilder
import com.example.ribbackstack.root.holder.child_two.ChildTwoBuilder
import com.example.ribbackstack.root.navigation.BackstackViewRouter
import com.example.ribbackstack.root.navigation.DetachListener

import com.uber.rib.core.ViewRouter
import java.util.*

/**
 * Adds and removes children of {@link HolderBuilder.HolderScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class HolderRouter(
    view: HolderView,
    interactor: HolderInteractor,
    component: HolderBuilder.Component,
    val oneBuilder: ChildOneBuilder,
    val twoBuilder: ChildTwoBuilder,
    val threeBuilder: ChildThreeBuilder
) : BackstackViewRouter<HolderView, HolderInteractor, HolderBuilder.Component>(view, interactor, component) {

    fun addAll() {
        val oneRouter = oneBuilder.build(view)
        view.addView(oneRouter.view)
        oneRouter.setDetachListener(this)
        attachChild(oneRouter)

        val twoRouter = twoBuilder.build(view)
        twoRouter.setDetachListener(this)
        view.addView(twoRouter.view)
        attachChild(twoRouter)
//
        val threeRouter = threeBuilder.build(view)
        threeRouter.setDetachListener(this)
        attachChild(threeRouter)
        view.addView(threeRouter.view)

    }
}
