package com.example.network.domain.model

//01.04.2026
//Алексей
//модель проекта
data class Project(
    val id: String = "",
    val collectionId: String = "",
    val collectionName: String = "",
    val created: String = "",
    val updated: String = "",
    val title: String = "",
    val dateStart: String ="",
    val dateEnd: String = "",
    val gender: String = "",
    val description_source: String = "",
    val category: String = "",
    val image: String = "",
    val user_id: String = ""
)