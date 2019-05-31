package com.example.ribbackstack.root.holder.child_two

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ChildTwoInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ChildTwoInteractor.ChildTwoPresenter
  @Mock internal lateinit var router: ChildTwoRouter

  private var interactor: ChildTwoInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestChildTwoInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ChildTwoInteractor.ChildTwoPresenter, ChildTwoRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}