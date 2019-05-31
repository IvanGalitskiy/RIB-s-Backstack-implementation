package com.example.ribbackstack.root.holder.child_one

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [ChildOneScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class ChildOneInteractor : Interactor<ChildOneInteractor.ChildOnePresenter, ChildOneRouter>() {

  @Inject
  lateinit var presenter: ChildOnePresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  override fun handleBackPress(): Boolean {
    return false
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface ChildOnePresenter
}
