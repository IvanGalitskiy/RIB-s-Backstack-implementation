package com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribbackstack.R
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
 * Builder for the {@link ChildFifthScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ChildFifthBuilder(dependency: ParentComponent) : ViewBuilder<ChildFifthView, ChildFifthRouter, ChildFifthBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [ChildFifthRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [ChildFifthRouter].
   */
  fun build(parentViewGroup: ViewGroup): ChildFifthRouter {
    val view = createView(parentViewGroup)
    val interactor = ChildFifthInteractor()
    val component = DaggerChildFifthBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.childfifthRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ChildFifthView? {
   return inflater.inflate(R.layout.child_fifth_rib, parentViewGroup, false) as ChildFifthView
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @ChildFifthScope
    @Binds
    internal abstract fun presenter(view: ChildFifthView): ChildFifthInteractor.ChildFifthPresenter

    @dagger.Module
    companion object {

      @ChildFifthScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: ChildFifthView,
          interactor: ChildFifthInteractor): ChildFifthRouter {
        return ChildFifthRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @ChildFifthScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<ChildFifthInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: ChildFifthInteractor): Builder

      @BindsInstance
      fun view(view: ChildFifthView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun childfifthRouter(): ChildFifthRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class ChildFifthScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class ChildFifthInternal
}
