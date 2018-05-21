package id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data

import id.co.jysk.learnkotlindagger2retrofitrxjavamvp.data.model.ValueResponse
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServiceInsert {

    @FormUrlEncoded
    @POST("insert.php")
    fun daftar(@Field("npm") npm: String,
               @Field("nama") nama: String,
               @Field("kelas") kelas: String): Flowable<ValueResponse>
}