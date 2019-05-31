package com.example.ribbackstack.root.holder

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HolderRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: HolderBuilder.Component
  @Mock internal lateinit var interactor: HolderInteractor
  @Mock internal lateinit var view: HolderView

  private var router: HolderRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = HolderRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

