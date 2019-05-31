package com.example.ribbackstack.root.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribbackstack.R
import com.example.ribbackstack.root.RootView
import com.example.ribbackstack.root.holder.child_one.ChildOneBuilder
import com.example.ribbackstack.root.holder.child_three.ChildThreeBuilder
import com.example.ribbackstack.root.holder.child_two.ChildTwoBuilder
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link HolderScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class HolderBuilder(dependency: ParentComponent) :
    ViewBuilder<HolderView, HolderRouter, HolderBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [HolderRouter].
     *
     * @param parentViewGroup parent view group that this router's view will be added to.
     * @return a new [HolderRouter].
     */
    fun build(parentViewGroup: ViewGroup): HolderRouter {
        val view = createView(parentViewGroup)
        val interactor = HolderInteractor()
        val component = DaggerHolderBuilder_Component.builder()
            .parentComponent(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.holderRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): HolderView? {
        return inflater.inflate(R.layout.holder_rib, parentViewGroup, false) as HolderView

    }

    interface ParentComponent {
        // TODO: Define dependencies required from your parent interactor here.
    }

    @dagger.Module
    abstract class Module {

        @HolderScope
        @Binds
        internal abstract fun presenter(view: HolderView): HolderInteractor.HolderPresenter

        @dagger.Module
        companion object {

            @HolderScope
            @Provides
            @JvmStatic
            internal fun router(
                component: Component,
                view: HolderView,
                interactor: HolderInteractor
            ): HolderRouter {
                return HolderRouter(view, interactor, component, ChildOneBuilder(component), ChildTwoBuilder(component), ChildThreeBuilder(component))
            }
        }

        // TODO: Create provider methods for dependencies created by this Rib. These should be static.
    }

    @HolderScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component : InteractorBaseComponent<HolderInteractor>, ChildOneBuilder.ParentComponent,
        ChildTwoBuilder.ParentComponent, ChildThreeBuilder.ParentComponent, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: HolderInteractor): Builder

            @BindsInstance
            fun view(view: HolderView): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }
    }

    interface BuilderComponent {
        fun holderRouter(): HolderRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class HolderScope

    @Qualifier
    @Retention(CLASS)
    internal annotation class HolderInternal
}
