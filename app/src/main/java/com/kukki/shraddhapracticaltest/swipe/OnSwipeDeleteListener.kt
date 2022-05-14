package com.kukki.shraddhapracticaltest.swipe

import com.kukki.shraddhapracticaltest.data.PostVo

interface OnSwipeDeleteListener {

    fun onDeleteButtonClicked(orderVo: PostVo, position: Int)

}
