package com.tiparo.tripway.models

import android.net.Uri
import androidx.room.*
import com.google.android.gms.maps.model.LatLng
import com.tiparo.tripway.repository.network.api.services.ReverseGeocodingResponse.GeocodingResult.AddressComponent

@Entity
data class Point(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @Embedded var location: Location = Location(),
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "photos") var photos: List<Uri> = arrayListOf(),
    @ColumnInfo(name = "trip_id") var tripId: Long? = null
) {
    data class Location(
        @ColumnInfo(name = "position") var position: LatLng = LatLng(1.0, 1.0),
        @ColumnInfo(name = "address") var address: String = "",
        @ColumnInfo(name = "address_components") var addressComponents: List<AddressComponent> = listOf()
    )
}