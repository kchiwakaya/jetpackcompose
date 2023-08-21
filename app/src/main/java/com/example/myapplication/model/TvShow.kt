package com.example.myapplication.model

import java.io.Serializable

class TvShow(val id: Int,
             val name: String,
             val year: Int,
             val genre: String
             val rating:Double,
             val imageId:Int,
             val overview:String
):Serializable
