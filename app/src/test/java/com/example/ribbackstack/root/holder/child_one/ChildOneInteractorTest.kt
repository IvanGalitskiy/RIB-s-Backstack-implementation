package com.example.ribbackstack.root.holder.child_one

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ChildOneInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ChildOneInteractor.ChildOnePresenter
  @Mock internal lateinit var router: ChildOneRouter

  private var interactor: ChildOneInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestChildOneInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ChildOneInteractor.ChildOnePresenter, ChildOneRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}