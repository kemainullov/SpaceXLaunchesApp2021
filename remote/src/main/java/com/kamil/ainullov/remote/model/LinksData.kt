package com.kamil.ainullov.remote.model

data class LinksData(
    val patch: PatchData,
    val flickr: FlickrData,
    val presskit: String,
    val webcast: String,
    val article: String,
    val wikipedia: String
)
