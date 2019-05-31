package com.example.ribbackstack.root.holder.child_one

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribbackstack.R
import com.example.ribbackstack.root.holder.child_three.ChildThreeView
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
 * Builder for the {@link ChildOneScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ChildOneBuilder(dependency: ParentComponent) : ViewBuilder<ChildOneView, ChildOneRouter, ChildOneBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [ChildOneRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [ChildOneRouter].
   */
  fun build(parentViewGroup: ViewGroup): ChildOneRouter {
    val view = createView(parentViewGroup)
    val interactor = ChildOneInteractor()
    val component = DaggerChildOneBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.childoneRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ChildOneView? {
    return inflater.inflate(R.layout.child_one_rib, parentViewGroup, false) as ChildOneView

  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @ChildOneScope
    @Binds
    internal abstract fun presenter(view: ChildOneView): ChildOneInteractor.ChildOnePresenter

    @dagger.Module
    companion object {

      @ChildOneScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: ChildOneView,
          interactor: ChildOneInteractor): ChildOneRouter {
        return ChildOneRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @ChildOneScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<ChildOneInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: ChildOneInteractor): Builder

      @BindsInstance
      fun view(view: ChildOneView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun childoneRouter(): ChildOneRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class ChildOneScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class ChildOneInternal
}
