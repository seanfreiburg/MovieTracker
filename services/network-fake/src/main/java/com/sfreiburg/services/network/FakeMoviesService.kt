
import com.sfreiburg.services.network.MovieListJson
import com.sfreiburg.services.network.MoviesService
import com.sfreiburg.services.network.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class FakeMoviesService : MoviesService {
    val mockWebServer = MockWebServer()

    private val client =
        OkHttpClient.Builder().connectTimeout(1, TimeUnit.SECONDS).readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS).build()

    private val service = Retrofit.Builder().baseUrl(mockWebServer.url("/")).client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory()).build().create(MoviesService::class.java)

    override suspend fun trendingMoviesWeek(): Result<MovieListJson> {
        return service.trendingMoviesWeek()
    }

    override suspend fun search(query: String, includeAdult: Boolean): Result<MovieListJson> {
        return service.trendingMoviesWeek()
    }
}
