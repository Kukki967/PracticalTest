package com.kukki.shraddhapracticaltest.databinding;
import com.kukki.shraddhapracticaltest.R;
import com.kukki.shraddhapracticaltest.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemListBindingImpl extends ItemListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btnDelete, 5);
        sViewsWithIds.put(R.id.separation, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ItemListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[5]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (android.view.View) bindings[6]
            , (com.chauthai.swipereveallayout.SwipeRevealLayout) bindings[0]
            );
        this.body.setTag(null);
        this.email.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.name.setTag(null);
        this.swipeLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((com.kukki.shraddhapracticaltest.PostItemViewModel) variable);
        }
        else if (BR.clickListener == variableId) {
            setClickListener((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.kukki.shraddhapracticaltest.PostItemViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setClickListener(@Nullable android.view.View.OnClickListener ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeVmBody((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeVmEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmName(androidx.lifecycle.MutableLiveData<java.lang.String> VmName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmBody(androidx.lifecycle.MutableLiveData<java.lang.String> VmBody, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmEmail(androidx.lifecycle.MutableLiveData<java.lang.String> VmEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String vmEmailGetValue = null;
        java.lang.String vmNameGetValue = null;
        com.kukki.shraddhapracticaltest.PostItemViewModel vm = mVm;
        android.view.View.OnClickListener clickListener = mClickListener;
        java.lang.String vmBodyGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmName = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmBody = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> vmEmail = null;

        if ((dirtyFlags & 0x2fL) != 0) {


            if ((dirtyFlags & 0x29L) != 0) {

                    if (vm != null) {
                        // read vm.name
                        vmName = vm.getName();
                    }
                    updateLiveDataRegistration(0, vmName);


                    if (vmName != null) {
                        // read vm.name.getValue()
                        vmNameGetValue = vmName.getValue();
                    }
            }
            if ((dirtyFlags & 0x2aL) != 0) {

                    if (vm != null) {
                        // read vm.body
                        vmBody = vm.getBody();
                    }
                    updateLiveDataRegistration(1, vmBody);


                    if (vmBody != null) {
                        // read vm.body.getValue()
                        vmBodyGetValue = vmBody.getValue();
                    }
            }
            if ((dirtyFlags & 0x2cL) != 0) {

                    if (vm != null) {
                        // read vm.email
                        vmEmail = vm.getEmail();
                    }
                    updateLiveDataRegistration(2, vmEmail);


                    if (vmEmail != null) {
                        // read vm.email.getValue()
                        vmEmailGetValue = vmEmail.getValue();
                    }
            }
        }
        if ((dirtyFlags & 0x30L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x2aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.body, vmBodyGetValue);
        }
        if ((dirtyFlags & 0x2cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.email, vmEmailGetValue);
        }
        if ((dirtyFlags & 0x30L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(clickListener);
        }
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, vmNameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.name
        flag 1 (0x2L): vm.body
        flag 2 (0x3L): vm.email
        flag 3 (0x4L): vm
        flag 4 (0x5L): clickListener
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}