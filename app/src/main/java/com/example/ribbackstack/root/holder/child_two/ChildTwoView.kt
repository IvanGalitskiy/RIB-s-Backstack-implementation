package com.example.ribbackstack.root.holder.child_two

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout

/**
 * Top level view for {@link ChildTwoBuilder.ChildTwoScope}.
 */
class ChildTwoView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle), ChildTwoInteractor.ChildTwoPresenter
