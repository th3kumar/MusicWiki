#MusicWiki

MusicWiki is an unofficial Last.fm app that contains information about different music genres, the albums, artists and tracks listed under the genre.

![807](https://user-images.githubusercontent.com/72141924/214014736-d3656f01-2437-4419-aec4-85606da31571.png)

##Technologies Used
-Kotlin
-XML
-Last.fm API
-Retrofit

##How to use Retrofit in Android

Add the Retrofit library to your app-level build.gradle file:

```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'

```

Create a Retrofit instance in your app's initialization code:

```
val retrofit = Retrofit.Builder()
    .baseUrl("https://ws.audioscrobbler.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    ```
    
-Create an interface for the API you want to call:

```
interface LastFmService {
    @GET("/2.0/")
    fun getGenres(@Query("method") method: String, @Query("api_key") apiKey: String): Call<Genres>
} 
    ```
-Use the retrofit instance to create a concrete implementation of the interface:

    ```
val lastFm = retrofit.create(LastFmService::class.java)
    ```
    
-Use the concrete implementation to make a network request:
```
val call = lastFm.getGenres("tag.getTopTags", "YOUR_API_KEY")
call.enqueue(object : Callback<Genres> {
    override fun onResponse(call: Call<Genres>, response: Response<Genres>) {
        val genres = response.body()
        // do something with the genres
    }

    override fun onFailure(call: Call<Genres>, t: Throwable) {
        // handle failure
    }
})
    ```
##How to use Last.Fm API in Android
    
-Register for an API key at https://www.last.fm/api
-Use the API key in your Retrofit interface as shown in the example above
-Make sure to follow Last.fm's terms of use and usage guidelines when using their API in your app.




