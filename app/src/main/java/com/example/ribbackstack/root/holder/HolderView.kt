package com.example.ribbackstack.root.holder

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

/**
 * Top level view for {@link HolderBuilder.HolderScope}.
 */
class HolderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle), HolderInteractor.HolderPresenter
