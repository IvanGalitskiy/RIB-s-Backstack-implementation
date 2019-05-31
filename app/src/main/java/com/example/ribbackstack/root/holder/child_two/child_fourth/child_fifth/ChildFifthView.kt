package com.example.ribbackstack.root.holder.child_two.child_fourth.child_fifth

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * Top level view for {@link ChildFifthBuilder.ChildFifthScope}.
 */
class ChildFifthView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : FrameLayout(context, attrs, defStyle), ChildFifthInteractor.ChildFifthPresenter
