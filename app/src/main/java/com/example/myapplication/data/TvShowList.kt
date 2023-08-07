package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.TvShow

object TvShowList {
    val tvShows = listOf(
        TvShow(
            id = 1,
            name = "How I met your mother",
            year = 2007,
            rating = 8.1,
            imageId = R.drawable.logo,
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned"
        ),
        TvShow(
            id = 1,
            name = "Modern Family",
            year = 2016,
            rating = 8.1,
            imageId = R.drawable.logo2,
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned"
        ),
        TvShow(
            id = 1,
            name = "Game of Thrones",
            year = 2012,
            rating = 10.1,
            imageId = R.drawable.log3,
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned"
        ),
        TvShow(
            id = 1,
            name = "Mr Robot",
            year = 2016,
            rating = 8.1,
            imageId = R.drawable.logo,
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned"
        ), TvShow(
            id = 1,
            name = "Silicon Valley",
            year = 2018,
            rating = 8.1,
            imageId = R.drawable.logo2,
            overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned"
        )

    )
}