package com.tiparo.tripway.repository.network.api.services

import com.tiparo.tripway.discovery.api.dto.DiscoveryInfo
import com.tiparo.tripway.posting.api.dto.PointApi
import com.tiparo.tripway.profile.api.dto.ProfileInfo
import com.tiparo.tripway.trippage.api.dto.TripPageInfo
import com.tiparo.tripway.utils.RxUnit
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import okhttp3.MultipartBody
import retrofit2.http.*
import java.sql.Timestamp

interface TripsService {

    @GET("discovery")
    fun getTripsDiscoveryPage(@Query("anchor") anchor: String?): Single<DiscoveryInfo>

    @POST("point")
    fun postPoint(@Body pointApi: PointApi): Maybe<PointPostResult>

    @Multipart
    @POST("uploadPointPhotos")
    fun uploadPhotos(@Part photos: List<MultipartBody.Part>, @Part("point_id") pointId: Long): Maybe<PointPostResult>

    @GET("ownTrips")
    fun getOwnTrips(): Single<List<Trip>>

    @GET("profile")
    fun getProfile(@Query("user_id") userId: String?): Single<ProfileInfo>

    @GET("trip/{tripId}")
    fun getTrip(@Path("tripId") tripId: Long): Single<TripPageInfo>

    @POST("subscribe")
    fun subscribeToUser(@Query("user_id") userId: String): Maybe<Any>

    @POST("unsubscribe")
    fun unsubscribeFromUser(@Query("user_id") userId: String): Maybe<Any>

    //TODO Решить вопрос с размещение модели в пакетах
    data class Trip(
        val id: Long,
        val tripname: String,
        val is_completed: Boolean,
        val first_point_name: String,
        val last_point_name: String,
        val photo: String,
        val updated: Timestamp,
        val user_id: String,
        val user_name: String
    )

    data class PointPostResult(
        val id: Long?
    )
}