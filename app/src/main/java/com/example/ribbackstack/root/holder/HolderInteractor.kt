package com.example.ribbackstack.root.holder

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject

/**
 * Coordinates Business Logic for [HolderScope].
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
class HolderInteractor : Interactor<HolderInteractor.HolderPresenter, HolderRouter>() {

  @Inject
  lateinit var presenter: HolderPresenter

  override fun didBecomeActive(savedInstanceState: Bundle?) {
    super.didBecomeActive(savedInstanceState)

   router.addAll()
  }

  override fun willResignActive() {
    super.willResignActive()

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  override fun handleBackPress(): Boolean {
    return true
  }

  interface HolderPresenter
}
