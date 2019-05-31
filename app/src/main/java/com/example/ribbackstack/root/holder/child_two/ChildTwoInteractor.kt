package com.example.ribbackstack.root.holder.child_two

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [ChildTwoScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class ChildTwoInteractor : Interactor<ChildTwoInteractor.ChildTwoPresenter, ChildTwoRouter>() {

  @Inject
  lateinit var presenter: ChildTwoPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)
    router.attachChildFour()
    // TODO: Add attachment logic here (RxSubscriptions, etc.).
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface ChildTwoPresenter

  override fun handleBackPress() = true
}
