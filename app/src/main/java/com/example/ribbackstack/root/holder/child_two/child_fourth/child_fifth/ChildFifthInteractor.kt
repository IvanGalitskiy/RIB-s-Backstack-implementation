package com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [ChildFifthScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class ChildFifthInteractor : Interactor<ChildFifthInteractor.ChildFifthPresenter, ChildFifthRouter>() {

  @Inject
  lateinit var presenter: ChildFifthPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  override fun handleBackPress() = true

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface ChildFifthPresenter
}
