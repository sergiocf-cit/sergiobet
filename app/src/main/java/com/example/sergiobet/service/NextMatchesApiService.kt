package com.example.sergiobet.service

import com.example.sergiobet.model.Match
import io.reactivex.Observable
import retrofit2.http.GET

interface NextMatchesApiService {
    @GET("next-matches")
    fun nextMatches() : Observable<List<Match>>
}