package com.example.ribbackstack.root.holder.child_two.child_fourth

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ChildFourthRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: ChildFourthBuilder.Component
  @Mock internal lateinit var interactor: ChildFourthInteractor

  private var router: ChildFourthRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = ChildFourthRouter(interactor, component)
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
