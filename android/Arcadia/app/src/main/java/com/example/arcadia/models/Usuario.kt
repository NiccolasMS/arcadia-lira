package com.example.arcadia.models

import com.google.gson.annotations.SerializedName
import java.time.ZonedDateTime

// data class que "mapeia", "espelha" um JSON da API de autenticação
open class Usuario(
    var nome:String?=null,
    var email:String?=null,
    var telefone:String?=null,
    var senha:String?=null
)
