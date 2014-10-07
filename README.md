# scala-songsearch

This is me rewriting one of my Data Structure homework assignments from last semester in Scala. I figured it would be a quick and easy exercise to practice writing and understanding Scala. It was originally done in C++.

I'm mostly just trying to cover as many of [Odersky's Levels](http://www.scala-lang.org/old/node/8610) as possible and level up.

## What does it do?

Songsearch opens a text file the user specifies which contains a formatted list of songs and their lyircs, and stores that into a simple data structure.

This program identifies a given word as an argument, and finds the top 10 songs with the most instances of that word in the lyrics. Each song is stored within a data structure that stores all information and lyrics of each song, and
can recall information on that song almost after
has been loaded.


## Data Structures

To store and organize lyric and song information, I will use a series of data structures to make the search for songs as quickly as possible.

Here is an outline of the design of my data structure:

1. Every song is read through and stored as an object, that contains parameters for title, artist, a vector of lyrics, and a map of word frequencies. As the data base file is read in, it populates the songs vector with objects that contain all of their respective songs info.

2. A master map stores a vector of numbers for every word. Each number represents the location of the top 10 songs for where they are stored as an index within the vector of songs, so they can be accessed easily by search functions.

3. The search function iterates through the vector within the wordMap for the user-inputted keyword, and finds every instance of that word within the lyrics. It prints all of the information of each song, as well as the context in the lyrics for which the searched keyword appears. 
