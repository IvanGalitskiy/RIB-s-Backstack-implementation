package com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ChildFifthInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ChildFifthInteractor.ChildFifthPresenter
  @Mock internal lateinit var router: ChildFifthRouter

  private var interactor: ChildFifthInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestChildFifthInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ChildFifthInteractor.ChildFifthPresenter, ChildFifthRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}