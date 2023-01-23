# MusicWiki

MusicWiki is a comprehensive, unofficial Last.fm application that offers in-depth information and insights into a wide variety of music genres. The app is designed to provide users with detailed information about the different albums, artists, and tracks that are associated with each genre.
 - MusicWiki aims to be the ultimate destination for music lovers to discover, learn and enjoy the different genres of music in one place.

![807](https://user-images.githubusercontent.com/72141924/214014736-d3656f01-2437-4419-aec4-85606da31571.png)

## Technologies Used


| technologies used | Links |
| ------ | ------ |
| Kotlin | https://kotlinlang.org/ |
| XML | https://www.xml.com/ |
| Retrofit | https://square.github.io/retrofit/ |
| Last.fm API | https://www.last.fm/api |


## How to use Retrofit in Android

Add the Retrofit library to your app-level build.gradle file:

```sh
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
```

- Create a Retrofit instance in your app's initialization code:

```sh
val retrofit = Retrofit.Builder()
    .baseUrl("https://ws.audioscrobbler.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
```
    
- Create an interface for the API you want to call:

```sh
interface LastFmService {
    @GET("/2.0/")
    fun getGenres(@Query("method") method: String, @Query("api_key") apiKey: String): Call<Genres>
} 
```
    
- Use the retrofit instance to create a concrete implementation of the interface:

```sh
val lastFm = retrofit.create(LastFmService::class.java)
```
    
- Use the concrete implementation to make a network request:

```sh
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
    
 ## How to use Last.Fm API in Android
    
To implement the Last.fm API in a Kotlin app, you will need to follow these steps:


- Register for an API key on the Last.fm website.


Add the appropriate dependencies to your app's build.gradle file. For example, if you want to use the Retrofit library to handle the API calls, you would add this line:


```sh
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
```

- Create a service interface in your app to define the API endpoints you want to use. For example, you might define a method for searching for an artist like this:

```sh
interface LastFmService {
    @GET("?method=artist.search&format=json")
    fun searchArtists(@Query("artist") artist: String): Call<ArtistSearchResult>
}
```
- Use Retrofit to create an instance of the service interface and set the base URL for the Last.fm API:
```sh
val retrofit = Retrofit.Builder()
    .baseUrl("http://ws.audioscrobbler.com/2.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    
val lastFmService = retrofit.create(LastFmService::class.java)
```
-Use the service instance to make API calls. For example, to search for an artist, you would call the searchArtists method and pass in the artist name:
```sh
val call = lastFmService.searchArtists("Radiohead")
```
Finally, you can use the returned call object to execute the API call and handle the response.
```sh
call.enqueue(object : Callback<ArtistSearchResult> {
    override fun onResponse(call: Call<ArtistSearchResult>, response: Response<ArtistSearchResult>) {
        // do something with the response
    }

    override fun onFailure(call: Call<ArtistSearchResult>, t: Throwable) {
        // handle failure
    }
})
```
It is important to note that this is just an example of how to implement the Last.fm API in a Kotlin app using the Retrofit library and you may need to add more code or change the existing code depending on your specific use case.


## references

- https://github.com/mateuszteteruk/last-fm-library
- https://github.com/guptajiradhey/Music-Genre/tree/master/app/src/main/java/com/example/assignment
- https://stackoverflow.com/questions/55978243/last-fm-api-returns-same-white-star-image-for-all-artists
- https://www.last.fm/api/intro
- https://www.last.fm/api/mobileauth




