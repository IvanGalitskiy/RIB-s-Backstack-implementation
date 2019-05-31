package com.example.ribbackstack.root.holder.child_three

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ChildThreeInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ChildThreeInteractor.ChildThreePresenter
  @Mock internal lateinit var router: ChildThreeRouter

  private var interactor: ChildThreeInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestChildThreeInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ChildThreeInteractor.ChildThreePresenter, ChildThreeRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}