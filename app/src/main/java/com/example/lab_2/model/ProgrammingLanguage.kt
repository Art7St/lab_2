package com.example.lab_2.model

import java.io.Serializable

data class ProgrammingLanguage(
    val name: String,
    val shortDescription: String,
    val description: String,
    val url: String
): Serializable