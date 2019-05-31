package com.example.ribbackstack.root.holder.child_three

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [ChildThreeScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class ChildThreeInteractor : Interactor<ChildThreeInteractor.ChildThreePresenter, ChildThreeRouter>() {

  @Inject
  lateinit var presenter: ChildThreePresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  override fun handleBackPress() = false

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface ChildThreePresenter
}
