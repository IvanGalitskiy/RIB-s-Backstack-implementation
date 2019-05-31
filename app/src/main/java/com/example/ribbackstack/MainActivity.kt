package com.example.ribbackstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.example.ribbackstack.root.RootBuilder
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class MainActivity : RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
        val rootBuilder = RootBuilder(object : RootBuilder.ParentComponent {
        })
        val router = rootBuilder.build(parentViewGroup)
        return router
    }
}
