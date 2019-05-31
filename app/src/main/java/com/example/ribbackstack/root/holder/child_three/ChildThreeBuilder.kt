package com.example.ribbackstack.root.holder.child_three

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribbackstack.R
import com.example.ribbackstack.root.holder.child_two.ChildTwoView
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
 * Builder for the {@link ChildThreeScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ChildThreeBuilder(dependency: ParentComponent) : ViewBuilder<ChildThreeView, ChildThreeRouter, ChildThreeBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [ChildThreeRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [ChildThreeRouter].
   */
  fun build(parentViewGroup: ViewGroup): ChildThreeRouter {
    val view = createView(parentViewGroup)
    val interactor = ChildThreeInteractor()
    val component = DaggerChildThreeBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.childthreeRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ChildThreeView? {
    return inflater.inflate(R.layout.child_three_rib, parentViewGroup, false) as ChildThreeView
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @ChildThreeScope
    @Binds
    internal abstract fun presenter(view: ChildThreeView): ChildThreeInteractor.ChildThreePresenter

    @dagger.Module
    companion object {

      @ChildThreeScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: ChildThreeView,
          interactor: ChildThreeInteractor): ChildThreeRouter {
        return ChildThreeRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @ChildThreeScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<ChildThreeInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: ChildThreeInteractor): Builder

      @BindsInstance
      fun view(view: ChildThreeView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun childthreeRouter(): ChildThreeRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class ChildThreeScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class ChildThreeInternal
}
