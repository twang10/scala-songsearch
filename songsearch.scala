import scala.io.Source

class Song(a: String, t: String, l: String) {
	val artist: String = a
	val title: String = t
	var word_count:Map[String, Int] = Map()
	val lyrics:Array[String] = add_lyrics(l);

	def count(word: String) {
		/* Called .get here to return an option */
		word_count.get(word) match {
			case None => word_count += (word -> 1)
			case _ => word_count += (word -> (word_count(word) + 1))
		}
	}

	def add_lyrics(lyrics_input: String):Array[String] = {
		val lyrics:Array[String] = lyrics_input.split(" ")
		for (word <- lyrics) {
			count(word)
		}
		return lyrics
	}

	def print_lyrics() {
		for (word <- lyrics) {
			println(word + " ")
		}
		println("\n")
	}

}

class Song_List(file_name: String) {
	var songs:Vector[Song] = read_data(file_name)
	var word_map:Map[String, Array[Int]] = Map()
	
	def read_data(file_name: String):Vector[Song] = {
		val file = Source.fromFile(file_name).getLines.toArray
		var songs_vector:Vector[Song] = Vector()
  	var i = 0
  	
  	while (i < file.length) {
  		var artist = ""
  		artist += file(i)
  		i += 1
  		
  		var title = ""
  		title += file(i)
  		i += 1
  		
  		var lyrics = ""
  		while (file(i) != "<BREAK>") {
  			lyrics += file(i)
  			i += 1
  		}

  		val song_obj = new Song(artist, title, lyrics)
  		songs_vector = songs_vector :+ song_obj
  		i += 1
  	}
  	return songs_vector
	}
}

object songsearch {
	def main(args: Array[String]) {
			
		val data = new Song_List(args(0))

		val lyrics = "Oh Yeah Oh Yeah Kanye Yeah"
		val aSong = new Song("Good Problems", "Kanye", lyrics)

		println("Title: " + aSong.title)
		println("Artist: " + aSong.artist)
		println("Lyrics: "); aSong.print_lyrics()
		println("Word Count: " + aSong.word_count.values + "")

		// for (ln <- io.Source.stdin.getLines) println(ln)
		
	}
}