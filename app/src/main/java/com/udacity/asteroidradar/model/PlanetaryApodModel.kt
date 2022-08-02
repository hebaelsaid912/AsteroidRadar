package com.udacity.asteroidradar.model

import com.squareup.moshi.Json

data class PlanetaryApodModel(
    @Json(name= "date")
    val date: String,
    @Json(name= "explanation")
    val explanation: String,
    @Json(name= "hdurl")
    val hdurl: String,
    @Json(name= "media_type")
    val media_type: String,
    @Json(name= "service_version")
    val service_version: String,
    @Json(name= "title")
    val title: String,
    @Json(name= "url")
    val url: String
)