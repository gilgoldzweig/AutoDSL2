package app.letsqit.com.autodsl

import app.letsqit.com.annotations.annotations.AutoDSL
import app.letsqit.com.annotations.annotations.Column


/**
 * Created by gilgoldzweig on 08/07/2017.
 */



@AutoDSL()
data class LocationFinder<A,B,C>(
        var latitude: Double = 0.0,
        val longitude: Double = 0.0,
        @Column(hasDefaultValues = false)
        val placeName: String,
        var placesList: List<A> = emptyList(),
        var placesSet: Set<B> = emptySet(),
        var placesMap: Map<Pair<A,B>, Pair<C, B>> = emptyMap(),
        @Column(hasDefaultValues = false)
        var onClick: (a: (a: A, b: B, c: C) -> Unit, b: (a: A, b: B, c: C) -> Unit, c: (a: A, b: B, c: C) -> Unit) -> Unit)