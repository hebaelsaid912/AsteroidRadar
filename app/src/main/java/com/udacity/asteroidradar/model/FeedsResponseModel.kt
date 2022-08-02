package com.udacity.asteroidradar.model

import com.squareup.moshi.Json

data class FeedsResponseModel(
    @Json(name = "element_count")
    val element_count: Int,
    @Json(name = "links")
    val links: Links,
    @Json(name = "near_earth_objects")
    val near_earth_objects: Any
) {
    data class Links(
        @Json(name = "next")
        val next: String,
        @Json(name = "prev")
        val prev: String,
        @Json(name = "self")
        val self: String
    )

    data class NearEarthObjects(
       // @Json(name = "2022-07-22")
        var data: Map<String,List<DateDetails>>
    ) {
        data class DateDetails(
            @Json(name = "absolute_magnitude_h")
            val absolute_magnitude_h: Double,
            @Json(name = "close_approach_data")
            val close_approach_data: List<CloseApproachData>,
            @Json(name = "estimated_diameter")
            val estimated_diameter: EstimatedDiameter,
            @Json(name = "id")
            val id: String,
            @Json(name = "is_potentially_hazardous_asteroid")
            val is_potentially_hazardous_asteroid: Boolean,
            @Json(name = "is_sentry_object")
            val is_sentry_object: Boolean,
            @Json(name = "links")
            val links: Links,
            @Json(name = "name")
            val name: String,
            @Json(name = "nasa_jpl_url")
            val nasa_jpl_url: String,
            @Json(name = "neo_reference_id")
            val neo_reference_id: String
        ) {
            data class CloseApproachData(
                @Json(name = "close_approach_date")
                val close_approach_date: String,
                @Json(name = "close_approach_date_full")
                val close_approach_date_full: String,
                @Json(name = "epoch_date_close_approach")
                val epoch_date_close_approach: Long,
                @Json(name = "miss_distance")
                val miss_distance: MissDistance,
                @Json(name = "orbiting_body")
                val orbiting_body: String,
                @Json(name = "relative_velocity")
                val relative_velocity: RelativeVelocity
            ) {
                data class MissDistance(
                    @Json(name = "astronomical")
                    val astronomical: String,
                    @Json(name = "kilometers")
                    val kilometers: String,
                    @Json(name = "lunar")
                    val lunar: String,
                    @Json(name = "miles")
                    val miles: String
                )

                data class RelativeVelocity(
                    @Json(name = "kilometers_per_hour")
                    val kilometers_per_hour: String,
                    @Json(name = "kilometers_per_second")
                    val kilometers_per_second: String,
                    @Json(name = "miles_per_hour")
                    val miles_per_hour: String
                )
            }

            data class EstimatedDiameter(
                @Json(name = "feet")
                val feet: Feet,
                @Json(name = "kilometers")
                val kilometers: Kilometers,
                @Json(name = "meters")
                val meters: Meters,
                @Json(name = "miles")
                val miles: Miles
            ) {
                data class Feet(
                    @Json(name = "estimated_diameter_max")
                    val estimated_diameter_max: Double,
                    @Json(name = "estimated_diameter_min")
                    val estimated_diameter_min: Double
                )

                data class Kilometers(
                    @Json(name = "estimated_diameter_max")
                    val estimated_diameter_max: Double,
                    @Json(name = "estimated_diameter_min")
                    val estimated_diameter_min: Double
                )

                data class Meters(
                    @Json(name = "estimated_diameter_max")
                    val estimated_diameter_max: Double,
                    @Json(name = "estimated_diameter_min")
                    val estimated_diameter_min: Double
                )

                data class Miles(
                    @Json(name = "estimated_diameter_max")
                    val estimated_diameter_max: Double,
                    @Json(name = "estimated_diameter_min")
                    val estimated_diameter_min: Double
                )
            }

            data class Links(
                @Json(name = "self")
                val self: String
            )
        }
    }
}