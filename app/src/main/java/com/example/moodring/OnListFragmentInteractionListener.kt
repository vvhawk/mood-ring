package com.example.moodring

/**
 * This interface is used by the [NowPlayingMoviesRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [NowPlayingMoviesFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: JourneyEntry)
}


