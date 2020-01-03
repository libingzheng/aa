package com.example.myapplication.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {

    private WeakReference<V> weakReference;

    public BasePresenter(){
        initModel();
    }

    public void attachView(V v){
        weakReference = new WeakReference<>(v);
    }
    public void detachView(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        V v = weakReference.get();
        return v;
    }
    protected abstract void initModel();
}
