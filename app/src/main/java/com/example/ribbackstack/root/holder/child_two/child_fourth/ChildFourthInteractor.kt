package com.example.ribbackstack.root.holder.child_two.child_fourth

import com.uber.rib.core.Bundle
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import com.uber.rib.core.Router

import javax.inject.Inject

/**
 * Coordinates Business Logic for [ChildFourthScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class ChildFourthInteractor : Interactor<EmptyPresenter, ChildFourthRouter>() {

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

    router.attachFifth()
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

}
