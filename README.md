<!-- PROJECT LOGO -->
<br />
<p align="center">


  <h1 align="center">PokeShuffle</h3>


<!-- ABOUT THE PROJECT -->
## About The Project
Android app using RESTful Pokémon API called PokeAPI. It shows a random pokemon on screen and provides some information about this pokemon.
It was a nice small project that helped me understand MVVM structure a little bit more. It also helped me with understanding Retrofit and working with
Restful APIs.


### What I Used

* [Android Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started)
* [Data-binding](https://developer.android.com/topic/libraries/data-binding)
* [Safeargs](https://developer.android.com/guide/navigation/navigation-pass-data)
* [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Koin](https://github.com/InsertKoinIO/koin)
* [Picasso](https://github.com/square/picasso)
* [Timber](https://github.com/JakeWharton/timber)
* [Retrofit](https://github.com/square/retrofit)


## First fragment

First fragment contains shuffle mechanism. When clicking on Shuffle button it randomly chooses a pokemon ID, passes it to the API and shows chosen pokemon 
on the screen with it's sprite and name. Clicking on pokeball icon navigates to the next fragment.



## Second fragment

Second fragment shows more information about pokemon that was chosen on first fragment. It contains it's sprite, name, id, height, weight, types and moves.
<br /> <br />

**Main fragment**
<br /> <br />
<img src="https://i.ibb.co/ZS973mF/Screenshot-from-2021-01-14-21-20-33.png" width="340px">
<br /> <br />

**Loading new pokemon**
<br /> <br />
<img src="https://i.ibb.co/pjDKWJb/Screenshot-from-2021-01-14-21-20-48.png" width="340px">
<br /> <br />

**New pokemon**
<br /> <br />
<img src="https://i.ibb.co/y8dnMWg/Screenshot-from-2021-01-14-21-21-02.png" width="340px">
<br /> <br />

**Pokemon info page**
<br /> <br />
<img src="https://i.ibb.co/bvXkM3z/Screenshot-from-2021-01-14-21-21-25.png" width="340px">

