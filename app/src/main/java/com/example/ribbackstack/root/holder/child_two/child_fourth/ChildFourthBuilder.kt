package com.example.ribbackstack.root.holder.child_two.child_fourth

import android.view.ViewGroup
import com.example.ribbackstack.root.holder.child_two.ChildTwoView
import com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth.ChildFifthBuilder
import com.uber.rib.core.Builder
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.InteractorBaseComponent
import java.lang.annotation.Retention

import javax.inject.Qualifier
import javax.inject.Scope

import dagger.Provides
import dagger.BindsInstance

import java.lang.annotation.RetentionPolicy.CLASS

class ChildFourthBuilder(dependency: ParentComponent) :
    Builder<ChildFourthRouter, ChildFourthBuilder.ParentComponent>(dependency) {

    /**
     * Builds a new [ChildFourthRouter].
     *
     * @return a new [ChildFourthRouter].
     */
    fun build(): ChildFourthRouter {
        val interactor = ChildFourthInteractor()
        val component = DaggerChildFourthBuilder_Component.builder()
            .parentComponent(dependency)
            .interactor(interactor)
            .build()

        return component.childfourthRouter()
    }

    interface ParentComponent {
        fun rootView(): ChildTwoView
    }


    @dagger.Module
    abstract class Module {

        @dagger.Module
        companion object {

            @ChildFourthScope
            @Provides
            @JvmStatic
            internal fun presenter(): EmptyPresenter {
                return EmptyPresenter()
            }

            @ChildFourthScope
            @Provides
            @JvmStatic
            internal fun router(container: ChildTwoView, component: Component, interactor: ChildFourthInteractor): ChildFourthRouter {
                return ChildFourthRouter(container, interactor, component, ChildFifthBuilder(component))
            }
        }
    }


    @ChildFourthScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component : InteractorBaseComponent<ChildFourthInteractor>, ChildFifthBuilder.ParentComponent, BuilderComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: ChildFourthInteractor): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }

    }

    interface BuilderComponent {
        fun childfourthRouter(): ChildFourthRouter
    }

    @Scope
    @Retention(CLASS)
    internal annotation class ChildFourthScope


    @Qualifier
    @Retention(CLASS)
    internal annotation class ChildFourthInternal
}
