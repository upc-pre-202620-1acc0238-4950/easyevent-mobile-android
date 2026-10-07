package pe.edu.upc.easyevent.features.home.infrastructure.remote

import retrofit2.Response
import retrofit2.http.GET

interface EventService {


    @GET("events")
    suspend fun getEvents(): Response<List<EventDto>>
}