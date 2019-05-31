package com.example.ribbackstack.root.holder.child_two

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ribbackstack.R
import com.example.ribbackstack.root.RootView
import com.example.ribbackstack.root.holder.child_two.child_fourth.ChildFourthBuilder
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
 * Builder for the {@link ChildTwoScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ChildTwoBuilder(dependency: ParentComponent) : ViewBuilder<ChildTwoView, ChildTwoRouter, ChildTwoBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [ChildTwoRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [ChildTwoRouter].
   */
  fun build(parentViewGroup: ViewGroup): ChildTwoRouter {
    val view = createView(parentViewGroup)
    val interactor = ChildTwoInteractor()
    val component = DaggerChildTwoBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.childtwoRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ChildTwoView? {
    return inflater.inflate(R.layout.child_two_rib, parentViewGroup, false) as ChildTwoView

  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @ChildTwoScope
    @Binds
    internal abstract fun presenter(view: ChildTwoView): ChildTwoInteractor.ChildTwoPresenter

    @dagger.Module
    companion object {

      @ChildTwoScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: ChildTwoView,
          interactor: ChildTwoInteractor): ChildTwoRouter {
        return ChildTwoRouter(view, interactor, component, ChildFourthBuilder(component))
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @ChildTwoScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<ChildTwoInteractor>, ChildFourthBuilder.ParentComponent, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: ChildTwoInteractor): Builder

      @BindsInstance
      fun view(view: ChildTwoView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun childtwoRouter(): ChildTwoRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class ChildTwoScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class ChildTwoInternal
}
