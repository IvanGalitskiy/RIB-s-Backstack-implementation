package com.example.ribbackstack.root.navigation;

import android.view.View;
import android.view.ViewGroup;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.Router;
import com.uber.rib.core.ViewRouter;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Stack;

public class BackstackViewRouter<V extends View, I extends Interactor, C extends InteractorBaseComponent> extends ViewRouter<V, I, C> implements DetachListener {
    protected Stack<BackstackViewRouter> backStack = new Stack<>();
    private DetachListener detachListener;

    public BackstackViewRouter(V view, I interactor, C component) {
        super(view, interactor, component);
    }

    public void setDetachListener(DetachListener detachListener) {
        this.detachListener = detachListener;
    }

    public DetachListener getDetachListener() {
        return detachListener;
    }

    @Override
    protected void attachChild(Router<?, ?> childRouter) {
        super.attachChild(childRouter);
        if (childRouter instanceof BackstackViewRouter){
            backStack.push((BackstackViewRouter) childRouter);
        }
    }

    @Override
    public void detach(@NotNull BackstackViewRouter viewRouter) {
        detachChild(viewRouter);
        if (getView() instanceof ViewGroup) {
            ((ViewGroup) getView()).removeView(viewRouter.getView());
        }
        backStack.remove(viewRouter);
    }

    @Override
    public boolean handleBackPress() {
        if (!backStack.isEmpty()) {
            for (BackstackViewRouter router : backStack) {
                if (router.handleBackPress()) {
                    return true;
                }
            }
        }

        boolean res =  super.handleBackPress();
        if (res){
            if (detachListener != null) {
                detachListener.detach(this);
            }
        }
        return res;
    }
}
