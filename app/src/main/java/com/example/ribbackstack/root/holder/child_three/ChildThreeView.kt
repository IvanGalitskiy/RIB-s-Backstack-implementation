package com.example.ribbackstack.root.holder.child_three

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button

/**
 * Top level view for {@link ChildThreeBuilder.ChildThreeScope}.
 */
class ChildThreeView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : Button(context, attrs, defStyle), ChildThreeInteractor.ChildThreePresenter
