package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.model

import com.google.gson.annotations.SerializedName

data class ValueResponse(
        @SerializedName("value") val value: String,
        @SerializedName("message") val message: String
)

data class HaloEvent(val teks: String)