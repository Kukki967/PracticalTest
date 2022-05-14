package com.kukki.shraddhapracticaltest.swipe

import java.util.*

/**
 * ViewBinderHelper provides a quick and easy solution to restore the open/close state
 * of the items in RecyclerView, ListView, GridView or any view that requires its child view
 * to bind the view to a data object.
 *
 *
 * When you bind you data object to a view, use [.bind] to
 * save and restore the open/close state of the view.
 */
class ViewBinderHelper {

    private val mapStates = Collections.synchronizedMap(HashMap<String, Int>())
    private val mapLayouts = Collections.synchronizedMap(HashMap<String, SwipeController>())
    private val lockedSwipeSet = Collections.synchronizedSet(HashSet<String>())

    var openOnlyOne = true
    private val stateChangeLock = Any()

    private val openCount: Int
        get() {
            var total = 0

            for (state in mapStates.values) {
                if (state == SwipeController.STATE_OPEN || state == SwipeController.STATE_OPENING) {
                    total++
                }
            }

            return total
        }

    /**
     * Help to save and restore open/close state of the swipeLayout. Call this method
     * when you bind your view holder with the data object.
     *
     * @param swipeLayout swipeLayout of the current view.
     * @param id          a string that uniquely defines the data object of the current view.
     */
    fun bind(swipeLayout: SwipeController, id: String) {
        if (swipeLayout.shouldRequestLayout()) {
            swipeLayout.requestLayout()
        }

        mapLayouts.values.remove(swipeLayout)
        mapLayouts[id] = swipeLayout

        swipeLayout.abort()
        swipeLayout.setDragStateChangeListener(object : SwipeController.DragStateChangeListener {
            override fun onDragStateChanged(state: Int) {
                mapStates[id] = state

                closeOthers(id, swipeLayout)
            }
        })

        if (!openOnlyOne) {
            closeThis(id, swipeLayout)
        }

        // first time binding.
        if (!mapStates.containsKey(id)) {
            mapStates[id] = SwipeController.STATE_CLOSE
            swipeLayout.close(false)
        } else {
            val state = mapStates[id]!!

            if (state == SwipeController.STATE_CLOSE || state == SwipeController.STATE_CLOSING ||
                state == SwipeController.STATE_DRAGGING
            ) {
                swipeLayout.close(false)
            } else {
                swipeLayout.open(false)
            }
        }// not the first time, then close or open depends on the current state.

        // set lock swipe
        swipeLayout.setLockDrag(lockedSwipeSet.contains(id))
    }

    /**
     * Close others swipe layout.
     *
     * @param id          layout which bind with this data object id will be excluded.
     * @param swipeLayout will be excluded.
     */
    private fun closeOthers(id: String, swipeLayout: SwipeController) {
        synchronized(stateChangeLock) {
            // close other rows if openOnlyOne is true.
            if (openCount > 1) {
                for (entry in mapStates.entries) {
                    if (entry.key != id) {
                        entry.setValue(SwipeController.STATE_CLOSE)
                    }
                }

                for (layout in mapLayouts.values) {
                    if (layout != swipeLayout) {
                        layout.close(true)
                    }
                }
            }
        }
    }

    /**
     * Close the swipe layout next the one which is deleted.
     *
     * @param id          layout which bind with this data object id will be excluded.
     * @param swipeLayout will be excluded.
     */
    private fun closeThis(id: String, swipeLayout: SwipeController) {
        synchronized(stateChangeLock) {
            for (entry in mapStates.entries) {
                if (entry.key == id) {
                    entry.setValue(SwipeController.STATE_CLOSE)
                }
            }

            for (layout in mapLayouts.values) {
                if (layout == swipeLayout) {
                    layout.close(true)

                }
            }
        }
    }

}

