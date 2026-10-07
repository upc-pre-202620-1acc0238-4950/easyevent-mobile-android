package pe.edu.upc.easyevent.features.home.infrastructure.repository

import pe.edu.upc.easyevent.features.home.domain.Event
import pe.edu.upc.easyevent.features.home.domain.EventRepository
import pe.edu.upc.easyevent.features.home.infrastructure.remote.EventService
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val service: EventService
) : EventRepository {
    override suspend fun getEvents(): Result<List<Event>> {
        try {
            val response = service.getEvents()
            if (response.isSuccessful) {
                response.body()?.let { eventsDto ->
                    val events = eventsDto.map { dto ->
                        Event(
                            id = dto.id,
                            title = dto.title,
                            poster = dto.poster,
                            location = dto.location,
                            date = dto.date,
                            type = dto.type,
                            category = dto.category,
                            website = dto.website,
                            description = dto.description,
                            rating = dto.rating,
                            isFavorite = false
                        )
                    }
                    return Result.success(events)
                }

            }
            return Result.failure(Exception(response.message()))

        } catch (exception: Exception) {
            return Result.failure(exception)
        }
    }

}