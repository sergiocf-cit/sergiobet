package com.example.sergiobet.service

import com.example.sergiobet.model.Match
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface NextMatchesService {
    @GET("next-matches")
    fun nextMatches() : Observable<List<Match>>
}