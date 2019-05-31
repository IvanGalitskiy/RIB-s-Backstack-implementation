package com.example.ribbackstack.root.navigation

import com.uber.rib.core.ViewRouter

interface DetachListener {
    fun detach(viewRouter: BackstackViewRouter<*,*,*>)
}